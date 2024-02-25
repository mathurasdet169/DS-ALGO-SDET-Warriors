package TestNG_Projects;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class beforeAfterClass
{
	@BeforeClass
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

	@AfterClass
	void Logout()
	{
		System.out.println("This is After Test Method..");
	}


}
