import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TutorialsNinjaAssignment {

	public static void main(String[] args) throws InterruptedException {
		
	//----------Launch the browser and open website----------
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/index.php");
		driver.manage().window().maximize();
				
	 //---------Select the currency in the left top corner to Euro----
		driver.findElement(By.xpath("//span[text()='Currency']")).click();
		driver.findElement(By.xpath("//button[text()='€Euro']")).click();
		
	//---------Try to order a canon EOS 5 D camera and collect the error message------
		driver.findElement(By.xpath("//a[text()='Cameras']")).click();
		driver.findElement(By.xpath("//a[text()='Canon EOS 5D']")).click();
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
		String Err_Message=driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		System.out.println("The error message displayed is: '"+Err_Message+"'");
		
	//--------Move to the home screen by clicking home icon----------
		driver.findElement(By.xpath("//ul[@class='breadcrumb']//i[@class='fa fa-home']")).click();
		
	//--------Click on iphone and go to details screen, change the quantity to two then add to cart-----
		driver.findElement(By.xpath("//a[normalize-space()='iPhone']")).click();
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("2");
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
		
		
	//---- Print the success message in the console-------
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		WebElement iPhoneSuccessMsg = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
		WebElement iPhoneSuccessMsg =driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		System.out.println(iPhoneSuccessMsg.getText());		
			
		
	//-------Click on the cart icon (black color) in the right side top then click view cart---
		driver.findElement(By.xpath("//div[@id='cart']//span[@id='cart-total']")).click();
		driver.findElement(By.xpath("//strong[contains(text(),'View Cart')]")).click();
		
		
	//--------Print the Eco tax and VAT Amount in console and click Checkout button---------
			String Eco_Tax = driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//tr[2]//td[2]")).getText();
			String VAT = driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//tr[3]//td[2]")).getText();
			System.out.println("The Eco-Tax amount is; "+Eco_Tax);
			System.out.println("The VAT amount is; "+VAT);
			
	//--------Print the error message and remove the product from the cart------------		
			String iPhone_Err_Msg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
			System.out.println("The iPhone Error Message on the Shopping Cart page is: "+iPhone_Err_Msg);
			
			driver.findElement(By.xpath("//button[@data-original-title='Remove']")).click();
			Thread.sleep(2000);
			
	//----------------------Move to the laptops screen------------ 
					
    		WebElement LaptopsLink = myWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Laptops & Notebooks")));
    		LaptopsLink.click();
			WebElement ShowLaptopLinkElement = myWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Show AllLaptops & Notebooks")));
			ShowLaptopLinkElement.click();
			//driver.findElement(By.linkText("Show AllLaptops & Notebooks")).click();
	
			
	//-------Click on HP laptop, check the default quantity is 1 and click add to cart then verify success message---
//			WebElement HPLaptopLinkClickable = myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'HP LP')]")));
//			HPLaptopLinkClickable.click();
			driver.findElement(By.xpath("//a[contains(text(),'HP LP3065')]")).click();
			
			WebElement Quantity = driver.findElement(By.xpath("//input[@id='input-quantity']"));
			String Qty_no = Quantity.getAttribute("value");
			if (Qty_no.equals("1"))
				System.out.println("The default quantity number is 1.");
			else
				System.out.println("The default quantity number is NOT 1.");
			
			driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
			
			WebElement successMsgElement = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
			System.out.println("The message received after adding element to cart is: '"+successMsgElement.getText()+"'");		
			
	//----- Click on the shopping cart link in the top and apply ABCD123 as coupon code to check,print error message----
			driver.findElement(By.xpath("//div[@id='cart']//span[@id='cart-total']")).click();
			driver.findElement(By.xpath("//strong[contains(text(),'View Cart')]")).click();
			
			driver.findElement(By.xpath("//a[contains(text(),'Use Coupon Code')]")).click();
			driver.findElement(By.xpath("//input[@name='coupon']")).sendKeys("ABCD123");
			driver.findElement(By.xpath("//input[@id='button-coupon']")).click();
			
			WebElement CouponErrorMsgElement = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
			System.out.println("Invalid Coupon Error message is: '"+CouponErrorMsgElement.getText()+"'");	
			Thread.sleep(3000);
			
			
	//-------Enter AXDFGH123 as gift certificate and perform apply to check, print error message-----------
			driver.findElement(By.xpath("//a[@href='#collapse-voucher']/i[@class='fa fa-caret-down']")).click();
			driver.findElement((By.xpath("//input[@id='input-voucher']"))).sendKeys("AXDFGH123");
			driver.findElement(By.xpath("//input[@value='Apply Gift Certificate']")).click();
			
			WebElement GiftErrorMsgElement = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
			System.out.println("Invalid Gift Certificate Error message is: '"+GiftErrorMsgElement.getText()+"'");	
			
	//------Clear both textbox values and proceed to checkout---------------
			
			driver.findElement(By.xpath("//input[@placeholder='Enter your gift certificate code here']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter your gift certificate code here']")).clear();
			
			driver.findElement(By.xpath("//a[contains(text(),'Use Coupon Code')]")).click();
			driver.findElement(By.xpath("//input[@name='coupon']")).clear();
			
			//driver.findElement(By.xpath("//a[text()='Checkout']")).click();
			driver.findElement(By.linkText("Checkout")).click();
			
	//-------Select register account option and enter all account and billing details, click continue-----
			
			driver.findElement(By.xpath("//input[@id='button-account']")).click();
			driver.findElement(By.xpath("//input[@id='input-payment-firstname']")).sendKeys("Vijayashree");
			driver.findElement(By.xpath("//input[@id='input-payment-lastname']")).sendKeys("xxxxx");
			driver.findElement(By.xpath("//input[@id='input-payment-email']")).sendKeys(RandomStringUtils.randomAlphabetic(5)+"@gmail.com");
			driver.findElement(By.xpath("//input[@id='input-payment-telephone']")).sendKeys("xxxxx");
			driver.findElement(By.xpath("//input[@id='input-payment-password']")).sendKeys("xxxxx");
			driver.findElement(By.xpath("//input[@id='input-payment-confirm']")).sendKeys("xxxxx");
			driver.findElement(By.xpath("//input[@id='input-payment-company']")).sendKeys("xxxxx");
			driver.findElement(By.xpath("//input[@id='input-payment-address-1']")).sendKeys("xxxxx");
			driver.findElement(By.xpath("//input[@id='input-payment-city']")).sendKeys("xxxxx");
			driver.findElement(By.xpath("//input[@id='input-payment-postcode']")).sendKeys("xxxxx");
			
			WebElement CountryDropDown = driver.findElement(By.xpath("//select[@id='input-payment-country']"));
			Select myCountry = new Select(CountryDropDown);
			myCountry.selectByVisibleText("Argentina");
			
			WebElement RegionDropDown = driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
			Select myRegion = new Select(RegionDropDown);
			myRegion.selectByVisibleText("Catamarca");
			
			driver.findElement(By.xpath("//input[@name='agree']")).click();
			driver.findElement(By.xpath("//input[@id='button-register']")).click();	
			
						
	//----------Add comments, click continue and check the error message related to payment method---
			
			driver.findElement(By.xpath("//input[@id='button-payment-address']")).click();

			driver.findElement(By.xpath("//input[@id='button-shipping-address']")).click();
			driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("My Comments....");
			driver.findElement(By.xpath("//input[@id='button-shipping-method']")).click();
			
			driver.findElement(By.xpath("//div[@id='collapse-payment-method']//textarea[@name='comment']")).sendKeys("Comments about Your Order");
			driver.findElement(By.xpath("//input[@name='agree']")).click();
			driver.findElement(By.xpath("//input[@id='button-payment-method']")).click();
			
	//-------- Click on contact us hyperlink and submit a contact request and click continue
			driver.findElement(By.xpath("//a[normalize-space()='Contact Us']")).click();
			driver.findElement(By.xpath("//textarea[@id='input-enquiry']")).sendKeys("Enquiry comments...");
			driver.findElement(By.xpath("//input[@value='Submit']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
				
			
	}

}
