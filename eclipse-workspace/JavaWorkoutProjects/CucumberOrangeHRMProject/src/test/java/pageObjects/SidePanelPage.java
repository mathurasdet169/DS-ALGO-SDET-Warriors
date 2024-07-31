package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SidePanelPage extends BasePage
 {

	public SidePanelPage(WebDriver driver) {
		super(driver);
			} 
	
	//-----------------WebElements--------------
	
	@FindBy(xpath="//img[@alt='client brand banner']" )
	private WebElement OrangeLogoSidePanel;
				
	@FindBy(xpath="//button[@class='oxd-icon-button oxd-main-menu-button']")
	private WebElement mainMenuButton;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	private WebElement menuItemName;
	
	@FindBy(xpath="//aside[@class='oxd-sidepanel toggled']")
	private WebElement sidePanelToggled;
	
	@FindBy(xpath="//aside[@class='oxd-sidepanel']")
	private WebElement sidePanelOpened;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	private List<WebElement> sidePanelMenuItemList;
	
	@FindBy(xpath="//span[normalize-space()='My Info']")
	private WebElement myInfoLink;
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	private WebElement pageDisplayed;

	
	
	//------------------Actions-----------------
	
	public void clickMainMenuBtn() {
		mainMenuButton.click();
	}
	
	public boolean sidePanelToggled() {
		boolean status = sidePanelToggled.isDisplayed();
		return status;
	}
	
	public boolean sidePanelOpened() {
		boolean status = sidePanelOpened.isDisplayed();
		return status;
	}	
	
	public boolean OrangeLogoSidePanel() {
		boolean status = OrangeLogoSidePanel.isDisplayed();
		return status;
	}	
	
	
	public ArrayList<String> menuItemList() {
		int size = sidePanelMenuItemList.size();
		ArrayList<String> MenuItems = new ArrayList<>();
		for(int i=0; i<size; i++)
		{
			String item = sidePanelMenuItemList.get(i).getText();
			MenuItems.add(item);
		}
		return MenuItems;		
	}
	
	public void enterSearch(String menu) {
		searchBox.sendKeys(menu);
	}
	
	public String displayedPageName() {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement myPage = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")));
		String myPageName = myPage.getText();
		return myPageName;
	}
	
	
	public String checkSppPageDisplay(String menuitem, String pageDisplay) {
		
		String status =null;
		for(WebElement i:sidePanelMenuItemList)
		  {
			String menuItemName = i.getText();
			if (menuItemName.equals(menuitem))
				{
				  System.out.println("The menu item clicked is: "+menuItemName);
			      i.click();
//			      String menuClicked = i.getText();
			      
			      
			      String actualPageDisplayed = displayedPageName();
			      System.out.println("The expected page to be displayed is: "+pageDisplay);
			      System.out.println("The actual page displayed is: "+actualPageDisplayed);
				      if(actualPageDisplayed.equalsIgnoreCase(pageDisplay))
				        {
				    	 status = "pass";
				    	 continue;
				        }
				      else
				        {
				    	  status = "fail";
				    	  break;
		                }
				   }
			      
    		}
		return status;
	  }
	
	
//		String status = null;
//		int size = sidePanelMenuItemList.size();
//		System.out.println(size);
//		for(WebElement i:sidePanelMenuItemList)
//		{
//			//click the required menu item......
//			System.out.println(i);
//			String menu = i.getText();
//			System.out.println("The menu item clicked is: "+menu);
//			if(menu.equals(menuitem))
//			 i.click();
//			
//			//check whether corresponding page is displayed...
//			System.out.println("The required page name is: "+pageDisplayed);
//			String actualPageDisplayed = displayedPageName();
//			System.out.println("Displayed page name is: "+actualPageDisplayed);
//			if(actualPageDisplayed.equalsIgnoreCase(pageDisplayed))
//				{
//				System.out.println("The click of menu item '"+menuitem+" displayed the corresponding "+actualPageDisplayed+" page successfully...");
//				status = "pass";
//				continue;
//				}
//				
//			else {
//				   System.out.println("The menu item '"+menuitem+"' click did not open the corresponding page.");
//				   status = "fail";
//				   Assert.fail();
//				   break;
//			     }
//							
//		}
//		if (status.equalsIgnoreCase("pass"))
//			Assert.assertTrue(true);
//		else
//			Assert.assertTrue(false);
//	}
	
	

}
