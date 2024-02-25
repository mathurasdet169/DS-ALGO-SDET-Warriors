package webdriverProj;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datePickerPractice {

	public static void main(String[] args)
	{
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		//-----------Method1--Enter the date, month and year through text box-----------
//		driver.switchTo().frame(0);
//		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("11/14/2023");
		
		//--------------Method 2 -------Using Logics--------------------
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		String year ="2024", month = "December", date = "21";
		
		selectMonthYear(driver, month, year);
		
		selectDate(driver, date);
		
		String SelectedDate = driver.findElement(By.xpath("//input[@id='datepicker']")).getText();
		System.out.println(SelectedDate);
		
		driver.quit();
		
	}	
	
	
	
	static void selectMonthYear(WebDriver driver, String month, String year)
	{
		//----------Move to required Month and Year----------------
				while(true)
				{
				String CalMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				String CalYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				
					if(CalMonth.equals(month) && CalYear.equals(year))
					{
						break;		
					}
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();	
					
				}
	}
	
	
	
	static void selectDate(WebDriver driver, String date)
		{
			//---------------Select the Date--------------
					List<WebElement> CalDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
					
					for(WebElement i:CalDates)
					{
						if(i.getText().equals(date))
							i.click();
					}
					
		}
	
	
		
}
