// User interface for cruds operations on item

import java.util.*;

class cUserInterface
{
	String fieldNames[] = {"ItemId", "Description", "UnitPrice", "StockQty", "SupplierId"};
	Scanner sc = new Scanner(System.in);
	public Dictionary getItem()
	{
		Dictionary<String, String> item = new Hashtable();
		for (int counter = 0; counter < 5; counter++)
		{
			System.out.print("Enter " + fieldNames[counter] + ": ");
			item.put(fieldNames[counter], sc.nextLine());
		}
		return item;
	}

	public void printItems(ArrayList<String[]> pItems)
	{
		for (String item[]: pItems)
		{
			for (int counter = 0; counter < 5; counter++)
			{
				System.out.println(fieldNames[counter] + ": " + item[counter]);
			}
			System.out.println("-".repeat(15));
		}
		System.out.print("\n");
	}

	public void printOperationSuccess(String pItemId, String pOperation, int pOperationStatus)
	{
		if (pOperationStatus == 1)
		{
			System.out.println("Item " + pItemId + " " + pOperation + " successfully.");
		}
	}
}