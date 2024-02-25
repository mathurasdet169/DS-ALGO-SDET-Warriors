package SeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class webTableFlights {

	public static void main(String[] args) 
	{
		ChromeDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		//------------Find the flights available--------------------
		WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
		//fromPort.click();
		Select fromCity = new Select(fromPort);
		fromCity.selectByVisibleText("Boston");
		
		WebElement toPort = driver.findElement(By.xpath("//select[@name='toPort']"));
		//fromPort.click();
		Select toCity = new Select(toPort);
		toCity.selectByVisibleText("London");
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		
		//--------------Find the cheapest Airline available--------------------------
		
		double min = Double.MAX_VALUE;
						
		int rows = driver.findElements(By.xpath("//div//tbody//tr")).size();
		System.out.println("The number of rows are :"+rows);
		for(int i=1; i<=rows; i++)
		{
			String myCost = driver.findElement(By.xpath("//div//tbody//tr["+i+"]//td[6]")).getText();
		 	 myCost = myCost.replaceAll("\\$", "");
		 	 System.out.println(myCost);
			double final_cost = Double.parseDouble(myCost);
				
			if(final_cost<min)
			{
				min = final_cost;
			}
			
		}
		System.out.println("The minimum flight cost is "+min);
		
		//-------------Click to book the cheapest Airline----------------------
		
		for(int i=1; i<=rows; i++)
		{
			String myCost = driver.findElement(By.xpath("//div//tbody//tr["+i+"]//td[6]")).getText();
		    myCost = myCost.replaceAll("\\$", "");
		 	double final_cost = Double.parseDouble(myCost);
				
			if(final_cost==min)
			{
				String Airline = driver.findElement(By.xpath("//div//tbody//tr["+i+"]//td[3]")).getText();
				System.out.println("The cheapest Airline is: "+Airline);
				driver.findElement(By.xpath("//div//tbody//tr["+i+"]//td[1]")).click();
				break;
			}
			
		}
		
		//-----------Enter details and book Flight---------------------------------------
		
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Sairama");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Shirdi, India");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("City");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Tamilnadu");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("637462");
		
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		
		//------------Confirm Ticket Booking--------------------------
		String BookMessage = driver.findElement(By.xpath("//div//h1")).getText();
		if (BookMessage.contains("Thank you"))
			System.out.println("You have booked the flight ticket successfully!");
		
		driver.quit();
		
	}

}
