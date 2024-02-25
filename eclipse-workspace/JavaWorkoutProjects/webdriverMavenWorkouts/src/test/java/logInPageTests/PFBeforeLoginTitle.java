package logInPageTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PFBeforeLoginTitle 
{
	
	WebDriver driver = new ChromeDriver();;
	PFLoginPOM lp;

	@BeforeMethod
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test (priority =1)
	void testLogin() throws InterruptedException
	{
		System.out.println("Into the Before Login title Test....");
		lp = new PFLoginPOM(driver);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterMethod
	void tearDown()
	{
		driver.quit();
	}
	
}
