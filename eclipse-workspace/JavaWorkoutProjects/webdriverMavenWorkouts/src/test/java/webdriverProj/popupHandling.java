package webdriverProj;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class popupHandling {

	public static void main(String[] args) 
	{
	ChromeDriver driver = new ChromeDriver();
	WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10)); // Explicit Wait Declaration
	
	
	//Handling popup window with username and P/w by INJECTION method
	driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	
	driver.get("https://mypage.rediff.com/");
	driver.findElement(By.xpath("//input[@value=' Go ']")).click();
	
	//Handling using switchTo() method
//	Alert myAlert = driver.switchTo().alert();
//	System.out.println("The text in the Alert is: "+myAlert.getText());
//	myAlert.accept();

	//Handling Alert using Explicit Wait() Method
	Alert myAlert = myWait.until(ExpectedConditions.alertIsPresent());
	System.out.println("The text in the Alert is: "+myAlert.getText());
	myAlert.accept();
	
	driver.quit();
		
	}

}
