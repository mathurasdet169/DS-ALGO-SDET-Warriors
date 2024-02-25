package webdriverProj;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshotWebpages {

	public static void main(String[] args)
	{
		ChromeDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//-------------Screenshot of Web page-------------------------
		TakesScreenshot ts = driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir")+"\\screenshots\\webpage.png");
		sourcefile.renameTo(targetfile);
		
		
		//----------------Screenshot of section of web page------------------
		WebElement section = driver.findElement(By.xpath("//div[@class='category-grid home-page-category-grid']//div[@class='item-grid']"));
		File sourcefile2 = section.getScreenshotAs(OutputType.FILE);
		File targetfile2 = new File(System.getProperty("user.dir")+"\\screenshots\\section.png");
		sourcefile2.renameTo(targetfile2);
		
		
		//-------------Screenshot of one Web Element----------------------
		WebElement myPhone = driver.findElement(By.xpath("//img[@title='Show details for HTC One M8 Android L 5.0 Lollipop']"));
		File sourcefile3 = myPhone.getScreenshotAs(OutputType.FILE);
		File targetfile3 = new File(System.getProperty("user.dir")+"\\screenshots\\myPhone.png");
		sourcefile3.renameTo(targetfile3);		
		
		driver.quit();
				
		
	}

}
