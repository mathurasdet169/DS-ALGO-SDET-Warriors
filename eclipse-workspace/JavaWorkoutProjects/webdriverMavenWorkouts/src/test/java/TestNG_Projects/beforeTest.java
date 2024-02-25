package TestNG_Projects;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class beforeTest 
{
	@BeforeSuite
	void suite()
	{
		System.out.println("Thos is Before Suite method...");
	}
	@BeforeTest
	void Login()
	{
		System.out.println("This is Before Test Method..");
	}
	
	@Test (priority=1)
	void Search()
	{
		System.out.println("This is Test Search Method..");
	}

	
	@Test (priority=2)
	void AdvancedSearch()
	{
		System.out.println("This is Advanced Search Test Method..");
	}

	@AfterTest
	void Logout()
	{
		System.out.println("This is After Test Method..");
	}


}
