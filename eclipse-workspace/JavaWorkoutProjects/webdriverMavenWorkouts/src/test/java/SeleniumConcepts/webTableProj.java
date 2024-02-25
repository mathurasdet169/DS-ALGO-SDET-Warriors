package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTableProj {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//------------Find number of rows and columns---------------------
		int rows_no = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		int cols_no = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("This Web Table has "+(rows_no-1)+" rows and "+cols_no+" columns.");
		
		//-----------Get Data from specific Row of specific column----
		String myData = driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]//td[2]")).getText();
		System.out.println("The required data is "+myData);
		
		//-----------Read Data from all Rows and Columns--------------
		//-----------Read the Header--------------
		
		System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
		
		for(int i=2; i<=rows_no; i++)
		{
			for (int j=1; j<=cols_no; j++)
			{
				String myData1 = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
				System.out.print(myData1+"\t");
			}
			System.out.println();
		}
		
		//---------------Retrieve Data Based on Conditions-------------
		for(int i=2; i<=rows_no; i++)
		{
			String Subject = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[3]")).getText();
			//System.out.println(Subject);
			if(Subject.equals("Javascript"))
			{
				String BookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
				System.out.println("Book Name :"+BookName+"."+"\t"+"Subject: "+Subject);
			}
		}
		
		//--------------Find sum of a particular column values----------------
		int Tot_Price = 0;
		for(int i=2; i<=rows_no;i++)
		{
		String Price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
		
		Tot_Price = Tot_Price+Integer.parseInt(Price);
		
		}
		
		System.out.println("The Total Price of all books are : "+Tot_Price);
		
		//driver.quit();
		
		
	}

}
