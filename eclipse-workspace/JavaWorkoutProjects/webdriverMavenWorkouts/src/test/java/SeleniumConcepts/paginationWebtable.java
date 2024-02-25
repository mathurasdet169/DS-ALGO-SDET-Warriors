package SeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class paginationWebtable {

	public static void main(String[] args) 
	{
		ChromeDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		for(int i=1; i<=4;i++)
		{
			//Click the page one by one
			if(i>1)
			{
			WebElement myPage = driver.findElement(By.xpath("//ul[@class='pagination']//a[normalize-space()="+i+"]"));
			myPage.click();
			}
			
			// Capture the number of rows in the webtable
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));
			int RowsNo = rows.size();
			
			//Capture the elements and click dropdown in each page
			for(int r=1; r<=RowsNo; r++)
			{
				//----Capture Product Name-----------
			WebElement ProdName = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]"));
			System.out.println("Product name is: "+ProdName.getText());
			
			//----------Capture Price------------------
			WebElement Price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[3]"));
			System.out.println("Product price is: "+Price.getText());
			
			}
			
		}
		
		
		
		
	}
	
	

}
