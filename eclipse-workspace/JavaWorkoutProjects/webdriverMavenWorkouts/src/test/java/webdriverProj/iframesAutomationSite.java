package webdriverProj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframesAutomationSite {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		driver.switchTo().frame("frame-one796456169");
		driver.findElement(By.id("RESULT_TextField-0")).sendKeys("Srikrishna");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).sendKeys("Sunshine");
		
		
	}

}
