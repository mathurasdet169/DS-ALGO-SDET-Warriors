import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class bstackDemoProductOrder {

	public static void main(String[] args){
			
		//----------Launch the browser and open website----------
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://bstackdemo.com/");
		driver.manage().window().maximize();
		
		//----------Clicking the Vendor Samsung---------
		driver.findElement(By.xpath("//span[text()='Samsung']")).click();
		
		//----------Adding Galaxy S20 ultra to the cart by clicking Add To Cart-----------
		driver.findElement(By.xpath("//div[@data-sku='samsung-S20Ultra-device-info.png']/div[text()='Add to cart']")).click();

		//--------click Checkout Button
		driver.findElement(By.xpath("//div[@class='buy-btn']")).click();
				
		//----------Selecting Username data-----------
		driver.findElement(By.xpath("//div[@id='username']//div[@class=' css-tlfecz-indicatorContainer']")).click();
		driver.findElement(By.xpath("//div[text()='demouser']")).click();
		
		//----------Selecting Password data-----------
		driver.findElement(By.xpath("//div[@id='password']//div[@class=' css-tlfecz-indicatorContainer']")).click();
		driver.findElement(By.xpath("//div[text()='testingisfun99']")).click();
		
		
		//-------click Login Button-----------------
		driver.findElement(By.xpath("//button[@id='login-btn']")).click();
		
		//---------------Enter the shipping address details----------
		driver.findElement(By.xpath("//input[@id='firstNameInput']")).sendKeys("Vijayashree");
		driver.findElement(By.xpath("//input[@id='lastNameInput']")).sendKeys("LName");
		driver.findElement(By.xpath("//input[@id='addressLine1Input']")).sendKeys("My address");
		driver.findElement(By.xpath("//input[@id='provinceInput']")).sendKeys("State");
		driver.findElement(By.xpath("//input[@id='postCodeInput']")).sendKeys("56563");
		
		//----------Click the Submit Button---------------
		driver.findElement(By.xpath("//button[@id='checkout-shipping-continue']")).click();
		
		//-----------Print the Order Number----------------
		String OrderNo = driver.findElement(By.xpath("//strong")).getText();
		System.out.println("The Order number is: "+OrderNo);
		
		 //--------Click Continue Shopping Button---------
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		
		//---------------Logout the website--------
		driver.findElement(By.xpath("//a[@id='logout']")).click();
		
		//------------Quit the browser---------
		driver.quit();
		
		
	}

	
}
