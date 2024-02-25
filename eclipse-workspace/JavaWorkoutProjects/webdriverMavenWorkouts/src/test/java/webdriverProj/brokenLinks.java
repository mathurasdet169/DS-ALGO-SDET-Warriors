package webdriverProj;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLinks {

	public static void main(String[] args) throws IOException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		
		System.out.println("Total number of links available: "+linkList.size());
		
		int NoOfBrokenLink = 0;
		
		for(WebElement i:linkList)
		{
			String linkhref = i.getAttribute("href");// Get the Attribute value of "href"
			
			if(linkhref.isEmpty()||linkhref.equals(null))
			{
				System.out.println("The href attribute is not available and hence cant determine whether its a broken link or not");
				continue;
			}
			
			try {
			URL linkUrl = new URL(linkhref); //changing String into URL
			HttpURLConnection connection =(HttpURLConnection)linkUrl.openConnection(); //create connection to the server
			connection.connect();//Connect it to Server
			
			if(connection.getResponseCode()>=400)
			{
				System.out.println(linkhref+"====>This is a broken link...");
				NoOfBrokenLink++;
			}
			else
			{
				System.out.println(linkhref+"====>This link is not Broken..");
			}
			}catch(Exception e)
			{
				
			}
		
		}
			
		System.out.println("Total number of broken links are: "+NoOfBrokenLink);
		
		driver.quit();
				
	}

}
