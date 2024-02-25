package TestNG_Projects;

import org.testng.annotations.Test;

public class groupSignup
{
	@Test (priority = 1, groups = "regression")
	void SignUpFacebook()
	{
		System.out.println("This is  regression group...");
	}
	
	@Test (priority = 2, groups = "regression")
	void SignUpTwitter()
	{
		System.out.println("This is regression group...");
	}
	
	@Test (priority = 3, groups = "regression")
	void SignUpGmail()
	{
		System.out.println("This is regression group...");
	}

}
