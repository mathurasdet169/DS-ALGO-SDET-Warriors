package orangeHRM;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	// WebDriver driver;
	
	public static void takescreenshot(String stepName) throws IOException
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://selenium.dev");
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
		
		String TCName="TC_001";
		String dir=System.getProperty("user.dir");
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		String path = dir+"/src/test/resources/screenshots/"+TCName+"/screenshot_"+stepName+time+".jpeg";
		
		File destFile=new File(path);
		
		FileUtils.copyFile(srcFile, destFile);
		
		
	}
	
	public static void main(String[] args) throws IOException {
		takescreenshot("SeleniumHomePage");
	}
}
