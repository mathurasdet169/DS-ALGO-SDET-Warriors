package TestNG_Projects;

import org.testng.annotations.Test;

public class invocationCount
{
	@Test (priority = 1, invocationCount = 3,  invocationTimeOut = 5, description = "Checking 3 invocations")
	void method1()
	{
		System.out.println("This is to check 3 Invocations..");
	}
	
	@Test (priority = 2, invocationCount = 2, description = "Checking 2 invocations")
	void method2()
	{
		System.out.println("This is to check 2 invocations");
	}
	

}
