package common;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.DataTable;

public class Utils
{
	public static JSONObject readConfig(String fileName)
	{
		InputStream is=Utils.class.getResourceAsStream(fileName);
		org.json.simple.JSONObject obj=null;
		try {
			JSONParser p=new JSONParser();
			obj=(org.json.simple.JSONObject) p.parse(new InputStreamReader(is,StandardCharsets.UTF_8));
		} catch(IOException | ParseException e)
		{ System.out.println("error occured while trying to read the file : "+fileName); }
		JSONObject temp=null;
		if(obj!=null)
			temp=new JSONObject(obj);
		return temp;
	}
	
	public static String getRoot()
	{
		String root;
		root=System.getProperty("user.dir");
		return root;
	}
	
	public static void cc()
	{
		TakesScreenshot s=(TakesScreenshot) base.Base.getDriver();
		File f=s.getScreenshotAs(OutputType.FILE);
		try{
		FileUtils.copyFile(f,new File("./screenshot.png"));
		} catch(IOException ioe){}
	}
	
	public static byte[] ccAsArray()
	{
		TakesScreenshot s=(TakesScreenshot) base.Base.getDriver();
		byte array[]=((TakesScreenshot) base.Base.getDriver()).getScreenshotAs(OutputType.BYTES);
		return array;
	}
	
	public static Dimension getScreenSize()
	{ return Toolkit.getDefaultToolkit().getScreenSize(); }
	
	public static int getNumOfScreens()
	{
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		return ge.getScreenDevices().length;
	}
	
	public static boolean startScreenRecording(String fileName)
	{
		System.out.println("starting screen recording for : "+fileName+"..");
		try {
			URL res=Utils.class.getResource("/batch/start.bat");
			String path=FilenameUtils.getPath(res.getPath());
			File dest=new File("videos");
			dest.mkdir();
			System.out.println("res : "+dest.getAbsolutePath());
			String vlcPath=common.Base.config.getS("VLCPath");
			System.out.println("vlc path : "+vlcPath);
			String[] command = {"cmd", "/c", "start "+path+"start.bat "+vlcPath+" \""+dest.getAbsolutePath()+File.separator+fileName+"\""};
			Runtime.getRuntime().exec(command);
			return true;
		}catch (IOException ioe)
		{
			System.out.println("error occurred while starting recording!");
			return false; }
	}

	public static boolean stopScreenRecording()
	{
		System.out.println("stopping screen recording..");
		String path=null;
		try {
			path=Utils.class.getResource("/batch/stop.bat").getPath();
			path=FilenameUtils.getPath(path);
			String[] command = {"cmd", "/c", "start "+path+"stop.bat "+common.Base.config.getS("VLCPath")};
			Process p=Runtime.getRuntime().exec(command);
			p.waitFor();
			return true;
		}catch (IOException ioe)
		{
			System.out.println("error occurred while stopping recording! kindly stop manually from : "+path+"stop.bat");
			return false;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static List<String> noramlizeList(List<String> lst)
	{
		List<String> nLst=new ArrayList<>();
		for(String t:lst)
			nLst.add(t.replaceAll("[^\\w]",""));
		return nLst;
	}
	
	public static boolean compare(List<String> lst1,List<String> lst2)
	{
		for(String t:lst1) System.out.print(t+" ");
		System.out.println();
		for(String t:lst2) System.out.print(t+" ");
		lst1=noramlizeList(lst1);
		lst2=noramlizeList(lst2);
		boolean changed=false;
		changed=lst1.retainAll(lst2);
		if(changed) return false;
		changed=lst2.retainAll(lst1);
		if(changed) return false;
		return true;
	}
	
	public static boolean compare(List<String> lst,DataTable table)
	{			
		List<String> lst2=new ArrayList<>(table.asList(String.class));
		lst2.remove(0);
		return compare(lst,lst2);
	}

	public static DateTime getDateOf(String date)
	{
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
			return new DateTime(sdf.parse(date + Calendar.getInstance().get(Calendar.YEAR)));
		} catch (java.text.ParseException pe)
		{
			System.out.println("invalid date given");
			return null;
		}
	}

	public static int getDifference(DateTime date1,DateTime date2) { return Days.daysBetween(date1,date2).getDays(); }
}
