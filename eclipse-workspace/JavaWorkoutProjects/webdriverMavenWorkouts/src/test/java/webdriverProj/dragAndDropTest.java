package webdriverProj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDropTest {

	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		//------------Drag And Drop----------------
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform();
		
		//---------------Drag And Drop By------------
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		WebElement src_ele = driver.findElement(By.id("draggable"));
		System.out.println(src_ele.getText());
		int x = src_ele.getLocation().getX();
		int y = src_ele.getLocation().getY();
		System.out.println(x+" , "+y);
		
		builder.dragAndDropBy(src_ele, x+120, y+120).perform();		
		
		
	}

}
