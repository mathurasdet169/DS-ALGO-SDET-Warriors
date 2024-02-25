package webdriverProj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class paginationDynamicWebtable {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed())
		{
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		String myText = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		System.out.println(myText);
		
		String myPages = myText.substring((myText.indexOf("(")+1),(myText.indexOf("Pages")-1));
		
		int Tot_Pages = Integer.parseInt(myPages);
		System.out.println(Tot_Pages);
		
		for(int p=1; p<=10; p++)
			{
			  if(p>1)
				{
					WebElement myPage = driver.findElement(By.xpath("//ul[@class='pagination']//a[normalize-space()="+p+"]"));
					System.out.println("Current page no is: "+myPage.getText());
					Actions myact = new Actions(driver);
					myact.moveToElement(myPage).click().perform();
					
					//myPage.click();
				}
			  
			  int rowsNo = driver.findElements(By.xpath("//tbody//tr")).size();
     		  System.out.println(rowsNo);
			  
			  for(int r=1; r<=rowsNo; r++)
			  {
			  String CustName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
 			  String Email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
			  System.out.println("Customer Name is: "+CustName+"\t"+". Email id is: "+Email);
			  		
			  }	  
			
			}
			  
			

	}
}
