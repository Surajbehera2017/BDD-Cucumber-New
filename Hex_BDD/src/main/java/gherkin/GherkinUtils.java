package gherkin;

import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import cucumber.api.DataTable;

public class GherkinUtils
{
	public static JSONArray toJSONArray(DataTable table)
	{
		try {
			Gson gson=new Gson();
			return (JSONArray) new JSONParser().parse(gson.toJson(table.raw()));
		} catch(Exception e){ e.printStackTrace(); return null; }
	}
	public static String[][] toStringArray(DataTable table)
	{
		List<List<String>> array=table.raw();
		String str[][]=new String[array.size()][];
		int i=0;
		for(List<String> tList:array)
		{
			str[i]=new String[tList.size()];
			tList.toArray(str[i++]);
		}
		return str;
	}
	public static void printLines(LinkedList<String> lines)
	{
		for(String line:lines)
			System.out.println("print : "+line);
	}
}
