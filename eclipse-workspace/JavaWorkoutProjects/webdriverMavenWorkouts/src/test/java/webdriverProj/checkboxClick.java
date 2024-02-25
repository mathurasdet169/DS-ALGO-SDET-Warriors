package webdriverProj;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkboxClick {

	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		List<WebElement> myCheckboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type = 'checkbox']"));
		int size = myCheckboxes.size();
		System.out.println("The number of checkbox under Days are :"+size);
		
		
		//Selecting last 3 check boxes
		for(int i=size-1; i>=size-3;i--)
		{
			myCheckboxes.get(i).click();	
		}
		
		//Selecting all the check boxes

//		for(WebElement chkbox:myCheckboxes)
//			chkbox.click();
		
//		//Selecting first 3 check boxes
//		for(int i=0; i<size-4; i++)
//			{
//				myCheckboxes.get(i).click();	
//			}
		
		
		Thread.sleep(5);
		//Uncheck the Check boxes --- only the selected ones
		for (WebElement i:myCheckboxes)
		{
			if(i.isSelected())
			{
				i.click();
			}
		}
		
		List<WebElement> Pag_ChkBoxes = driver.findElements(By.xpath("//input[@type='checkbox' ]/parent::td"));
		int size2 = Pag_ChkBoxes.size();
		System.out.println("The no of check box in Pagination Table is :"+size2);
		System.out.println(Pag_ChkBoxes);
		for(WebElement i:Pag_ChkBoxes)
			i.click();
		
		
		//driver.quit();
		
	}

}
