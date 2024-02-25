package TestNG_Projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFLoginPOM
{
	WebDriver driver;
	
 // constructor
	PFLoginPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Object Elements---Locators
	
	@FindBy(xpath="//img[@alt='company-branding']") 
	@CacheLookup 
	private WebElement logo;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	@CacheLookup
	private WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	@CacheLookup
	private WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Login']") 
	@CacheLookup
	private WebElement login;
	
	//Actions
	public boolean logoDisplay()
	{
		boolean status = logo.isDisplayed();
		return status;
	}
	
	public void setUsername(String user)
	{
		username.sendKeys(user);
	}
	
	public void setPassword(String password)
	{
		username.sendKeys(password);
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
	
	
}
