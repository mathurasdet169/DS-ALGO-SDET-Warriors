package webdriverProj;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDownsSelect {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		
		//----------selectByVisibleText-----------------
		WebElement myDrpDwn = driver.findElement(By.id("fruits"));
		Select mySelect = new Select(myDrpDwn);
		mySelect.selectByVisibleText("Orange");
		
		//------------selectByValue---------------------
		WebElement myCountry = driver.findElement(By.id("country"));
		Select CtrySelect = new Select(myCountry);
		CtrySelect.selectByValue("India");
		WebElement SelectedText = CtrySelect.getFirstSelectedOption();
		System.out.println(SelectedText.getText());
		
		//-----------Select multiple values in a dropdown-----------
		WebElement heros = driver.findElement(By.id("superheros"));
		Select heroSelect = new Select(heros);
		boolean multiple = heroSelect.isMultiple(); // to check whether a drop down allows multiple selection
		System.out.println("'Select your super heros' dropdown is multiple: "+multiple);
		heroSelect.selectByIndex(1);
		heroSelect.selectByValue("bp");
		heroSelect.selectByVisibleText("Doc Savage");
		heroSelect.selectByIndex(0);
		
		
		
		//----------Deselect item ---ONLY applicable for Multiple drop down----------
		heroSelect.deselectByValue("aq");
		
		List<WebElement> selectedHeroes = heroSelect.getAllSelectedOptions();
		
		for (WebElement i:selectedHeroes)
			System.out.println(i.getText());

		System.out.println("Number of super heros selected are :"+selectedHeroes.size());
		
		
	
		
		//---------getOptions----get all available options in a drop down-----
		List<WebElement> hero_Options = heroSelect.getOptions();
		
		System.out.println("The number of options available in 'Select your super hero' is: "+hero_Options.size()+". They are given below :");
		for (WebElement i:hero_Options)
			System.out.println(i.getText());
		
		
		//-------------BootStrap Dropdown ---(which doesnt have select tag)--have to work with findElement and click.
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.findElement(By.xpath("//div[@class='ui selection dropdown upward']`")).click();
		driver.findElement(By.xpath(" //div[@class='text'][normalize-space()='Female']")).click();
		
				
		
		//driver.quit();
		
		
	}

}
