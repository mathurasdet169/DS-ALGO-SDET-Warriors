package webdriverProj;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class webElementsLoc {

	public static void main(String[] args) throws InterruptedException 
	{
		//Browser selection by the user
		System.out.println("Enter your browser name please:");

		Scanner sc = new Scanner(System.in);
		String browser = sc.next();
		
		WebDriver driver;
		
		switch(browser)
		{
		case "chrome": driver = new ChromeDriver();
						break;
		case "edge": driver = new EdgeDriver();
						break;
		default: System.out.println("You have entered invalid browser. So the default browser is selected.");
				driver = new ChromeDriver();
		
		}
		
		//Enter the URL and maximize the screen
		driver.get("https://demoblaze.com");
		driver.manage().window().maximize();
		
		//Login with the user id and password details
		driver.findElement(By.id("login2")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("loginusername")).sendKeys("pavanol");
		driver.findElement(By.id("loginpassword")).sendKeys("test@123");
		driver.findElement(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]")).click();
		
		// Validate whether we logged in
		Thread.sleep(2000);
		boolean status = driver.findElement(By.id("logout2")).isDisplayed();
		if (status)
			System.out.println("Logged In successfully.");
		else
			System.out.println("Login failed.");
		
		//Validate whether user name is available on the web page
		String name = driver.findElement(By.id("nameofuser")).getText();
		if  (name.contains("pavanol"))
			System.out.println("The user has logged in successfully");
		else
			System.out.println("The user has not logged in successfully");

		//Exit the web page
		driver.quit();
	}

	
}
