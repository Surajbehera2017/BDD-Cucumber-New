package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;

public class Base
{
	protected static HashMap<String,Object> store;
	protected static HashMap<String,Object> glbStore;
	public static JSONObject config;
	public static void initGlobalStore() { glbStore=new HashMap<>(); }
	public static void initStore() { store=new HashMap<>(); }
	
	public static void set(String key,Object value) { store.put(key,value); }
	public static void set(Object... list)
	{
		String key=null;
		Object value=null;
		int i=0;
		for(Object o:list)
			switch((i++)%2)
			{
			case 0:
				if(key!=null && value!=null)
				{
					set(key,value);
					key=null; value=null;
				}
				key=o.toString();
				break;
			case 1:
				value=o;
				break;
			}
		if(key!=null && value!=null)
			set(key,value);
	}
	public static Object get(String key){ return store.get(key); }
	public static Object remove(String key){ return store.remove(key); }
	public static String getS(String key)
	{
		Object o=get(key);
		String val=null;
		if(o!=null)
		{
			val=o.toString();
			val=val.equals("")==true?null:val;
		}
		return val;
	}
	public static int getI(String key){ return Integer.parseInt(getS(key)); }

	public static void globalSet(String key,Object value) { glbStore.put(key,value); }
	public static void globalSet(Object... list)
	{
		String key=null;
		Object value=null;
		int i=0;
		for(Object o:list)
			switch((i++)%2)
			{
				case 0:
					if(key!=null && value!=null)
					{
						globalSet(key,value);
						key=null; value=null;
					}
					key=o.toString();
					break;
				case 1:
					value=o;
					break;
			}
		if(key!=null && value!=null)
			globalSet(key,value);
	}
	public static Object globalGet(String key){ return glbStore.get(key); }
	public static Object globalRemove(String key){ return glbStore.remove(key); }
	public static String globalGetS(String key)
	{
		Object o=globalGet(key);
		String val=null;
		if(o!=null)
		{
			val=o.toString();
			val=val.equals("")==true?null:val;
		}
		return val;
	}
	public static int globalGetI(String key){ return Integer.parseInt(globalGetS(key)); }
	
	@SuppressWarnings("unchecked")
	public static List<Map<String,String>> getLstMap(String key)
	{
		Object o=get(key);
		List<Map<String,String>> val=null;
		if(o!=null)
			val=(List<Map<String, String>>) o;
		return val;
	}
		
	public static List<JSONObject> map(DataTable table)
	{
		List<DataTableRow> rows=table.getGherkinRows();
		if(rows.size()<2)	return null;
		List<String> headers=new ArrayList<String>();
		List<JSONObject> map=new LinkedList<JSONObject>();
		boolean hdrPass=true;
		for(DataTableRow row:rows)
		{
			List<String> vals=row.getCells();
			if(hdrPass)
				for(String val:vals)
				{
					headers.add(val);
					hdrPass=false;
				}
			else
			{
				JSONObject json=new JSONObject();
				int i=0;
				for(String val:vals)
					json.put(headers.get(i++), val);
				map.add(json);
			}
		}
		return map;
	}
	
	public static Map<String,String> values(List<Map<String,String>> map,String key,String value)
	{
		Map<String,String> values=new HashMap<String, String>();
		for(Map<String,String> row:map)
		{
			String tValue=row.get(key);
			if(tValue.equalsIgnoreCase(value))
			{
				Set<String> keys=row.keySet();
				Iterator<String> it=keys.iterator();
				while(it.hasNext())
				{
					String tKey=it.next();
					if(!tKey.equalsIgnoreCase(key))
						values.put(tKey,row.get(tKey));
				}
			}
		}
		return values;
	}

	public static String getFName(String name){ return name.substring(name.indexOf("/")+1); }
	public static String getLName(String name)
	{
		int ind=name.indexOf("/");
		if(ind!=-1)
			name=name.substring(0,ind);
		return name;
	}
}
