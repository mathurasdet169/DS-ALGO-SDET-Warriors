package TestNG_Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM 
{
	WebDriver driver;
	
	//Without using PageFactory method
	//constructor
	LoginPOM(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	//Locators of all elements in Login Page
	
	By img_logo_login = By.xpath("//img[@alt='company-branding']");
	By username_login = By.xpath("//input[@placeholder='Username']");
	By password_login = By.xpath("//input[@placeholder='Password']");
	By login_button = By.xpath("//button[normalize-space()='Login']");
	
	
	//Actions of Login Page
	
	public void setUsername(String user)
	{
	driver.findElement(username_login).sendKeys(user);
	}
	
	public void setPassword(String password)
	{
	driver.findElement(password_login).sendKeys(password);
	}
	
	public void clickLogin()
	{
	driver.findElement(login_button).click();
	}
	
	public String loginTitle()
	{
		String Title = driver.getTitle();
		return Title;
	}
	
	public boolean logoDisplay()
	{
		boolean display = driver.findElement(img_logo_login).isDisplayed();
		return display;
	}
	
//	public void loginApp()
//	{
//		setUsername(String user);
//		setPassword(String password);
//		clickLogin();
//	}

}
