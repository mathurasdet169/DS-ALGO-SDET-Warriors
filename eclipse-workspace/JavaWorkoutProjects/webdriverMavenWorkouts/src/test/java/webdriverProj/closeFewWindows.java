package webdriverProj;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class closeFewWindows {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		String page1 = driver.getTitle();
		System.out.println(page1);
		
		//driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		driver.get("https://www.orangehrm.com/");
		
		//OrangeHRM HR Software | OrangeHRM
		
		//driver.findElement(By.xpath("//a[normalize-space()='Open Source HRMS']")).click();
		driver.get("//a[normalize-space()='Open Source HRMS']");
		
		//Free HR Software | Open Source | OrangeHRM
		
		driver.get("//a[@href='https://api.orangehrm.com/']"); 
		
		//OrangeHRM apiDoc
	
		Set<String> windows_id = driver.getWindowHandles();
		System.out.println(windows_id);
		
		/*for (String win_id:windows_id)
		{
			String title = driver.switchTo().window(win_id).getTitle();
			
			if(title.equals())
			
		}*/
			
		
		
	}
	
}


