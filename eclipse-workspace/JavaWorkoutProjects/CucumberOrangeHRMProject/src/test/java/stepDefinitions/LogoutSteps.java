package stepDefinitions;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import pageObjects.HomePage;

public class LogoutSteps {
	WebDriver driver;
	Logger logger;
	Properties p;
	DashboardPage dp;
	HomePage hp;
	
	@When("User clicks on Logout Dropdown")
	public void user_clicks_on_logout_dropdown() {
		BaseClass.getLogger().info("User clicks on Logout Dropdown....");
		dp = new DashboardPage(BaseClass.getDriver());
		dp.clickLogoutDropdown();	    
	}
	
	@When("User clicks Logout Link")
	public void user_clicks_logout_link() {
		BaseClass.getLogger().info("User clicks on Logout link....");
		dp = new DashboardPage(BaseClass.getDriver());
		dp.clickLogoutLink();
	}
	@Then("User logout successfully and navigate to home page")
	public void user_logout_successfully_and_navigate_to_home_page() {
		hp = new HomePage(BaseClass.getDriver());
		boolean status = hp.HomepgLoginDisplay();
		Assert.assertTrue(status);
		BaseClass.getLogger().info("User logged out successfully....");
	}

}
