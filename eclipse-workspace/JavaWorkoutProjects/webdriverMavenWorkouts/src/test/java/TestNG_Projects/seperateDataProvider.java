package TestNG_Projects;

import org.testng.annotations.DataProvider;

public class seperateDataProvider {
	
	@DataProvider(name = "dp1")
	Object[][] loginData()
	  {
		Object mydata[][] = { 
				 
							  {"abc@gmail.com","pass"},
							  {"viji@gmail.com","pass123"},
							  {"pavanol123@gmail.com","test@123"},
							  {"jay@gmail.com","pass@12"}
							  
							};
									
		return mydata;
	  }

}
