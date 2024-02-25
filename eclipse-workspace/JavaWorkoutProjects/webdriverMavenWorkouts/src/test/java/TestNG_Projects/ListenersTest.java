package TestNG_Projects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ListenersTest
{
WebDriver driver;
	
	
	@BeforeTest
	void LaunchApp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	
//	@Test (priority = 1)
//	void checkLogo() throws InterruptedException
//	{
//		
//		boolean logoDisplay = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
//		Thread.sleep(2000);
//		System.out.println(logoDisplay);
//		Assert.assertEquals(logoDisplay, true,);
//	}
	
	@Test(priority=1)
	void testLogo()
	{
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status,true);
	}
	
	@Test (priority=2)
	void pageTitle() throws InterruptedException
	{
		String Title = driver.getTitle();
		Thread.sleep(2000);
		Assert.assertEquals(Title, "OrangeHRM", "The Expected Title page is not displayed");
	}
	
	
	@Test(priority = 3, dependsOnMethods = "testLogo")
	void pageUrl(String Url) throws InterruptedException
	{
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
	}

	
	@AfterTest
	void closeApp()
	{
		driver.quit();
	}
	

}
