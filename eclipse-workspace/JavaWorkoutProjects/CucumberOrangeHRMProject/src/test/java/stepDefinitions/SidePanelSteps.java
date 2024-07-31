package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
import pageObjects.SidePanelPage;

public class SidePanelSteps {
	WebDriver driver;
	Logger logger;
	Properties p;
	DashboardPage dp;
	HomePage hp;
	SidePanelPage spp;
	
	
	@Given("User Login to the application with valid username {string} and password {string}")
	public void user_login_to_the_application_with_valid_username_and_password(String username, String password) throws IOException {
		hp = new HomePage(BaseClass.getDriver());
	    p = BaseClass.getProperties();
	    hp.setUsername(p.getProperty("username"));	
	    hp.setPassword(p.getProperty("password"));
	    hp.clickLogin();
	    BaseClass.getLogger().info("User logged in with valid username and password......");
	}
	
	@When("User clicks on the main menu icon button")
	public void user_clicks_on_the_main_menu_icon_button() {
		BaseClass.getLogger().info("User clicks the SidePanel button........");
	    spp = new SidePanelPage(BaseClass.getDriver());
	    spp.clickMainMenuBtn();
	}
	
	@Then("SidePanel gets toggled")
	public void side_panel_gets_minimized() {
		   BaseClass.getLogger().info("SidePanel gets toggled..");
		    spp = new SidePanelPage(BaseClass.getDriver());
		    boolean toggled = spp.sidePanelToggled();
		    Assert.assertTrue(toggled);		   
	}
	
	@Then("SidePanel gets maximized")
	public void side_panel_gets_maximized() {
		 BaseClass.getLogger().info("SidePanel gets Opened..");
		    spp = new SidePanelPage(BaseClass.getDriver());
		    boolean opened = spp.sidePanelOpened();
		    Assert.assertTrue(opened);
	}

	
	@Then("check the list of menu items in the side panel")
	public void check_the_list_of_menu_items_in_the_side_panel() {
		BaseClass.getLogger().info("Retrieve the Menu Items List in the SidePanel....");
	    spp = new SidePanelPage(BaseClass.getDriver());
	    ArrayList<String> Exp_Menu_Items = new ArrayList<>(Arrays.asList("Admin","PIM","Leave", "Time","Recruitment", "My Info", "Performance", "Dashboard", "Directory", "Maintenance", "Claim", "Buzz"));
	    Collections.sort(Exp_Menu_Items);
		   System.out.println(Exp_Menu_Items);

	    ArrayList<String> Act_Menu_Items = spp.menuItemList();
	     Collections.sort(Act_Menu_Items);
	    	System.out.println(Act_Menu_Items);
	    	
	   boolean Equal = Exp_Menu_Items.equals(Act_Menu_Items);
	   	Assert.assertTrue(Equal);
	}
	
	@Then("Check the availability of Orange HRM Logo")
	public void check_the_availability_of_orange_hrm_logo() {
		BaseClass.getLogger().info("Checking the display of OrangeHRM logo in the SidePanel....");
	    spp = new SidePanelPage(BaseClass.getDriver());
	    boolean displayed = spp.OrangeLogoSidePanel();
	    Assert.assertTrue(displayed);
	}
	
	@When("Enter one menu item {string} in the search text box")
	public void enter_one_menu_item_in_the_search_text_box(String menu) throws InterruptedException {
		BaseClass.getLogger().info("Enter a menu item in the search text box of SidePanel....");
	    spp = new SidePanelPage(BaseClass.getDriver());
	    spp.enterSearch(menu);  
	    //Thread.sleep(2000);
	}
	
	
	@Then("Matching menu item {string} should be displayed")
	public void matching_menu_item_should_be_displayed(String menu) {
		BaseClass.getLogger().info("Check whether menu item entered in the search text box gets displayed below....");
	    spp = new SidePanelPage(BaseClass.getDriver());
	    ArrayList<String> Act_Menu = spp.menuItemList();
	    String Listed_Menu = Act_Menu.get(0);
	     System.out.println("The expected menu item is: "+menu+". The displayed menu is: "+Listed_Menu+"." );
	     Assert.assertEquals(menu, Listed_Menu);    	    
	}
	
	
	@When("Menu item {string} in the side panel is clicked the Corresponding page {string} should be displayed")
	public void menu_item_in_the_side_panel_is_clicked_the_corresponding_page_should_be_displayed(String menuItem, String pageDisplay) {
	    BaseClass.getLogger().info("To check whether the click of menu item in the side panel opens corresponding page..");
	    spp = new SidePanelPage(BaseClass.getDriver());
	    String status = spp.checkSppPageDisplay(menuItem, pageDisplay);
	    Assert.assertEquals(status,"pass");
	    
	}

	
	
}
