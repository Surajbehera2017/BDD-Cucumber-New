package common;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel
{
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public Excel(File file)
	{
		openWorkBook(file);
	}
	
	public void openWorkBook(String pathToWorkBook)
	{
		openWorkBook(new File(pathToWorkBook));
	}
	
	public void openWorkBook(File file)
	{
		try {
		workbook=new XSSFWorkbook(file);
		} catch (InvalidFormatException ifme)
		{ System.out.println("invalid excel file encountered.");}
		catch (IOException ioe)
		{ System.out.println("issue encountered while reading file.");}
	}
	
	public void setActiveSheet(String sheetName)
	{
		System.out.println("setting "+sheetName+" as active sheet..");
		sheet=workbook.getSheet(sheetName);
	}
	
	public void goToSheet(String sheetName)
	{
		workbook.getSheet("");
	}
	
	public LinkedHashMap<String,LinkedList<String>> readScenarioData(String scenarioID)
	{
		System.out.println("sheet name : "+sheet.getSheetName());
		Iterator<Row> rows=sheet.iterator();
		DataFormatter f=new DataFormatter();
		XSSFFormulaEvaluator ev=new XSSFFormulaEvaluator(workbook);
		Row row;
		String tscID;
		boolean start=false;
		LinkedHashMap<String,LinkedList<String>> data=new LinkedHashMap<String, LinkedList<String>>();
		while(rows.hasNext())
		{
			row=rows.next();
			Cell cell=row.getCell(0);
			//System.out.println("cell : "+cell.getStringCellValue());
			if(!start)
			{
				if(cell!=null && !cell.getStringCellValue().trim().equals(""))
				{
					tscID=cell.getStringCellValue();
					if(tscID.equalsIgnoreCase(scenarioID))
					{
						start=true;
						Iterator<Cell> cells=row.cellIterator();
						cells.next();
						cell=cells.next();
						String header=cell.getStringCellValue();
						LinkedList<String> values=new LinkedList<String>();
						while(cells.hasNext())
						{
							cell=cells.next();
							String value=f.formatCellValue(cell).trim();
							if(value.equals("")) break;
							values.add(value);							
						}
						data.put(header, values);
						start=true;
					}
				}
			}
			else
			{				
				Iterator<Cell> cells=row.cellIterator();
				//if first cell of row is not empty then break
				if(!f.formatCellValue(cell).equals("")) break;
				while(cells.hasNext() && f.formatCellValue((cell=cells.next())).equals(""));
				//if there is no more non empty cell in the row then break
				if(!cells.hasNext()) break;
				
				String header=cell.getStringCellValue();
				LinkedList<String> values=new LinkedList<String>();
				while(cells.hasNext())
				{					
					cell=cells.next();
					String value;
					if(cell.getCellTypeEnum()==CellType.FORMULA)
						value=ev.evaluate(cell).getStringValue();
					else
						value=f.formatCellValue(cell).trim();
					if(value.equals("")) break;
					System.out.println("val : "+value);
					values.add(value);							
				}
				data.put(header, values);
			}			
		}
		return data;
	}
	
	public LinkedHashMap<String,LinkedList<String>> readScenarioData_old(String scenarioID)
	{
		Iterator<Row> rows=sheet.iterator();
		Row row;
		String tscID;
		boolean start=false;
		LinkedHashMap data=new LinkedHashMap<String, LinkedList<String>>();
		while(rows.hasNext())
		{
			row=rows.next();
			Cell cell=row.getCell(0);
			
			if(!start)
			{
				if(cell!=null)
				{
					tscID=cell.getStringCellValue();
					if(tscID.equalsIgnoreCase(scenarioID))
					{
						start=true;
						Iterator<Cell> cells=row.cellIterator();
						cells.next();
						while(cells.hasNext())
						{
							cell=cells.next();
							data.put(cell.getStringCellValue(),new LinkedList<String>());
						}
						continue;
					}
				}
			}
			else
			{
				if(cell!=null)
					break;
				
				Iterator<Cell> cells=row.cellIterator();
				//cells.next();
				Iterator headers=data.keySet().iterator();
				while(cells.hasNext())
				{
					cell=cells.next();
					((LinkedList<String>)data.get(headers.next())).add(cell.getStringCellValue());
				}
			}
			
			
			
		}
		return data;
	}
}
