package logInPageTests;

	import java.time.Duration;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class PFAfterLoginTitle
	{
		WebDriver driver;
		PFLoginPOM lp;
		

		@Test (priority =1)
		void testLogin() throws InterruptedException
		{
			lp = new PFLoginPOM(driver);
			lp.setUsername("Admin");
			lp.setPassword("admin123");
			lp.clickLogin();
			Thread.sleep(2000);
			Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		}

		

	}



