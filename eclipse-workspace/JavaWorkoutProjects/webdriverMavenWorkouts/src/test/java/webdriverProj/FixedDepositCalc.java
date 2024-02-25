package webdriverProj;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDepositCalc {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//----Open the app------------
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		driver.manage().window().maximize();
		
		//--------Read the data from Excel and pass it to app------
		String file = System.getProperty("user.dir")+"\\files\\caldata.xlsx";
		int rowNo = ExcelUtils.getRowCount(file,"Sheet1");
		
		for(int r=1; r<=rowNo; r++)
		{
			//------------Read cell data into a String-----
			String Principal = ExcelUtils.getCellData(file, "Sheet1",r, 0);
			String ROI = ExcelUtils.getCellData(file, "Sheet1",r, 1);
			String Period = ExcelUtils.getCellData(file, "Sheet1",r, 2);
			String PeriodTime = ExcelUtils.getCellData(file, "Sheet1",r, 3);
			String Frequency = ExcelUtils.getCellData(file, "Sheet1",r, 4);
			String Mat_Value = ExcelUtils.getCellData(file, "Sheet1",r, 5);
			
			//--------Pass the String value to app text fields---------------
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(Principal);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(ROI);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(Period);
			
			//--pass to drop down field----
			Select myvalue = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			myvalue.selectByVisibleText(PeriodTime);
			
			Select myFreq = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			myFreq.selectByVisibleText(Frequency);
			
			//---Click Calculate Button
			
			driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
			Thread.sleep(3000);
			String App_Mat_Value = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			
			//----------------Validate Maturity Value-------------------
			if(Double.parseDouble(App_Mat_Value)==Double.parseDouble(Mat_Value))
			{
				System.out.println("Test Passed...");
				ExcelUtils.setCellData(file, "Sheet1", r, 7, "Passed");
			}
			else
			{
				System.out.println("Test Failed...");
				ExcelUtils.setCellData(file, "Sheet1", r, 7, "Failed");
	
			}
			
			driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_clear.gif']")).click();
			Thread.sleep(3000);				
		}
		
		
		
		driver.quit();
				
	}

}
