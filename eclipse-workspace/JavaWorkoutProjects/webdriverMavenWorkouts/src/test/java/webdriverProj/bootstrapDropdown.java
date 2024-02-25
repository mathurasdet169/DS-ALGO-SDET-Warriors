package webdriverProj;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class bootstrapDropdown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		WebElement WebDropDown = driver.findElement(By.xpath("//b[@class='caret']"));
		
		WebDropDown.click();
		
		WebElement java = driver.findElement(By.xpath("//label[normalize-space()='Java']"));
		java.click();
		
		driver.findElement(By.xpath("//label[normalize-space()='Python']")).click();
		
		List<WebElement> myDropDownList = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//input")); 
		
		System.out.println("No of elements in dropdown are: "+myDropDownList.size());
		for(WebElement i:myDropDownList)
		{
			System.out.println(i.getAttribute("value"));
		}
		driver.quit();
	}

}
