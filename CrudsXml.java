// To implement iCruds to perform CRUDS operations on XML

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.io.File;
import java.util.*;

class cCrudsXml implements iCruds
{
	String dataFile = "items.xml";
	int fieldsCount = 5;
	Document document;
	Element items, item, field;
	cCrudsXml()
	{
		try
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	        document = docBuilder.parse(dataFile);
	        items = document.getDocumentElement();
	    }
	    catch(Exception error)
	    {
	    	System.out.println(error);
	    }
	}

	public int addItem(Dictionary<String, String> pItem)
	{
		String fieldName;
		int isItemAdded = 0;
        item = document.createElement("Item");
		String fieldNames[] = {"ItemId", "Description", "UnitPrice", "StockQty", "SupplierId"};
		for (int counter = 0; counter < fieldsCount; counter++)
		{  
			field = document.createElement(fieldNames[counter]);
			field.setTextContent(pItem.get(fieldNames[counter]));
			item.appendChild(field);
		}  
		items.appendChild(item);
		isItemAdded = 1;
		saveItems();
		return isItemAdded;
	}

	public ArrayList<String[]> getItems()
	{
		ArrayList<String[]> items = new ArrayList<String[]>();
	    NodeList itemsList = this.items.getElementsByTagName("Item");
	    for (int counter = 0; counter < itemsList.getLength(); counter++)
	    {
			String item[] = new String[fieldsCount];
            Element element = (Element) itemsList.item(counter);
            item[0] = element.getElementsByTagName("ItemId").item(0).getTextContent();
            item[1] = element.getElementsByTagName("Description").item(0).getTextContent();
           	item[2] = element.getElementsByTagName("UnitPrice").item(0).getTextContent();
            item[3] = element.getElementsByTagName("StockQty").item(0).getTextContent();
            item[4] = element.getElementsByTagName("SupplierId").item(0).getTextContent();
	        items.add(item);
		}
	    return items;
	}

	void saveItems()
	{
		try
		{
			DOMSource source = new DOMSource(items);
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        Result result = new StreamResult(new File(dataFile));
	        transformer.transform(source, result);
	    }
	    catch(Exception error)
	    {
	    	System.out.println(error);
	    }
	}
}
