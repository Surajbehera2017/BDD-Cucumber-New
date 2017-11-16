package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import gherkin.DataTable;
import gherkin.Scenario;
import gherkin.Step;
import gherkin.Step.STEP_FORMAT;
import gherkin.Story;

public class FeatureFormatter
{
	public static void format(File srcFeatureFile,File destFeatureFile,URL dataFilePath) throws IOException
	{
		format(srcFeatureFile,destFeatureFile,new File(dataFilePath.getPath()));
	}
	
	public static void format(File srcFeatureFile,File destFeatureFile,File dataFile) throws IOException
	{
		System.out.println("dfile : "+dataFile.getAbsolutePath());
		Story story=new Story(srcFeatureFile);
		//GherkinUtils.printLines(story.getLines());
		
		String storyName=story.getName();
		System.out.println("story name : "+storyName);
		Excel excel=new Excel(dataFile);
		excel.setActiveSheet(storyName);
		
		for(Scenario scenario:story.getScenarios())
		{
			if(scenario.isParameterized())	//a parameterized scenario is expected to also be of scenario_outline type
			{
				DataTable table=scenario.getDataTable();
				LinkedList<String> headers=table.getHeaders();
				String sceID="";
				if(headers.size()==1 && headers.get(0).equalsIgnoreCase("id"))
				{
					sceID=table.getRowValues(0).get(0);
					LinkedHashMap<String,LinkedList<String>> data=excel.readScenarioData(sceID);
					Set<String> set=data.keySet();
					Iterator<String> it;
					for(Step step:scenario.getSteps())
						//block to only handle INLINE steps
						if(step.getStepFormat()==STEP_FORMAT.INLINE)
						{
							LinkedList<String> iData=step.getInlineData().get(0);
							List<String> newHeaders=new LinkedList<String>();
							LinkedList<LinkedList<String>> newData=new LinkedList<LinkedList<String>>();
							for(String iDataParam:iData)
							{
								it=set.iterator();
								while(it.hasNext())
								{
									String param=it.next();
									if(param.equalsIgnoreCase(iDataParam))
									{
										newData.add(data.get(param));
										newHeaders.add(param);
										it.remove();
									}
								}
							}
							LinkedList<String> newDataLines=new LinkedList<String>();
							StringBuilder line=new StringBuilder("|");
							for(String header:newHeaders)
								line.append(header).append("|");
							newDataLines.add(line.toString());
							for(int i=0;i<newData.get(0).size();++i)
							{
								line=new StringBuilder("|");
								for(int j=0;j<newData.size();++j)
									line.append(newData.get(j).get(i)).append("|");
								newDataLines.add(line.toString());
							}
							step.setValues(newDataLines);
						}
					//set=data.keySet();
					LinkedList<String> dataLines=new LinkedList<String>();
					StringBuilder line=new StringBuilder("|");
					it=data.keySet().iterator();
					while(it.hasNext())
						line.append(it.next()).append("|");
					dataLines.add(line.toString());
					
					int numOfRows=data.get(data.keySet().iterator().next()).size();
					for(int i=0;i<numOfRows;++i)
					{
						line=new StringBuilder("|");
						it=data.keySet().iterator();						
						while(it.hasNext())
							line.append(data.get(it.next()).get(i)).append("|");
						dataLines.add(line.toString());
					}
					scenario.setDataTable(dataLines);
				}
			}
		}
		
		//GherkinUtils.printLines(story.getLines());
		BufferedWriter writer=new BufferedWriter(new FileWriter(destFeatureFile));
		for(String line:story.getLines())
			writer.write(line+"\n");
		writer.close();
	}
}
