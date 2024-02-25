import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath {

	public static void main(String[] args) throws InterruptedException
	{
	 //Create Driver, Launch Url and Maximize window
	 ChromeDriver driver = new ChromeDriver();
	 driver.get("https://demo.opencart.com/");
	 driver.manage().window().maximize();
	 Thread.sleep(3000);
	 
	  /*//xpath with single attribute
	 	driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Canon");
	 
	 //xpath with multiple attribute
	 	driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("MacBook");	
	 	driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).clear();	

	  //xpath using text() function or method  
	  	String myText = driver.findElement(By.xpath("//a[text()='MacBook']")).getText();
	  	System.out.println("The text of the link is "+myText);
	  
	  
	  //xpath using contains() function or method  
	  	driver.findElement(By.xpath("//input[contains(@placeholder,'Sear')]")).sendKeys("MacBook");	
	  	driver.findElement(By.xpath("//a[contains(text(),'MacB')]")).click();
	  	
	  //xpath using starts-with() function or method  
	  	driver.findElement(By.xpath("//img[starts-with(@title,'Your')]")).click();*/
	  	
	    //Thread.sleep(3000);
	    WebElement wb = driver.findElement(By.xpath("//a[text()='MacBook']")); //use normalize here
	  //??Exception---Element is not clickable at point (139, 892)????
	    
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", wb); /// use wb in nameInputField
	 
	  //chained xpath 
	    boolean logoImage = driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
	    if (logoImage==true)
	    	System.out.println("The LOGO image is displayed");
	    else
	    	System.out.println("The LOGO image is not displayed");

		  
	    driver.quit();
	}

}
