package logInPageTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PFFullTest
{

	WebDriver driver;
	PFLoginPOM lp;

	@BeforeTest
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test (priority =1)
	void BeforeLoginTitle() throws InterruptedException
	{
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test (priority = 3)
	void chkUserLabel() throws InterruptedException
	{
		lp =  new PFLoginPOM(driver);
		Thread.sleep(2000);
		Assert.assertEquals(lp.checkUsernameLabel(), "Username","'Username' Label not found...");
	}
	
	@Test (priority = 2)
	void setLoginUser()
	{
		lp =  new PFLoginPOM(driver);
		lp.setUsername("Admin");
		
	}
	
//	lp = new PFLoginPOM(driver);
//	lp.setUsername("Admin");
//	lp.setPassword("admin123");
//	lp.clickLogin();
//	Assert.assertEquals(driver.getTitle(), "OrangeHRM");

	
	@Test (priority = 4)
	void chkPwdLabel() throws InterruptedException
	{
		lp =  new PFLoginPOM(driver);
		Thread.sleep(2000);
		Assert.assertEquals(lp.checkPasswordLabel(), "Password", "'Password' label not found...");
	}
	
	@Test (priority = 5)
	void setLoginPwd()
	{
		lp =  new PFLoginPOM(driver);
		lp.setPassword("admin123");
		
	}
	
	@Test (priority = 6)
	void ForPwdLinkVisible()
	{
		lp =  new PFLoginPOM(driver);
		Assert.assertTrue(lp.forPwdDisplay(),"Forgot password Link is not Displayed....");
	}
	
	@Test (priority = 7)
	void clickLogin()
	{
		lp =  new PFLoginPOM(driver);
		lp.clickLogin();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Login Failed....");
	}
	
	
	@AfterTest
	void tearDown()
	{
		driver.quit();
	}
	
	
}
