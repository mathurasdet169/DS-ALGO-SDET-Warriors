import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.LoggerLoad;

public class JuiceShopAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		//----------Launch the browser and open website----------
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.get("https://juice-shop.herokuapp.com/#/");
				driver.manage().window().maximize();
				LoggerLoad.info("----The website is launched-----");
				
				
		//---------------------Create a new user and register ------------------
				driver.findElement(By.xpath("//span[contains(text(),'Dismiss')]")).click();
				driver.findElement(By.xpath("//span[contains(text(),'Account ')]")).click();
				driver.findElement(By.xpath("//button[@id='navbarLoginButton']")).click();
				
				LoggerLoad.info("------Going to register a new Customer!------");
				driver.findElement(By.xpath("//a[normalize-space()='Not yet a customer?']")).click();
				String email = RandomStringUtils.randomAlphabetic(5)+"@gmail.com";
				driver.findElement(By.xpath("//input[@id='emailControl']")).sendKeys(email);
				String password = RandomStringUtils.randomAlphabetic(6)+RandomStringUtils.randomNumeric(4);
				driver.findElement(By.xpath("//input[@id='passwordControl']")).sendKeys(password);
				driver.findElement(By.xpath("//input[@id='repeatPasswordControl']")).sendKeys(password);
			    System.out.println("Email is: "+email+" and password is: "+password);
				
				Actions action = new Actions(driver);
				WebElement SecDropDown = driver.findElement(By.xpath("//mat-label[contains(text(),' Security Question ')]"));
				action.click(SecDropDown).perform();
		
				List<WebElement> SecQuestList = driver.findElements(By.xpath("//span[@class='mat-option-text']"));
			
				for(WebElement opt:SecQuestList)
				{
					String question = opt.getText();
					if(question.equalsIgnoreCase("Name of your favorite pet?"))
					{
						opt.click();
						break;
					}
				}
				
				driver.findElement(By.xpath("//input[@id='securityAnswerControl']")).sendKeys("answer");
				
				WebElement registerBtn = driver.findElement(By.xpath("//button[@id='registerButton']"));
				Thread.sleep(3000);
			  //WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(5));
			  //WebElement registerBtn = myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='registerButton']")));
				if(registerBtn.isDisplayed()&&registerBtn.isEnabled())
					{
						registerBtn.click();
					}
		
				
		//------------Login to the application with newly created email and password-------------- 
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			    driver.findElement(By.xpath("//button[@id='loginButton']")).click();
				
				
		//--------- Add one or two items to basket (from each page) – scroll, navigate and select product------

			 //------1) Add one product from front page "Apple Pomace"---------
				driver.findElement(By.xpath("//div[contains(text(),' Apple Pomace ')]/ancestor::mat-card[@class='mat-card mat-focus-indicator mat-elevation-z6 ribbon-card']//button[@aria-label='Add to Basket']")).click();
					
			 //-----2) Add second product "Lemon Juice" at the bottom of first page --------
				driver.findElement(By.xpath("//div[contains(text(),' Lemon Juice (500ml) ')]/ancestor::mat-card[@class='mat-card mat-focus-indicator mat-elevation-z6 ribbon-card']//button[@aria-label='Add to Basket']")).click();
		
			 //-----3) Add third product by navigating to second page --------
    			WebElement navigator = driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-tooltip-trigger mat-paginator-navigation-next mat-icon-button mat-button-base']"));
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()",navigator);
				driver.findElement(By.xpath("//div[contains(text(),' OWASP Juice Shop Mug ')]/ancestor::mat-card[@class='mat-card mat-focus-indicator mat-elevation-z6 ribbon-card']//button[@aria-label='Add to Basket']")).click();
				Thread.sleep(2000);
				
		//----------Go to your basket and increase the quantity of all items by 2-----------
			   	driver.findElement(By.xpath("//button[@aria-label='Show the shopping cart']")).click();
 			
			   	List<WebElement> BasketProdList =	driver.findElements(By.xpath("//button[@class='mat-focus-indicator mat-icon-button mat-button-base ng-star-inserted']"));
			   	int NoOfItems = BasketProdList.size();
			   	for(int i=1; i<=NoOfItems; i++)
			   	{
			   		if(i%2==0)
			   		{
			   			BasketProdList.get(i-1).click();
			   		}
			   	}
			   	
		 //-------------Press checkout and add a new address-------------------
			   	
			   	WebElement CheckoutBtn = driver.findElement(By.xpath("//button[@id='checkoutButton']"));
			   	js.executeScript("arguments[0].click()",CheckoutBtn);
			   	
			   	driver.findElement(By.xpath("//button[@aria-label='Add a new address']")).click();
			   
				driver.findElement(By.xpath("//input[@placeholder='Please provide a country.']")).sendKeys(RandomStringUtils.randomAlphabetic(7));
				driver.findElement(By.xpath("//input[@placeholder='Please provide a name.']")).sendKeys(RandomStringUtils.randomAlphabetic(7));
				driver.findElement(By.xpath("//input[@placeholder='Please provide a mobile number.']")).sendKeys(RandomStringUtils.randomNumeric(10));
				driver.findElement(By.xpath("//input[@placeholder='Please provide a ZIP code.']")).sendKeys(RandomStringUtils.randomNumeric(5));
				driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(RandomStringUtils.randomAlphabetic(7));
				driver.findElement(By.xpath("//input[@placeholder='Please provide a city.']")).sendKeys(RandomStringUtils.randomAlphabetic(7));
				driver.findElement(By.xpath("//input[@placeholder='Please provide a state.']")).sendKeys(RandomStringUtils.randomAlphabetic(7));
				
				WebElement SubmitBtn = driver.findElement(By.xpath("//button[@id='submitButton']"));
			   	js.executeScript("arguments[0].click()",SubmitBtn);
			   	
			   	
		//-----------------Select the address and any delivery speed-------------------
			   	driver.findElement(By.xpath("//mat-radio-button[@id='mat-radio-42']")).click();
			   	driver.findElement(By.xpath("//button[@aria-label='Proceed to payment selection']")).click();
			   	driver.findElement(By.xpath("//mat-cell[normalize-space()='3 Days']/ancestor::mat-row//mat-radio-button")).click();
			   	driver.findElement(By.xpath("//button[@aria-label='Proceed to delivery method selection']")).click();
			   	
		   
	  //-------------Add a new card in Payment options page------------------
			   	driver.findElement(By.xpath("//mat-expansion-panel-header[@id='mat-expansion-panel-header-0']")).click();
				driver.findElement(By.xpath("//input[@id='mat-input-16']")).sendKeys(RandomStringUtils.randomAlphabetic(7));
				driver.findElement(By.xpath("//input[@id='mat-input-17']")).sendKeys("2"+RandomStringUtils.randomNumeric(15));
				
				WebElement MonthSelect = driver.findElement(By.xpath("//select[@id='mat-input-18']"));
				Select myMonth = new Select(MonthSelect);
				myMonth.selectByVisibleText("4");
				
				WebElement YearSelect = driver.findElement(By.xpath("//select[@id='mat-input-19']"));
				Select myYear = new Select(YearSelect);
				myYear.selectByVisibleText("2080");
				
				driver.findElement(By.xpath("//button[@id='submitButton']")).click();
				
	 //-----------Try to add a fake coupon (10 digits) and verify error message---------------
				WebElement AddCoupon = driver.findElement(By.xpath("//mat-expansion-panel[@id='collapseCouponElement']//mat-expansion-panel-header[@role=\"button\"]"));
				js.executeScript("arguments[0].click()",AddCoupon);
				
				driver.findElement(By.xpath("//input[@id='coupon']")).sendKeys(RandomStringUtils.randomNumeric(10));
				WebElement RedeemBtn = driver.findElement(By.xpath("//button[@id='applyCouponButton']"));
				js.executeScript("arguments[0].click()",RedeemBtn);
				
				String CouponErrMsg = driver.findElement(By.xpath("//div[contains(text(),'Invalid coupon')]")).getText();
				if(CouponErrMsg.equalsIgnoreCase("Invalid coupon."))
					{
						System.out.println("Invalid Coupon Error message is displayed properly");
					}
				
	 //------------ Select card, review and place the order--------------------------
				driver.findElement(By.xpath("//mat-radio-button[@class='mat-radio-button mat-accent']")).click();
				
				WebElement ContinueBtn = driver.findElement(By.xpath("//button[@aria-label='Proceed to review']"));
				js.executeScript("arguments[0].click()",ContinueBtn);
				
				driver.findElement(By.xpath("//button[@aria-label='Complete your purchase']")).click();
				
	//----------Verify in Account, order history -> print order, track order-----------------------
				driver.findElement(By.xpath("//button[@id='navbarAccount']")).click();
				driver.findElement(By.xpath("//button[@aria-label='Show Orders and Payment Menu']")).click();
				driver.findElement(By.xpath("//button[@aria-label='Go to order history page']")).click();
				
				driver.findElement(By.xpath("//div[@fxlayoutalign='end']/button[@aria-label='Print order confirmation']")).click();
				driver.navigate().to("https://juice-shop.herokuapp.com/#/order-history");
				driver.findElement(By.xpath("//button[@aria-label='Track Your Order']")).click();
				
	//------------Logout from application---------------
//				driver.findElement(By.xpath("//button[@id='navbarAccount']")).click();
//			    WebElement LogoutBtn = driver.findElement(By.xpath("//button[@aria-label='Logout']"));
//			    js.executeScript("arguments[0].click()",LogoutBtn);
			    
	//-------------Quit the Browser---------------------
				System.out.println("The testing is completed successfully!!!");
//			 	driver.quit();
				
	   }
	
}
