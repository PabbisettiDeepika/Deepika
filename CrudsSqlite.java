// To implement iCruds to perform CRUDS operations using sqlite database

import java.util.*;
import java.sql.*;

class cCrudsSqlite implements iCruds
{
	Connection conn = null;
	Statement statement = null;
	String query, tableName = "Item";
	Scanner sc = new Scanner(System.in);

	cCrudsSqlite()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:D:\\Training\\PythonPrograms\\dmart.db");
			statement = conn.createStatement();
		}
		catch (Exception error)
		{
			System.out.println(error);
		}
	}

	public int addItem(Dictionary<String, String> pItem)
	{
		PreparedStatement pStatement = null;
		int isItemAdded = 0;
		query = "Insert into "+ tableName + "(ItemId, Description, UnitPrice, StockQty, SupplierId) values(?, ?, ?, ?, ?);";
		try
		{
			pStatement = conn.prepareStatement(query);
			pStatement.setString(1, pItem.get("ItemId"));
			pStatement.setString(2, pItem.get("Description"));
			pStatement.setInt(3, Integer.parseInt(pItem.get("UnitPrice")));
			pStatement.setInt(4, Integer.parseInt(pItem.get("StockQty")));
			pStatement.setString(5, pItem.get("SupplierId"));
			isItemAdded = pStatement.executeUpdate();
		}
		catch(Exception error)
		{
			System.out.println(error);
		}
		return isItemAdded;
	}

	public ArrayList<String[]> getItems()
	{
		query = "select * from " + tableName + ";";
		ArrayList<String[]> items = new ArrayList<String[]>();
		String item[] = new String[5];
		ResultSet itemsSet = null;
		try
		{
			itemsSet = statement.executeQuery(query);
			while(itemsSet.next()) 
			{
				for (int counter = 0; counter < 5; counter++)
				{
					item[counter] = itemsSet.getString(counter + 1);
				}
				items.add(item);
			}
		}
		catch(Exception error)
		{
			System.out.print(error);
		}
		return items;
	}
}
