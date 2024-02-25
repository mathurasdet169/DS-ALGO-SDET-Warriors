package webdriverProj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaScriptExecutorMethod {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		
		//---------Enter Text using Javascript Executor-----------
		JavascriptExecutor js = driver;
		js.executeScript("arguments[0].setAttribute('value','Sairam')",name);
		
		//--------------Click Radio Button using Javascript-----------------
		WebElement radioButton = driver.findElement(By.xpath("//input[@id='female']"));
		js.executeScript("arguments[0].click()", radioButton);
		
		//-----------Click the check Box using JS-----------------
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='thursday']"));
		js.executeScript("arguments[0].click()",checkBox );
		
		//------------------Select from Drop down using JS---------------
//		WebElement dropDown = driver.findElement(By.xpath("//select[@id='country']"));
//		//js.executeScript("arguments[0].click()", dropDown);
//		js.executeScript("arguments[0].value='Japan'", dropDown);
//		//js.executeScript(null, args)
		
		WebElement list = driver.findElement(By.xpath("//option[@value='green']"));
		js.executeScript("arguments[0].click()",list );
		
		
	}

}
