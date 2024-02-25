package SeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropDownBootstrap {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		//-----------Without Using Select------------------
		WebElement Country = driver.findElement(By.xpath("//select[@id='country-list']"));
		List<WebElement> myCountries = 	driver.findElements(By.xpath("//select[@id='country-list']/option"));
		int size= myCountries.size();
		
		System.out.println("The no of countries in list are: "+(size-1)+". They are listed below: ");
		for(int i=1; i<size; i++)
			System.out.println(myCountries.get(i).getText());
		
		for(WebElement i:myCountries)
		{
			if(i.getText().equals("India"))
			{
				i.click();
				break;
			}
				
		}
		
		driver.quit();
		
	}

}
