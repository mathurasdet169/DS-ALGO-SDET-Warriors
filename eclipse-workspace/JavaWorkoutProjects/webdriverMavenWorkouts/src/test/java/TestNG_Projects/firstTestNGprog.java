package TestNG_Projects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class firstTestNGprog
	{
	ChromeDriver driver;
	@Test (priority =2)
	void openapp()
	{
		driver.get("https://www.google.com");
	}
	
	@Test (priority = 3)
	void second()
	{
		System.out.println("Welcome");
	}
	
	@Test(priority=1)
	void third()
	{
		System.out.println("to Test NG");
	}

	}
