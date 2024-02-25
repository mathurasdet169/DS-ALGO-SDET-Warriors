package TestNG_Projects;

import org.testng.annotations.*;

public class Annotations1
{
	@AfterSuite
	void trial()
	{
		System.out.println("Thos is After Suite Method...");
	}
	
	@BeforeMethod 
	void login()
	{
		System.out.println("This is the Before method");
	}
	@Test (priority=1)
	void search()
	{
		System.out.println("This is the Test Search method");
	}
	
	@AfterMethod
	void logout()
	{
		System.out.println("This is the After  method");
	}
	
	@Test (priority=2)
	void AdvancedSearch()
	{
		System.out.println("This is the Test Advanced Search method");
	}
	
	@BeforeClass
	void beforeClass()
	{
		System.out.println("This is Before Class Method");
	}
	
	@AfterClass
	void afterClass()
	{
		System.out.println("This is After Class Method");
	}
	
}
