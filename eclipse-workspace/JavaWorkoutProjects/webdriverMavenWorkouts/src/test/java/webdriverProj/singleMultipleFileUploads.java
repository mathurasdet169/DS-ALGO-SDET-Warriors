package webdriverProj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class singleMultipleFileUploads {

	public static void main(String[] args) 
	{
	
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php/");
		driver.manage().window().maximize();
		
		String file1 = "C:\\Orders\\FirstOrdertext.txt";
		
		String file2 = "C:\\Orders\\SecondOrdertext.txt";
		
		//-----------Upload single File---------------
		//driver.findElement(By.id("filesToUpload")).sendKeys(file1);
		
		//--------Upload multiple files-------------
		driver.findElement(By.id("filesToUpload")).sendKeys(file1+"\n"+file2);
		
		//--------Check the number of files uploaded------------
		int noOfFiles = driver.findElements(By.xpath("//ul[@id='fileList']/li")).size();
		
		String file1Name = driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText();
		System.out.println(file1Name);
		
		System.out.println("No of files uploaded is: "+noOfFiles);
		
		//-----------Validating uploaded File names--------------------
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText().equals("FirstOrdertext.txt")&& 
				driver.findElement(By.xpath("//ul[@id='fileList']/li[2]")).getText().equals("SecondOrdertext.txt"))
		{
			System.out.println("Files uploaded succesfully...");
		}
		else
		{
			System.out.println("Files upload failed.......");
		}
			
		
		
		//driver.quit();
		
	}

}
