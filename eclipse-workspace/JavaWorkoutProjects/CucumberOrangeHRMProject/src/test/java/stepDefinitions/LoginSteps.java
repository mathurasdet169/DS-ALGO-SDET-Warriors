package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import pageObjects.HomePage;

public class LoginSteps {
	WebDriver driver;
	Properties p;
	Logger logger;
	HomePage hp;
	DashboardPage dp;
	
	@Given("Enter a valid username {string} in the homepage")
	public void enter_a_valid_username_in_the_homepage(String username) throws IOException {
		 BaseClass.getLogger().info("User enters the username details......");
		    hp = new HomePage(BaseClass.getDriver());
		    p = BaseClass.getProperties();
		    hp.setUsername(p.getProperty("username"));	   
	}
	
	
	@Given("Enter a valid password {string} in the homepage")
	public void enter_a_valid_password_in_the_homepage(String pwd) throws IOException {
		BaseClass.getLogger().info("User enters the password details......");
	    hp = new HomePage(BaseClass.getDriver());
	    p = BaseClass.getProperties();
	    hp.setPassword(p.getProperty("password"));
	}

	
	
	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() throws IOException {
		BaseClass.getLogger().info("User clicks the Login Button......");
	    hp = new HomePage(BaseClass.getDriver());
	    hp.clickLogin();
	}
	
	
	@Then("User should enter into Dashboard page succesfully")
	public void user_should_enter_into_dashboard_page_succesfully() {
		dp = new DashboardPage(BaseClass.getDriver());
	    boolean status = dp.dashboardLinkExists();
	    Assert.assertTrue(status);
	    BaseClass.getLogger().info("User entered the Dashboard page successfully......");
	    }
	
	@Given("Enter a invalid username {string} in the homepage")
	public void enter_a_invalid_username_in_the_homepage(String username) throws IOException {
		BaseClass.getLogger().info("User enters invalid username details......");
	    hp = new HomePage(BaseClass.getDriver());
	    hp.setUsername(username);	
	}
	
	
	@Given("Enter a invalid password {string} in the homepage")
	public void enter_a_invalid_password_in_the_homepage(String password) throws IOException {
		BaseClass.getLogger().info("User enters invalid password details......");
	    hp = new HomePage(BaseClass.getDriver());
	    hp.setPassword(password);
	}
	
	
	@Then("User should get an error message stating Invalid Credentials")
	public void user_should_get_an_error_message_stating_invalid_credentials() {
		hp=new HomePage(BaseClass.getDriver());
	    boolean status = hp.errorMsgDisplay();
	    Assert.assertTrue(status);
		BaseClass.getLogger().info("User gets error message for invalid details......");
	}
	
	@Given("Enter just one either username {string} or password {string} in the homepage")
	public void enter_just_one_either_username_or_password_in_the_homepage(String username, String password) {
		BaseClass.getLogger().info("User skips to enter one detail either username or password......");
	    hp = new HomePage(BaseClass.getDriver());
	    hp.setUsername(username);
	    hp.setPassword(password);
	}
	
	@Then("Required message should be displayed under the missed Credentials")
	public void required_message_should_be_displayed_under_the_missed_credentials() {
		hp = new HomePage(BaseClass.getDriver());
		boolean status = hp.requiredMsgDisplay();
		Assert.assertTrue(status);	   
	}

}
