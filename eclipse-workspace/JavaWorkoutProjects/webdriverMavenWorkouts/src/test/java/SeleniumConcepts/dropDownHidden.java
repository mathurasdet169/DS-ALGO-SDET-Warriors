package SeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropDownHidden {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();		
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();
		driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();
		
		WebElement jobTitle = driver.findElement(By.xpath("//div[@role='listbox']"));
		List<WebElement> myJobs = driver.findElements(By.xpath("//div[@role='listbox']/div/span"));
		int x = myJobs.size();
		
		
		System.out.println("There are "+x+" Job Titles. They are given below: ");
		for (WebElement i:myJobs)
			System.out.println(i.getText());
		
		for (WebElement i:myJobs)
		{
			if(i.getText().equals("Chief Technical Officer"))
					{
						i.click();
						break;
					}
			
		}
		
		driver.quit();
		
				
	}

}
