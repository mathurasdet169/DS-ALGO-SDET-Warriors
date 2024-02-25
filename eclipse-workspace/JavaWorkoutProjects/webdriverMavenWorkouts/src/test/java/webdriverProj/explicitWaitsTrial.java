package webdriverProj;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class explicitWaitsTrial {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
				//1.wait() for an alert screen to open
//		driver.get("https://letcode.in/waits");
//		driver.findElement(By.xpath("//button[@id='accept']")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));		
//		wait.until(ExpectedConditions.alertIsPresent());
		
//		Alert myAlert = driver.switchTo().alert();
//		System.out.println("The Text of my Alert is :"+myAlert.getText());
//		myAlert.accept();

				//2.wait() for invisibility of an element
//		driver.get("https://letcode.in/signin");
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("koushik350@gmail.com");
//		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Pass123$");
//		driver.findElement(By.xpath("//button[normalize-space()='LOGIN']")).click();
//		
//		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		WebElement toast = driver.findElement(By.xpath("//div[@id='toast-container']"));
//		System.out.println(toast.getText());
//		myWait.until(ExpectedConditions.invisibilityOf(toast));
//		
//		driver.findElement(By.xpath("//a[normalize-space()='Sign out']")).click();
		
				//3.wait for the Title of the element 
		driver.get("https://avvaitamil.org/");
		driver.manage().window().maximize();
		WebElement loc = driver.findElement(By.xpath("//span[.='Locations']"));
		Actions myact = new Actions(driver);
		myact.moveToElement(loc).perform();
		WebElement link = driver.findElement(By.xpath("//li[@id='menu-item-36953']//span[@class='menu-text'][contains(text(),'Avvai – Lighthouse Center')]"));
		link.click();
		
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.titleContains("Lighthouse"));
		
		System.out.println(driver.getTitle());		
		
	}

}
