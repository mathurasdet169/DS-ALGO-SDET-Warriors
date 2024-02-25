package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frameWorkout {

	public static void main(String[] args) 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();

		//Switch to Frame 1 
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("frame1-word");

		//Switch to Frame 2
		driver.switchTo().defaultContent();
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("frame2_word");

		//Switch to Frame3
		driver.switchTo().defaultContent();
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);

		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Frame3_Text");

		//Switching to Inner Frame of Frame3
		driver.switchTo().frame(0);

		driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();

		driver.findElement(By.xpath("//label[@for='i25']//div[@class='ulDsOb']")).click();	

		driver.findElement(By.xpath("//div[@class='uArJ5e UQuaGc YhQJj zo8FOc ctEux']//span[@class='l4V7wb Fxmcue']")).click();

		driver.switchTo().defaultContent();

		//Switch to Frame4 and enter text 
		WebElement frame4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		driver.switchTo().frame(frame4);
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("Frame4-Text");

		//Switch to Frame5
		driver.switchTo().defaultContent();
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);

		//Enter text and click Link in Frame5
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("Frame5_Text");
		driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
		
		//clicking the link and enter text in dynamic page opened
		driver.findElement(By.xpath("//input[@id='mce-EMAIL']")).sendKeys("myemail@gmail.com");
		
	}

}
