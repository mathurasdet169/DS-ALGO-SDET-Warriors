package TestNG_Projects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Parallel2_findElements {

	@Test
	public static void findElements() throws InterruptedException
	{
		//Set up the driver and window
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		Thread.sleep(3000);
		//driver.manage().window().maximize();
		
		//Find the number of links in the web page and list them.
		List<WebElement> myLinkList =  driver.findElements(By.tagName("a"));
		
		//List<WebElement> myLinkList =  driver.findElements(By.xpath("//img"));
		  
		int n = myLinkList.size();
		System.out.println("My Web page has "+n+" Links. They are");
		for (int i=0; i<n; i++)
		{
			System.out.println(myLinkList.get(i).getText());
		}
		
		//Print all the images
		List<WebElement> myImgList = driver.findElements(By.tagName("img"));
		Thread.sleep(2000);
		int size = myImgList.size();
		System.out.println("My web page has "+size+" images. Their source locations are:");
		for (int i=0; i<size; i++)
		{
			System.out.println(myImgList.get(i).getAttribute("src"));
		}
		
		driver.quit();
	}

}
