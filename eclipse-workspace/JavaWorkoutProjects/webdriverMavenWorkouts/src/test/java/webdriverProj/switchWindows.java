package webdriverProj;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchWindows {

	public static void main(String[] args)
	{
		ChromeDriver driver= new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();


		//Method 1 to switch windows using Set and convert to List and get Windows Id and use SwitchTo
		// mostly used with 2 windows. Not preferred to work with multiple windows of 5 to 6.
		//		Set<String> window_ids = driver.getWindowHandles();
		//		List<String> windows_List = new ArrayList(window_ids);
		//		String par_Window = windows_List.get(0);
		//		
		//		String child_Window = windows_List.get(1);
		//		
		//		System.out.println("The current window is "+driver.getTitle());
		//		
		//		driver.switchTo().window(child_Window);
		//		System.out.println("After switching to child window "+driver.getTitle());
		//		
		//		driver.switchTo().window(par_Window);
		//		System.out.println("After switching back to parent window "+driver.getTitle());
		//		
		//		driver.switchTo().window(child_Window);
		//		System.out.println("After switching to child window again "+driver.getTitle());
		//		
		//		driver.quit();


		//Method 2 using for loop and if condition to perform req actions. Preferred when multiple windows are open.
		// Mostly preferred
		Set<String> window_ids = driver.getWindowHandles(); 	 	

		for (String win:window_ids)
		{
			String title = driver.switchTo().window(win).getTitle();
			if (title.equals("OrangeHRM HR Software | OrangeHRM"))
			{
				driver.close();
			}
		}


	}

}
