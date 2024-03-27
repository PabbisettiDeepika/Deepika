// To implement iCruds to perform CRUDS operations using MySQL database

import java.util.*;
import java.sql.*;

class cCrudsMysql implements iCruds
{
	Connection conn = null;
	Statement statement = null;
	String query, tableName = "Item";
	Scanner sc = new Scanner(System.in);

	cCrudsMysql()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://138.68.140.83:3306/dbDeepika?useUnicode=true&characterEncoding=UTF-8","Deepika", "Deepika@123");
			statement = conn.createStatement();
		}
		catch(Exception error)
		{
			System.out.println(error);
		}
	}

	public int addItem(Dictionary<String, String> pItem)
	{
		PreparedStatement pStatement;
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
		catch(SQLException error)
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