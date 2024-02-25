package webdriverProj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchFrames {

	
	public static void main(String[] args) throws InterruptedException
	{
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://seleniumbase.io/w3schools/iframes");
		driver.manage().window().maximize();
	
		
		driver.switchTo().frame("iframeResult");
		String outerText = driver.findElement(By.xpath("//p[normalize-space()='Use CSS width & height to specify the iframe size:']")).getText();
		System.out.println(outerText);
		
		WebElement innerFrame = driver.findElement(By.xpath("//iframe[@src='./demo_iframe.htm']"));
		driver.switchTo().frame(innerFrame);
		Thread.sleep(5);
		
	
		WebElement text = driver.findElement(By.xpath("//h1[normalize-space()='This page is displayed in an iframe.']"));
		System.out.println("The text in the inner frame is : '"+text.getText()+"'");
		
		driver.switchTo().parentFrame();
		String outerText2 = driver.findElement(By.xpath("//p[normalize-space()='Use CSS width & height to specify the iframe size:']")).getText();
		System.out.println(outerText2);
		
		driver.switchTo().defaultContent();
		
		//Moving through two frames in single line
		driver.switchTo().frame("iframeResult").switchTo().frame(innerFrame);
		System.out.println("The text in the inner frame is : '"+text.getText()+"'");
	}

}
