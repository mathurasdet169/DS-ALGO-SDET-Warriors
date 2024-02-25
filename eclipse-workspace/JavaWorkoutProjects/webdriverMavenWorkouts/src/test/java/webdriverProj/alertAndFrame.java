package webdriverProj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertAndFrame {

	public static void main(String[] args) 
	{
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
	
	//switching to required Frame
	driver.switchTo().frame(0);	
	driver.findElement(By.xpath("//button[normalize-space()='Try it']")).click();
		
		
	}

}
