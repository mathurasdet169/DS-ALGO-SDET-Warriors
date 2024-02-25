package webdriverProj;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class openLinkInNewTab {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement regLink = driver.findElement(By.linkText("Register"));
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		
		List<String> windowsID = new ArrayList(driver.getWindowHandles());
		System.out.println(windowsID);
		driver.switchTo().window(windowsID.get(1));
		
		driver.findElement(By.id("FirstName")).sendKeys("MySaiRam");
		driver.switchTo().window(windowsID.get(0));
		driver.findElement(By.id("small-searchterms")).sendKeys("laptop");
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER);
		
		driver.quit();		
		
		
	}

}
