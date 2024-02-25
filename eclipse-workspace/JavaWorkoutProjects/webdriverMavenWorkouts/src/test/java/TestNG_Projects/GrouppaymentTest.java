package TestNG_Projects;

import org.testng.annotations.Test;

public class GrouppaymentTest
{
	@Test (priority = 1, groups = {"sanity","regression","combined"})
	void PaymentFacebook()
	{
		System.out.println("This is  sanity and regression group...");
	}
	
	@Test (priority = 2, groups = {"sanity","regression","combined"  })
	void paymentTwitter()
	{
		System.out.println("This is  sanity and regression group...");
	}
	
	@Test (priority = 3, groups = {"sanity","regression","combined"})
	void paymentGmail()
	{
		System.out.println("This is  sanity and regression group...");
	}

}
