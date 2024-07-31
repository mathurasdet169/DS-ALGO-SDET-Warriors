package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
	
	public DashboardPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//--------------WebElements------------------
	
	@FindBy(xpath="//div[@class='oxd-layout-context']")
	private WebElement dashboardLink;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement userLogoutDropdown;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement logoutLink;
	
	//----------------Actions--------------------------
	
	public boolean dashboardLinkExists() {
		boolean exists = dashboardLink.isDisplayed();
		return exists;
	}
	
	public void clickLogoutDropdown() {
		userLogoutDropdown.click();
	}

	public void clickLogoutLink() {
		logoutLink.click();
	}
}
