package common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.joda.time.LocalDateTime;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class Reports {
	
	public static String projectName;
	public static String jsonReportPath;

	public static void setProjectName(String projectName) { Reports.projectName=projectName; }
	public static void setJSONReportPath(String reportPath) { Reports.jsonReportPath=reportPath; }
	
public static void buildReport(){
	 //Cucumber Report
	  File f=new File("target");
	  List<String> json=new ArrayList<>();
	  json.add(jsonReportPath);
	  
	  String build="1";
	  //String projectName="MS Dynamics 365";
	  
	  Configuration cf=new Configuration(f,projectName);
	  cf.setBuildNumber(build);
	  cf.setParallelTesting(false);
	  cf.setRunWithJenkins(false);
	  cf.addClassifications("Platform","Windows");
	  cf.addClassifications("Browser","Chrome 61.0");
	  
	  ReportBuilder rb=new ReportBuilder(json,cf);
	  Reportable r=rb.generateReports();
	  
	 
}
public static void archiveReport(){ 
	
	//Cucumber Report Archive
	
	File dirReport=new File("target/cucumber-html-reports");
	File dirArchive=new File("target/reports-archive");
	
	LocalDateTime now = LocalDateTime.now();
	int year = now.getYear();
	int month = now.getMonthOfYear();
	int day = now.getDayOfMonth();
	int hour = now.getHourOfDay();
	int minute = now.getMinuteOfHour();
	int second = now.getSecondOfMinute();

	String snewFilename1 = year + "_" + month + "_" + day + "_" + hour + "_" + minute + "_" + second;

	File f3 = new File(dirArchive + "\\" + snewFilename1);
	
	try {
		if(dirReport.exists() && dirReport.listFiles().length>0)
		{
			f3.mkdir();
			FileUtils.copyDirectory(dirReport,f3);
		}
	} catch (IOException e) {
	e.printStackTrace();
	}
}

	
}
