package TestNG_Projects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependsUpon 
{
	@Test (enabled = false, priority=2, description = "This tests the application Launch")
	void launchApp()
	{
		System.out.println("App is launched...");
		Assert.assertTrue(false);
	}
	
	@Test (priority=1, dependsOnMethods = "launchApp", alwaysRun= true)
	void signIn()
	{
		System.out.println("Logged in successfully..");
	}
	
	@Test (priority=3, dependsOnMethods = "signIn")
	void signOut()
	{
		System.out.println("Logged out successfully..");
	}
}
