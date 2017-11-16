package gherkin;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Step
{
	public static class STEP_TYPE
	{
		static final int GIVEN=1;
		static final int WHEN=2;
		static final int THEN=3;
		static final int AND=4;
		static final int BUT=5;
	}
	public static class STEP_FORMAT
	{
		public static final int BASIC=1;
		public static final int PARAMETERISED=2;
		public static final int INLINE=3;
	}
	
	private int type;
	private int format;
	private String description;
	LinkedList<String> params;
	LinkedList<LinkedList<String>> values;
	
	public Step(LinkedList<String> lines)
	{
		boolean firstLine=true;
		values=new LinkedList<LinkedList<String>>();
		for(String line:lines)
		{
			line=line.trim();
			if(firstLine)
			{
				String tLine=line.toLowerCase();
				if(tLine.startsWith("given"))
				{
					type=STEP_TYPE.GIVEN;
					description=line.substring(6);
				}
				else if(tLine.startsWith("when"))
				{
					type=STEP_TYPE.WHEN;
					description=line.substring(5);
				}
				else if(tLine.startsWith("then"))
				{
					type=STEP_TYPE.THEN;
					description=line.substring(5);
				}
				else if(tLine.startsWith("and"))
				{
					type=STEP_TYPE.AND;
					description=line.substring(4);
				}
				else if(tLine.startsWith("but"))
				{
					type=STEP_TYPE.BUT;
					description=line.substring(4);
				}
				description=description.trim();
				
				Pattern p=Pattern.compile("<([\\w]*)>");
				Matcher m=p.matcher(description);
				params=new LinkedList<String>();
				while(m.find())
					params.add(m.group(1));
				if(params.size()>=0)
					format=STEP_FORMAT.PARAMETERISED;
				else
					format=STEP_FORMAT.BASIC;
				firstLine=false;
			}
			else
			{
				format=STEP_FORMAT.INLINE;
				Pattern p=Pattern.compile("\\|([\\w,/]*[^\\|])");
				Matcher m=p.matcher(line);
				LinkedList<String> row=new LinkedList<String>();
				while(m.find())
					row.add(m.group(1));
				values.add(row);
			}
			
		}
		
	}
	
	public int getStepType(){ return type; }
	public int getStepFormat(){ return format; }
	public String getDescription(){ return description; }
	public LinkedList<String> getParameters(){ return params; }
	public LinkedList<LinkedList<String>> getInlineData(){ return values; }
	
	public LinkedList<String> getLines()
	{
		LinkedList<String> lines=new LinkedList<String>();
		String prefix="";
		switch (type) {
		case STEP_TYPE.GIVEN:
			prefix="Given";
			break;
		case STEP_TYPE.WHEN:
			prefix="When";
			break;
		case STEP_TYPE.THEN:
			prefix="Then";
			break;
		case STEP_TYPE.AND:
			prefix="And";
			break;
		case STEP_TYPE.BUT:
			prefix="But";
			break;
		}
		lines.add(prefix+" "+description);
		StringBuilder rowLine;
		for(LinkedList<String> row:values)
		{
			rowLine=new StringBuilder("|");
			for(String value:row)
			{
				if(value.equals("")) continue;
				rowLine.append(value).append("|");
			}
			lines.add(rowLine.toString());
		}
		//GherkinUtils.printLines(lines);
		return lines;
	}
	
	public void setValues(LinkedList<String> dataLines)
	{
		Pattern p=Pattern.compile("\\|([^\\|]*)");
		values=new LinkedList<LinkedList<String>>();
		for(String line:dataLines)
		{
			Matcher m=p.matcher(line);
			LinkedList<String> row=new LinkedList<String>();
			while(m.find())
			{
				String t=m.group(1);
				if(t.equals("")) continue;
				System.out.println("t "+t);
				row.add(t);
			}
			values.add(row);
		}
	}
}
