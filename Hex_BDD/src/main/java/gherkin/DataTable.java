package gherkin;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataTable
{
	private LinkedList<String> headers;
	private LinkedList<LinkedList<String>> values;
	
	public DataTable(LinkedList<String> headers,LinkedList<LinkedList<String>> values)
	{
		this.headers=headers;
		this.values=values;
	}
	
	public DataTable(LinkedList<String> lines)
	{
		values=new LinkedList<LinkedList<String>>();
		boolean headersRead=false;
		Iterator<String> it=null;
		for(String line:lines)
		{
			if(!headersRead)
			{
				headers=new LinkedList<String>();
				Pattern p=Pattern.compile("\\|([\\w]*[^\\|])");
				Matcher m=p.matcher(line);
				while(m.find())
					headers.add(m.group(1));
				it=headers.iterator();
				headersRead=true;
			}
			else
			{
				LinkedList<String> row=new LinkedList<String>();
				Pattern p=Pattern.compile("\\|([\\w,-/\\s@]*[^\\|])");
				Matcher m=p.matcher(line);
				while(m.find())
					row.add(m.group(1));
				values.add(row);
			}
		}
	}
	
	public LinkedList<String> getHeaders()
	{ return headers; }
	
	public LinkedList<String> getRowValues(int rowIndex)
	{ return values.get(rowIndex); }
	
	public LinkedList<String> getLines()
	{
		LinkedList<String> lines=new LinkedList<String>();
		
		StringBuilder line=new StringBuilder("|");
		for(String header:headers)
			line.append(header).append("|");
		lines.add(line.toString());
		
		for(LinkedList<String> row:values)
		{
			line=new StringBuilder("|");
			for(String value:row)
				line.append(value).append("|");
			lines.add(line.toString());
		}
		//GherkinUtils.printLines(lines);
		return lines;
	}
}
