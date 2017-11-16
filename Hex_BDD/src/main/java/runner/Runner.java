package runner;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Base;
import common.FeatureFormatter;
import common.Reports;
import common.Utils;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features={"src/main/resources/.compiled"},
		glue={"steps"},
		monochrome = true,
		plugin={"html:target/html-report","json:target/report.json"}
		)

public class Runner extends Reports{
	
	public Runner() {
		Reports.setProjectName("MS 365 Dynamics");
		Reports.setJSONReportPath("./target/report.json");
	}
	
  @Test
  public void test()
  {
	  System.out.println("starting cucuumber tests...");
	  new TestNGCucumberRunner(Runner.class).runCukes();
  }
  
  @BeforeTest
  public void beforeTest() throws IOException
  {
	//reading configuration
	Base.config=Utils.readConfig("/config.json");	
	System.out.println("config : "+Base.config.toJSONString());
	
	URL root;
	URL dataPath;
	
	//specify folder of the features to be run
	root=this.getClass().getResource("/demo");
	
	String path=System.getProperty("user.dir");
	System.out.println("t path : "+path);
	String dPath="file://"+path+"/Data.xlsx";
	dataPath=new URL(dPath);
	
	File dir = new File(root.getPath());
	File compRoot=new File("src/main/resources/.compiled");
	compRoot.mkdirs();
	FileUtils.cleanDirectory(compRoot);
	for(File srcFile : dir.listFiles())
	{
		if(srcFile.isDirectory()) continue;
		String fileName=srcFile.getName();			
		File compFile = new File(compRoot, fileName);
		FeatureFormatter.format(srcFile,compFile,dataPath);
	}
  }

  @AfterTest
  public void afterTest()
  {
	  //generate report
	  buildReport();
	  archiveReport();
  }

}
