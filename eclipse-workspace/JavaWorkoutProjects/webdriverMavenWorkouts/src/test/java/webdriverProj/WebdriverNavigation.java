package webdriverProj;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebdriverNavigation {

	public static void main(String[] args) throws InterruptedException {
		//1. Launch Chrome Browser
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://demo.opencart.com");
			
		
			
					
		//3. Validate Title of page is "Your STore" or not
			String act_Title = driver.getTitle();
			if(act_Title.equals("Your Store"))
				System.out.println("The Title test got passed.");
			else
				System.out.println("The Title test got failed.");
			
			String url = driver.getCurrentUrl();
			System.out.println("The URL '"+url+"' is opened now.");
			
			//String PageSource = driver.getPageSource();
			//System.out.println(PageSource);
			
			String Win_Handle = driver.getWindowHandle();
			System.out.println("The unique Alphanumeric Id of this window is: "+Win_Handle);
			Thread.sleep(5000);
			
			//checking the TABLETS LINK click
			driver.findElement(By.xpath("//*[@id=\'narbar-menu\']/ul/li[4]/a")).click();
			String Title = driver.getTitle();
			System.out.println("The Title of this web page is: "+Title);
			Thread.sleep(2000);
			
			if (Title.equals("Tablets"))
				System.out.println("The TABLET LINK click took you to proper page.");
			else
				System.err.println("The Tablet LINK test got failed.");
			
			//checking the back button navigation
			driver.navigate().back();
			url = driver.getCurrentUrl();
			if (url.equals("https://demo.opencart.com/"))
				System.out.println("The back button test got passed.");
			else
				System.err.println("The back button test failed.");
				
			//checking the forward navigation				
			driver.navigate().forward();
			Title = driver.getTitle();
			if (Title.equals("Tablets"))
				System.out.println("The forward test got passed.");
			else
				System.err.println("The forward test failed.");
			
			//checking the refresh navigation				
			driver.navigate().refresh();
			Title = driver.getTitle();
			System.out.println("We have moved refreshed "+Title+" web page.");
			
			
			//Test navigate().to option
			driver.navigate().to("https://demo.nopcommerce.com");
			Title = driver.getTitle();
			System.out.println("We have navigated to "+Title+" webpage");
			
			Set<String> WindowsAll = driver.getWindowHandles();
			System.out.println("The unique Alphanumeric Id of all the windows are: "+WindowsAll);

		//4. Close the browser after test
			//driver.quit();
			
		
	}

}
