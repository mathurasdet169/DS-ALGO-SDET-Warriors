package webdriverProj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascriptScrollingAndZoom {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		//----------scroll down to certain pixels-------------
		js.executeScript("window.scrollBy(0,4500)","");
		System.out.println(js.executeScript("return window.pageYOffset"));

		//----------scroll down to the bottom of page----------
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));
		
		//--------scroll down until an element is found----------
		WebElement myItem = driver.findElement(By.xpath("//img[@alt='Flag of Nigeria']"));
		js.executeScript("arguments[0].scrollIntoView()", myItem);
		System.out.println(js.executeScript("return window.pageYOffset"));
		
		//--------Scroll up from down----------
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));

		//------------Zoom in and Zoom Out------------------
		js.executeScript("document.body.style.zoom='40%'");
		Thread.sleep(3000);

		js.executeScript("document.body.style.zoom='100%'");
		Thread.sleep(3000);
		
		js.executeScript("document.body.style.zoom='200%'");
		
		driver.quit();
		
	}

}
