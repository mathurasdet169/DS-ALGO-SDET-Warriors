package orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
 
	static WebDriver driver;
  
	static WebDriver getChromeDriver()
	{
		driver=new ChromeDriver();
		return driver;
	}
}
