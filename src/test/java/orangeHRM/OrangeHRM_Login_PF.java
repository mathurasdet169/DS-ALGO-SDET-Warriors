package orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class OrangeHRM_Login_PF {
	
	static WebDriver driver;
	
	static String URL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	@FindBy(xpath="//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")  WebElement username;
	@FindBy(xpath="//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")  WebElement password;
	@FindBy(xpath="//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")  WebElement Login;
	@FindBy(xpath="//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span") WebElement myInfoTab;
	@FindBy(partialLinkText ="viewLeaveModule") WebElement leaveTab;
	@FindBy(partialLinkText = "viewAdminModule")WebElement adminTab;
	
	
	@Test
	 void Login()
	{
		driver=DriverFactory.getChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(URL);
		PageFactory.initElements(driver, this);
		
		
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		Login.click();
	}
	/*
	 * @Test public void
	 * user_navigateto_myinfo_contactDetails_updateDetails(WebDriver driver) {
	 * //driver.get(
	 * "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7"
	 * ); driver. myInfoTab.click();
	 * driver.findElement(By.partialLinkText("contactDetails")).click();
	 * 
	 * }
	 */
	
	/*public static void main(String[] args) {
		OrangeHRM_Login_PF obj=new OrangeHRM_Login_PF();
		obj.Login();
	
	}*/
}
