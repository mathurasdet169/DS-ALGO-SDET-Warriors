package logInPageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFLoginPOM
{
	WebDriver driver;
	
 // constructor
	public PFLoginPOM(WebDriver driver)
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
	

	@FindBy(xpath="//label[normalize-space()='Username']") 
	@CacheLookup
	private WebElement usernameLabel;
	
	
	@FindBy(xpath="//label[normalize-space()='Password']")
	@CacheLookup 
	private WebElement passwordLabel;
	

	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	@CacheLookup
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required'])[1]")
	@CacheLookup 
	private WebElement UsernameReq;
	
	@FindBy(xpath="(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required'])[2]")
	@CacheLookup 
	private WebElement PasswordReq;
	
	
	
	
	//Actions
	public boolean UserReqDisplay()
	{
		boolean UserReqDisplay = UsernameReq.isDisplayed();
		return UserReqDisplay;
	}
	
	public boolean PwdReqDisplay()
	{
		boolean PwdReqDisplay = PasswordReq.isDisplayed();
		return PwdReqDisplay;
	}
	
	public boolean forPwdDisplay()
	{
		boolean visible = forgotPasswordLink.isDisplayed();
		return visible;
	}
	
	
	public String checkUsernameLabel()
	{
		String userLabel = usernameLabel.getText();
		return userLabel;	
	}
	
	public String checkPasswordLabel()
	{
		String pwdLabel = passwordLabel.getText();
		return pwdLabel;	
	}
	
	
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
