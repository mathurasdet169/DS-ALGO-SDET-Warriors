package webdriverProj;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\files\\SeleniumTrial.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int TotalRows = sheet.getLastRowNum();
		int TotalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("The Excel has "+TotalRows+" rows and "+TotalCells+" cells");
		
		for(int r=0; r<=TotalRows; r++)
		{
			XSSFRow row = sheet.getRow(r);
			
			for(int c=0; c<TotalCells; c++)
			{
				XSSFCell cell = row.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
			
			System.out.println("");
		}

		
		workbook.close();
		file.close();
		
	}

}
