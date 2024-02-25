package webdriverProj;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeExcelFIle {

	public static void main(String[] args) throws IOException
	{
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\files\\writefile1.xlsx");
		Scanner sc = new Scanner(System.in);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Viji");
//		
//		XSSFRow row1 = sheet.createRow(0);
//			row1.createCell(0).setCellValue("Viji");
//			row1.createCell(1).setCellValue("Jay");
//			row1.createCell(2).setCellValue("Krishna");
//			
//		XSSFRow row2 = sheet.createRow(1);
//			row2.createCell(0).setCellValue("Coimbatore");
//			row2.createCell(1).setCellValue("Chennai");
//			row2.createCell(2).setCellValue("Plano");
//			
//		XSSFRow row3 = sheet.createRow(2);
//			row3.createCell(0).setCellValue("India");
//			row3.createCell(1).setCellValue("India");
//			row3.createCell(2).setCellValue("USA");
//			
		for(int i=0; i<=2; i++)
		{
			XSSFRow currentRow = sheet.createRow(i);
			for(int c=0;c<2;c++) 
			{
				System.out.println("Enter your data...");
				currentRow.createCell(c).setCellValue(sc.next());
				
			}
		}
			
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is created...");
		
		
	}

}
