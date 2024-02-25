package TestNG_Projects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider extends seperateDataProvider
{
	WebDriver driver;
	
	@BeforeTest
	void LaunchApp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
	}
	
	
	@Test(dataProvider = "dp", dataProviderClass = dataProviderFromExcel.class)
	void LogIn(String email, String pass) throws InterruptedException
		{
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		boolean display = driver.findElement(By.xpath("//h2[normalize-space()='My Orders']")).isDisplayed();
		Thread.sleep(2000);
		System.out.println(display);
		Assert.assertTrue(display, "Login Failed. Invalid UserId or Password...");
	}
	
	
	@AfterTest
	void tearDown()
	{
		driver.quit();
	}
	
		
	
}
