// Test cruds interface

import java.util.*;
import java.io.*;

class TestiCruds
{
	iCruds oCruds;
	Scanner sc = new Scanner(System.in);
	TestiCruds(String pClassName) 
	{
		try
		{
			oCruds = (iCruds)Class.forName(pClassName).newInstance();
		}
		catch(Exception error)
		{
			System.out.println(error);
		}
	}
	void showMenu() throws java.sql.SQLException
	{
		int operationStatus = 0;
		Dictionary<String, String> item;
		ArrayList<String[]> items = new ArrayList<String[]>();
		cUserInterface oUserInterface = new cUserInterface();
		int choice = 0;
		while (true)
		{
			System.out.println("Dmart");
			System.out.println("-".repeat(15));
			System.out.println("0. Exit\n1. Add item\n2. Show items");
			System.out.println("-".repeat(15));
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			switch (choice)
			{
				case 0: System.out.print("Database connection closed");
					System.exit(0);
				case 1: item = oUserInterface.getItem();
					operationStatus = oCruds.addItem(item);
					oUserInterface.printOperationSuccess(item.get("ItemId"), "added", operationStatus);
					break;
				case 2: items = oCruds.getItems();
					oUserInterface.printItems(items);
					break;
				default: System.out.println("Invalid choice!");
			}
		}
	}

	public static void main(String args[])
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("ClassName.cfg"));
			String className = br.readLine();
			TestiCruds oTestiCruds = new TestiCruds(className.trim());
			oTestiCruds.showMenu();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
