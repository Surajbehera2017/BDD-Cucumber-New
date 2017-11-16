package gherkin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Story
{
	private String name;
	private LinkedList<Scenario> scenarios;
	
	public Story(File file) throws IOException
	{
		BufferedReader reader=new BufferedReader(new FileReader(file));
		scenarios=new LinkedList<Scenario>();
		String line;
		LinkedList<String> tempSce=null;
		boolean started=false;
		while((line=reader.readLine())!=null)
		{
			String tLine=line.toLowerCase().trim();
			if(tLine.contains("scenario:") || tLine.contains("scenario outline:"))
			{
				if(tempSce!=null)
					scenarios.add(new Scenario(tempSce));
				tempSce=new LinkedList<String>();
				tempSce.add(line);
				started=true;
			}
			else if(tLine.contains("feature:"))
				name=line.substring(line.indexOf(":")+1).trim();
			else if(started)
				tempSce.add(line);
		}
		if(tempSce!=null)
			scenarios.add(new Scenario(tempSce));
	}
	
	public String getName(){ return name; }
	
	public LinkedList<Scenario> getScenarios(){ return scenarios; }
	
	public LinkedList<String> getLines()
	{
		LinkedList<String> lines=new LinkedList<String>();
		
		if(name!=null)
			lines.add("Feature: "+name);
		for(Scenario scenario:scenarios)
			lines.addAll(scenario.getLines());
		//GherkinUtils.printLines(lines);
		return lines;
	}
}
