package webdriverProj;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class rightClick {

	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		
		//---------------Perform Right Click Action--------------------
		
		WebElement rt_click = driver.findElement(By.xpath("//span[.='right click me']"));
		Actions builder = new Actions(driver);
		builder.contextClick(rt_click).perform();
		
		WebElement edit = driver.findElement(By.xpath("//span[.='Edit']"));
		System.out.println("The text in the link is : "+edit.getText());
		edit.click();
		
		Alert myAlert = driver.switchTo().alert();
		System.out.println("Text of Alert is : "+myAlert.getText());
		myAlert.accept();
		
		//-----------Perform Double Click Action ----------------------
		
		WebElement dbl_click = driver.findElement(By.xpath("//button[.='Double-Click Me To See Alert']"));
		System.out.println("The Text on the Double Click button is: "+dbl_click.getText());
		builder.doubleClick(dbl_click).perform();
	
		Alert alert2 = driver.switchTo().alert();
		System.out.println("The text of double click alert is : "+alert2.getText());
		alert2.accept();
		
		driver.quit();
		
	}

}
