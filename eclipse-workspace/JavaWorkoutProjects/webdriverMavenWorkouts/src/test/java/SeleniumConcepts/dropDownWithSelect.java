package SeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDownWithSelect {

	public static void main(String[] args) 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		//-----------By Using Select------------------
		
		
		WebElement myCountry = driver.findElement(By.xpath("//select[@id='country-list']"));
		Select mySelect = new Select(myCountry);
		
		List<WebElement>myCountries = mySelect.getOptions();
		System.out.println("Total number of countries in drop down are: "+myCountries.size());
		
		mySelect.selectByVisibleText("China");
		mySelect.selectByValue("4");
		
		System.out.println("The listed countries are: ");
		for(WebElement i:myCountries)
		{
			System.out.println(i.getText());
		}
		
		mySelect.selectByVisibleText("China");
		mySelect.selectByValue("4");
		
		
	}

}
