package SeleniumConcepts;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoTestingPrac {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		List<WebElement> links = driver.findElements(By.xpath("//div[@id= 'wikipedia-search-result-link']/a"));


		System.out.println("The number of links for given search is  : \t"+links.size());

		System.out.println("The text on each link are :\n");
		for( WebElement i: links)
		{
			System.out.println(i.getText());
			i.click();
		}
		
		Set<String> wind_Ids = driver.getWindowHandles();
		System.out.println(wind_Ids);
		System.out.println("Total number of windows opened are "+wind_Ids.size());
		
		for(String i:wind_Ids)
		{
			String Title = driver.switchTo().window(i).getTitle();
			
			if (Title.equals("Selenium dioxide - Wikipedia") || Title.equals("Selenium in biology - Wikipedia"))
				driver.close();
			
		}	
			//Selenium - Wikipedia,  Selenium in biology - Wikipedia, Selenium (software) - Wikipedia, 
			//Selenium disulfide - Wikipedia, Selenium dioxide - Wikipedia
		
		Set<String> final_Windows = driver.getWindowHandles();
		System.out.println(" The number of windows open after closing 2 windows are "+final_Windows.size());
		
		driver.quit();
		
	}

}
