package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class keyBoardActions {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://text-compare-online.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("inputText1")).sendKeys("Testing");
		Actions builder = new Actions(driver);
		
		//---Perform Ctrl+A--------Keyboard Action----Using Actions Method
		builder.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		Thread.sleep(1000);
		
		//------------------Perform Ctrl+C-----------------
		builder.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		Thread.sleep(1000);
		
		//----------------------Press TAB------------------
		builder.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		Thread.sleep(1000);
		
		//------------------------Perform Ctrl+V------------------
		builder.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		Thread.sleep(1000);
		
		//------------------------Press ENTER----------------------
				builder.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
				Thread.sleep(1000);
				//---------OR-----------Can use Return-------------
				builder.keyDown(Keys.RETURN).keyUp(Keys.RETURN).perform();
				Thread.sleep(1000);
				
		
		//---------------------------Ctrl+Shift+A--------------------
		builder.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
		
		
			}

}
