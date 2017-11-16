package gherkin;

import java.util.LinkedList;

public class Scenario
{
	private String name;
	private LinkedList<Step> steps;
	private DataTable table;
	boolean isParameterized=false;
	
	public static class SCENARIO_TYPE
	{
		public static final int NORMAL=1;
		public static final int OUTLINE=2;
	}
	
	private int type;
	
	public Scenario(String name,LinkedList<Step> steps,DataTable table)
	{ this.name=name; this.steps=steps; this.table=table; }
	
	public Scenario(LinkedList<String> lines)
	{
		//int type=-1;
		LinkedList<String> stepLines=null;
		LinkedList<String> dataLines=null;
		steps=new LinkedList<Step>();
		Step step=null;
		boolean exampleStarted=false;
		for(String line:lines)
		{
			line=line.trim();
			String tLine=line.toLowerCase();
			if(tLine.equals("")) continue;
			
			if(tLine.contains("scenario outline:"))
			{
				name=line.substring(line.indexOf(":")+1).trim();
				type=SCENARIO_TYPE.OUTLINE;
			}
			else if(tLine.contains("scenario:"))
			{
				name=line.substring(line.indexOf(":")+1).trim();
				type=SCENARIO_TYPE.NORMAL;
			}
			else if(tLine.startsWith("given") || 
					tLine.startsWith("when") || 
					tLine.startsWith("then") || 
					tLine.startsWith("and") || 
					tLine.startsWith("but"))
			{
				if(stepLines!=null)
				{
					step=new Step(stepLines);
					steps.add(step);
					stepLines=null;
				}
				stepLines=new LinkedList<String>();
				stepLines.add(line);
			}
			else if(tLine.equals("examples:"))
			{
				if(stepLines!=null)
				{
					step=new Step(stepLines);
					steps.add(step);
					stepLines=null;
				}
				exampleStarted=true;
				dataLines=new LinkedList<String>();
			}
			else
			{
				if(exampleStarted)
					dataLines.add(line);
				else
					stepLines.add(line);
				isParameterized=true;
			}
		}
		if(stepLines!=null)
		{
			step=new Step(stepLines);
			steps.add(step);
		}
		if(dataLines!=null)
		{
			table=new DataTable(dataLines);
		}
	}
	
	public LinkedList<Step> getSteps(){ return steps; }
	
	public DataTable getDataTable(){ return table; }
	
	public boolean isParameterized(){ return isParameterized; }
	
	public LinkedList<String> getLines()
	{
		LinkedList<String> lines=new LinkedList<String>();
		
		if(type==SCENARIO_TYPE.NORMAL)
			lines.add("Scenario: "+name);
		else if(type==SCENARIO_TYPE.OUTLINE)
			lines.add("Scenario Outline: "+name);
		StringBuilder rowLine=new StringBuilder("|");
		for(Step step:steps)
		{
			lines.addAll(step.getLines());
		}
		if(type==SCENARIO_TYPE.OUTLINE)
		{
			lines.add("Examples:");
			lines.addAll(table.getLines());
		}
		//GherkinUtils.printLines(lines);
		return lines;
	}
	
	public void setDataTable(LinkedList<String> dataLines)
	{
		table=new DataTable(dataLines);
	}
}
