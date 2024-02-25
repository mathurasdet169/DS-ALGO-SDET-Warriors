package TestNG_Projects;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProviderFromExcel
{
	@DataProvider (name = "dp")
	public Object[][] dataFromExcel() throws IOException
	{
		
		String[][] data = excelDataUtils.excelData();
		
		return data;
	}

}
