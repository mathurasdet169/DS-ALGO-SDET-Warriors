package webdriverProj;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingInputs {

	public static void main(String[] args) 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/edit");
		
		driver.findElement(By.id("fullName")).sendKeys("Srikrishna",Keys.TAB); // how to use Keys like TAB
		
		driver.findElement(By.id("join")).sendKeys("student always.");// to append text to an existing text
			
		String myValue = driver.findElement(By.id("getMe")).getAttribute("value"); //to get value of any attribute of an element
		System.out.println("The value of the text box is: "+myValue); 
		
		driver.findElement(By.id("clearMe")).clear(); // to clear the text
		
		boolean enabled = driver.findElement(By.id("noEdit")).isEnabled();//to find the web element is enabled or not
		System.out.println("The textbox is enabled: "+enabled);
		
		String readOnly = driver.findElement(By.id("dontwrite")).getAttribute("readonly");
		System.out.println("The value is readonly: "+readOnly);
		
		
	}

}
