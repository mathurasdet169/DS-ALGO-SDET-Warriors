package TestNG_Projects;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class excelDataUtils {

	public static String[][] excelData() throws IOException 
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\files\\ExcelDataProvider.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int TotalRows = sheet.getLastRowNum();
		int TotalCells = sheet.getRow(1).getLastCellNum();
		
		//System.out.println("The Excel has "+TotalRows+" rows and "+TotalCells+" cells");
		
		String[][] myData = new String[TotalRows][TotalCells];
		
		for(int r=1; r<=TotalRows; r++)
		{
			XSSFRow row = sheet.getRow(r);
			
			for(int c=0; c<TotalCells; c++)
			{
				XSSFCell cell = row.getCell(c);
				DataFormatter test = new DataFormatter();
				String value = cell.getStringCellValue();
				myData[r-1][c]=value;
			}
			
			
		}

		
		workbook.close();
		file.close();
		return myData;
		
	}

}
