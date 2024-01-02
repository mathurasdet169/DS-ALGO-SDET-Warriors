package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//----------------WebElements-------------------
	
	@FindBy(xpath="//input[@id='input-email']")
	@CacheLookup
	private WebElement eMailAddress;
	
	@FindBy(xpath="//input[@id='input-password']") 
	@CacheLookup 
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	@CacheLookup 
	private WebElement btnLogin;
	
	
	//----------------Actions-------------------------
	public void setEmail(String email)
	{
		eMailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}

}
