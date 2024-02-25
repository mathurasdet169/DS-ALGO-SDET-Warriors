package webdriverProj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class alertHandling {

	public static void main(String[] args) 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.manage().window().maximize();
		
		WebElement alert_btn = driver.findElement(By.id("accept"));
		alert_btn.click();
		
		//using SwitchTo to move to Simple Alert message
		Alert alert_scr = driver.switchTo().alert();
		System.out.println(alert_scr.getText());
		alert_scr.accept();
		
		//using SwitchTo and Cancel the Alert message
		driver.findElement(By.id("confirm")).click();
		Alert alert_scr2 = driver.switchTo().alert();
		String text = alert_scr2.getText();
		System.out.println(text);
		alert_scr2.dismiss();
		
		//Prompt Alert message text typing
		driver.findElement(By.id("prompt")).click();
		Alert alert_scr3 = driver.switchTo().alert();
		System.out.println(alert_scr3.getText());
		alert_scr3.sendKeys("Sankari");
		alert_scr3.accept();
		System.out.println(driver.findElement(By.id("myName")).getText());
		
		
		//Modern Alert Handling
		driver.findElement(By.id("modern")).click();
		//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	//	System.out.println(driver.findElement(By.xpath("//button[@aria-label='close']")).getAttribute("class"));
		//System.out.println(attribue);
		//driver.quit();
		
		
		
		
		
		
		
		
	}

}
