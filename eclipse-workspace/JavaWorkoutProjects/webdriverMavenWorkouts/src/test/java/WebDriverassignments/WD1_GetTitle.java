package WebDriverassignments;

import org.openqa.selenium.chrome.ChromeDriver;

public class WD1_GetTitle {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com");
		String title = driver.getTitle();
		System.out.println("The Title of your page is '"+title+"'.");
		driver.close();
		
		
		
	}

}
