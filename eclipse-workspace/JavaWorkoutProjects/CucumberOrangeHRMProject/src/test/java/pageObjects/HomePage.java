package pageObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//--------------WebElements------------------------
	

	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	private WebElement loginButton;
	

	@FindBy(xpath="//p[text()='Forgot your password? ']")
	private WebElement forgotPwdLink;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement errorMessage;
	
	@FindBy(xpath="//span[text()='Required']")
	private WebElement requiredMessage;
	
	@FindBy(xpath="//h5[normalize-space()='Login']")
	private WebElement HomepgLoginDisplay;	
	
	@FindBy(xpath="//div[@class='orangehrm-login-branding']//img[@alt='company-branding']") 
	private WebElement OrangeHRMLogoHomePage;
	
	@FindBy(xpath="//div[@class='orangehrm-login-logo']//img[@alt='orangehrm-logo']") 
    private WebElement HRforAllLogoHomePage;
	
	
	//---------------Actions-------------------------
	
	public void setUsername(String userName) {
		username.sendKeys(userName);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void clickForgotPwd() {
		forgotPwdLink.click();
	}
	
	public boolean errorMsgDisplay() {
		boolean display = errorMessage.isDisplayed();
		return display;
	}
	
	public boolean requiredMsgDisplay() {
		boolean display = requiredMessage.isDisplayed();
		return display;
	}
	
	public boolean HomepgLoginDisplay() {
		boolean display = HomepgLoginDisplay.isDisplayed();
		return display;
	}
	
	
	public void clickOrangeHRMLogo() {
		OrangeHRMLogoHomePage.click();
	}
	
	
	public boolean OrangeHRMLogoDisplay() throws InterruptedException {			
		boolean display = OrangeHRMLogoHomePage.isDisplayed();
		return display;
	}
	
	public void clickHRforAllLogo() {
		HRforAllLogoHomePage.click();
	}
	
	
	public boolean HRforAllLogoHomePageDisplay() {
		boolean display = HRforAllLogoHomePage.isDisplayed();
		return display;
	}
	
	
	public void OrangeLogoImageCapture() throws IOException { 
		//WebElement OrangeHRMLogo = driver.findElement(By.xpath("//div//img[@alt='company-branding']"));
		Screenshot myScreenshot = new AShot().takeScreenshot(driver, OrangeHRMLogoHomePage);
		ImageIO.write( myScreenshot.getImage(), "png", new File("C://Orange_Image/OrangeHRMLogo.png"))  ;
	}
	
	
	public boolean OrangeHRMLogoImgCompare() throws IOException {
		BufferedImage ExpImage = ImageIO.read(new File("C://Orange_Image/OrangeHRMLogo.png"));
		WebElement OrangeHRMLogo = driver.findElement(By.xpath("//div//img[@alt='company-branding']"));
		Screenshot OrangeLogoScrShot = new AShot().takeScreenshot(driver, OrangeHRMLogoHomePage);
		BufferedImage ActImage = OrangeLogoScrShot.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(ExpImage, ActImage);
		boolean differs = diff.hasDiff();
		System.out.println("The images are different: "+differs);
		return differs;
	}
    		
	
}


