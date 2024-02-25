
package TestNG_Projects;

import org.testng.annotations.Test;

public class groupLogin
{
	@Test (priority = 1, groups = "sanity")
	void LoginFacebook()
	{
		System.out.println("This is  sanity group...");
	}
	
	@Test (priority = 2, groups = "sanity")
	void LoginTwitter()
	{
		System.out.println("This is sanity group...");
	}
	
	@Test (priority = 3, groups = "sanity")
	void LoginGmail()
	{
		System.out.println("This is sanity group...");
	}

}
