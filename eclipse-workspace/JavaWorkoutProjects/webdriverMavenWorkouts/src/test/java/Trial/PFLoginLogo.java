package Trial;

	import java.time.Duration;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class PFLoginLogo
	{
		WebDriver driver = new ChromeDriver();
		PFLoginPOM lp;
//		
//		@BeforeMethod
//		void setup()
//		{
//			driver = new ChromeDriver();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//			driver.manage().window().maximize();
//		}
//		
//		
//		@AfterMethod
//		void tearDown()
//		{ 
//			driver.quit();
//		}
//		
		
		@Test (priority =1)
		void LogoDisplay() throws InterruptedException
		{
			lp = new PFLoginPOM(driver);
			Thread.sleep(2000);
			//boolean status = lp.logoDisplay();
			System.out.println(lp.logoDisplay());
			Assert.assertTrue(lp.logoDisplay(),"Expected Webpage didnt open...");
		}
		

	}



