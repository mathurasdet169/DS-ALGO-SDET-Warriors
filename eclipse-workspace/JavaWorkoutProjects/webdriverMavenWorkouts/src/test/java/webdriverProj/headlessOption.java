package webdriverProj;


import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class headlessOption {

				public static void main(String[] args)
			{
			    //----Setting to Headless mode execution-------
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				ChromeDriver driver = new ChromeDriver(options);
				
				driver.get("https://letcode.in/buttons");
				
					
				int x = driver.findElement(By.id("position")).getLocation().getX();
				int y = driver.findElement(By.id("position")).getLocation().getY();
				System.out.println("The coordinates of myElement are X: "+x+" Y: "+y+"\n");
				
				//To find the COLOR of the element
				String backGroundColor = driver.findElement(By.id("color")).getCssValue("background-color");
				String textColor = driver.findElement(By.id("color")).getCssValue("color");
				String borderColor = driver.findElement(By.id("color")).getCssValue("border-color");
				System.out.println("My button elements backgroung color is: "+backGroundColor+"\n"
											+"It's text color is: "+textColor
											+"\n"+"It's border color is "+borderColor);
				
				//to get the dimensions(width, height) of a button
				System.out.println("The width and height of my element are: "+driver.findElement(By.id("property")).getRect().getDimension());
				
				System.out.println("The size are :"+driver.findElement(By.id("property")).getSize());
				
				
				//too check whether the button is enabled or not
				boolean btnEnable = driver.findElement(By.id("isDisabled")).isEnabled();
				if (btnEnable == true)
					System.out.println("The button is enabled.");
				else
					System.out.println("The button is disabled.");

				driver.quit();
					

	}

}
