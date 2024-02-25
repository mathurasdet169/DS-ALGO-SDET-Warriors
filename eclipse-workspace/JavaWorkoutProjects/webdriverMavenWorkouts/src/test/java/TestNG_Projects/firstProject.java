package TestNG_Projects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class firstProject {
	
	WebDriver driver;
	
	//----------Open the app-----------
	  @Test (priority =1)
	  public void openapp() 
	  {
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://opensource-demo.orangehrmlive.com");
		  driver.manage().window().maximize();
	  }
	  
	  //-----------Validate the logo presence------------
	  @Test (priority =2)
	  void checkLogo()
	  {
		 boolean display = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		 System.out.println("Logo is displayed..."+display);
		 if(display)
		 {
			 System.out.println("Webpage launched successfully...");
		 }
		 else
		 {
			 System.out.println("Webpage launch failed....");
		 }
	  }
	  	  
	  //------------Validate successful Login to app--------------
	  @Test (priority =3)
	  void login()
	  {
		  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		  driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		  if(driver.getTitle().equals("OrangeHRM"))
				  {
			  		System.out.println("Login Successful...");
				  }
		  else
		  {
			  System.out.println("Login Failed...");
		  }
		  
		  driver.quit();
		    
	  }
	  
	  
}

