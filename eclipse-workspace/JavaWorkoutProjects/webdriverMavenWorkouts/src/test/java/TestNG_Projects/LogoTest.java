package TestNG_Projects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogoTest 
{

	WebDriver driver;
	LoginPOM lp;
	
	
	@BeforeTest
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
	}
	
	
	@Test (priority =1)
	void LogoDisplay() throws InterruptedException
	{
		lp = new LoginPOM(driver);
		Thread.sleep(2000);
		boolean status = lp.logoDisplay();
		Assert.assertTrue(status);
	}
	
	
	
	@AfterTest
	void teardown()
	{
		driver.quit();
	}
	

}
