package SeleniumConcepts;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class A1LaunchApp {

	public static void main(String[] args) throws InterruptedException {
		
		//Selection of browser by the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your browser name: ");
		String browser = sc.next();
		WebDriver driver;
		switch(browser)
		{
		case "chrome": driver = new ChromeDriver();
						break;
		case "edge": driver = new EdgeDriver();
						break;
		default: System.out.println("The browser entered is invalid.");
				 driver = new ChromeDriver();	
		}
		
		//Provide the URL
		driver.get("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(8000);
		
		//Enter the User name and password and Login
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		//Validate the screen opened		
		boolean display = driver.findElement(By.xpath("/html/body")).isDisplayed();
		
		if (display)
		 System.out.println("You logged in successfully");
		else
			 System.out.println("You didnt logged in successfully");

		//Exit the page
		driver.quit();
		
		
		
	}

}
