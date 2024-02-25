package logInPageNegativeTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import logInPageTests.PFLoginPOM;

public class LoginNegativeTest 
{

	WebDriver driver;
	PFLoginNegPOM lp;

	@BeforeTest
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	
	@AfterTest
  void tearDown()
  {
		driver.quit();
  }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	

	
	@Test(priority = 1)
	void LoginWithInvalidPwd()
	{
		lp = new PFLoginNegPOM(driver);
		lp.clearUsername();
		lp.clearPwd();
		lp.setUsername("Admin");
		lp.setPassword("admindf123");
		lp.clickLogin();
		Assert.assertTrue(lp.invalidDataAlert(), "Error message is not popped up with Invalid Login Credentials...");
	
	}
	
	
	@Test(priority = 2)
	void LoginWithInvalidUser()
	{
		lp = new PFLoginNegPOM(driver);
		lp.clearUsername();
		lp.clearPwd();
		lp.setUsername("Admidgfn");
		lp.setPassword("admin123");
		lp.clickLogin();
		Assert.assertTrue(lp.invalidDataAlert(), "Error message is not popped up with Invalid Login Credentials...");
		
	}
	
	
	@Test(priority = 3)
	void LoginWithoutData()
	{
		lp = new PFLoginNegPOM(driver);
		lp.clearUsername();
		lp.clearPwd();
		lp.clickLogin();
		Assert.assertTrue(lp.UserReqDisplay(),"'Required' is not displayed for 'Username'");
		Assert.assertTrue(lp.PwdReqDisplay(),"'Required' is not displayed for 'Password'");
		
	}
		
	
	@Test(priority = 4)
	void LoginWithoutUser()
	{
		lp = new PFLoginNegPOM(driver);
		lp.clearUsername();
		lp.clearPwd();
		lp.setPassword("admin123");
		lp.clickLogin();
		Assert.assertTrue(lp.UserReqDisplay(),"'Required' is not displayed for 'Username'");
		
	}
	
	
	
	@Test(priority = 5)
	void LoginWithoutPwd() throws InterruptedException
	{
		lp = new PFLoginNegPOM(driver);
		lp.clearPwd();
		lp.clearUsername();
		lp.setUsername("Admin");
		Thread.sleep(2000);
		lp.clickLogin();
		Assert.assertTrue(lp.PwdReqDisplay(),"'Required' is not displayed for 'Password'");
	}
	
		

}
