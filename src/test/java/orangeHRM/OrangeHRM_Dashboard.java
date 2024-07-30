package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class OrangeHRM_Dashboard {
	static WebDriver driver; 
	
	@FindBy(xpath="//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span") WebElement myInfoTab;
	@FindBy(partialLinkText ="viewLeaveModule") WebElement leaveTab;
	@FindBy(partialLinkText = "viewAdminModule")WebElement adminTab;
	
	@Test
	public void user_navigateto_myinfo_navigateTo_contactDetails()
	{
		driver=DriverFactory.driver;
	//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");
		//myInfoTab.click();
		driver.findElement(By.xpath("//div//span[text()='My Info']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Contact Details']")).click();
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Madurai");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input")).sendKeys("shanthi sadhan");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("9876543210");
		driver.findElement(By.xpath("//div// button[text()=\" Save \"]")).click();
		
		
		
	}
	public void user_navigateto_emergencyContact_updateDetails() 
	{
		driver.findElement(By.xpath("//a[normalize-space()='Emergency Contacts']")).click(); //emergency contacts
		driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Add'])[1]")).click(); //add contact
		driver.findElement(By.xpath("//label[text()='Name']/../../div[2]/input")).sendKeys("Sangeeth"); //add name
		driver.findElement(By.xpath("//label[text()='Relationship']/../../div[2]/input")).sendKeys("Spouse"); //add relationship
		driver.findElement(By.xpath("//label[text()='Home Telephone']/../../div[2]/input")).sendKeys("1234567899"); //add contact no.
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();//save contact
		
		
	}
	public void user_navigateto_dependants_updateDetails() 
	{
		driver.findElement(By.xpath("//a[normalize-space()='Dependents']")).click();
		driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Add'])[1]")).click();
		driver.findElement(By.xpath("//label[text()='Name']/../../div[2]/input")).sendKeys("Aadhav");
		driver.findElement(By.xpath("//label[text()=\"Relationship\"]/../../div[2]")).click();
		driver.findElement(By.xpath("//div[@role=\"listbox\"]//*[contains(text(),'Child')]")).click();
		driver.findElement(By.xpath("//div//input[@placeholder=\"yyyy-dd-mm\"]")).sendKeys("2023-06-07");
		driver.findElement(By.xpath("//div//button[@type=\"submit\"]")).click();
		
	}
	
	}
