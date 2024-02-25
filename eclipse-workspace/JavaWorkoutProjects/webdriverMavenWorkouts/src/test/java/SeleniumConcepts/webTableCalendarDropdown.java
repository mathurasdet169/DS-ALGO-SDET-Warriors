package SeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class webTableCalendarDropdown {

	public static void main(String[] args) 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("RESULT_TextField-0")).sendKeys("Vijaya");
		
		//driver.findElement(By.id("RESULT_TextField-2")).sendKeys("12/12/2023");
		
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		
		String month = "October"; 
		String date ="29";
		
		
	//------------------Select the Month-----------------------------
		while(true)
		{
			String Cal_Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();	
			if(Cal_Month.equals(month))
				{
				  break;
				}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			
		}

	//------------------Select the year from Drop-down-----------
		WebElement Cal_year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));	
		Select myYear = new Select(Cal_year);
		myYear.selectByValue("2028");
		
		
	//------------------Select the Date------------------------------
		
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td"));
		int d = dates.size();
				
		for(WebElement i:dates)
		{
		 String Cal_date = i.getText();
		 System.out.println(Cal_date);
		   if(Cal_date.equals(date))
			 {
				 i.click();
				 break;
			 }
		 
		}
		
		//driver.quit();
		
	}

}


