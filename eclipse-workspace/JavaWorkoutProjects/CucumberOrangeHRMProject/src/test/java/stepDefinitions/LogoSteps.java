package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.en.Then;
import pageObjects.DashboardPage;
import pageObjects.HomePage;

public class LogoSteps {
	WebDriver driver;
	Logger logger;
	Properties p;
	HomePage hp;
	
	
	@Then("Check the display of Orange HRM Logo")
	public void check_the_display_of_orange_hrm_logo() throws InterruptedException {
		BaseClass.getLogger().info("Checking for Orange HRM Logo display at the home page....");
		hp = new HomePage(BaseClass.getDriver());
		hp.clickOrangeHRMLogo();
	    boolean status = hp.OrangeHRMLogoDisplay();
	    System.out.println(status);
	    Assert.assertTrue(status);
	 }
	
	
	@Then("Check the display of HRforAll Logo image at HomePage")
	public void check_the_display_of_h_rfor_all_logo_image_at_home_page() throws IOException {
		BaseClass.getLogger().info("Checking for 'HRforALL' Logo at the home page....");
		hp = new HomePage(BaseClass.getDriver());
		hp.clickHRforAllLogo();
	    boolean display = hp.HRforAllLogoHomePageDisplay();
	    Assert.assertTrue(display);
	}
	
	@Then("Capture OrangeHRM Logo image at HomePage")
	public void capture_orange_hrm_logo_image_at_home_page() throws IOException {
		BaseClass.getLogger().info("Capturing the Orange HRM Logo Image from Home page....");
		hp = new HomePage(BaseClass.getDriver());
	    hp.OrangeLogoImageCapture();	  
	}
	
	@Then("Compare OrangeHRM Logo image at HomePage with brand image")
	public void compare_orange_hrm_logo_image_at_home_page_with_brand_image() throws IOException {
		BaseClass.getLogger().info("Checking 'Orange HRM' Logo at the home page....");
		hp = new HomePage(BaseClass.getDriver());
		boolean status = hp.OrangeHRMLogoImgCompare();
		System.out.println(status);
		Assert.assertFalse(status);		
	}
	
	



}
