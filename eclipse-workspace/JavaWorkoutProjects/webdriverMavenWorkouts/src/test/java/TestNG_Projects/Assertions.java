package TestNG_Projects;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions 
{
	@Test
	void myMethod()
	{
		String myValue = "Vijaya";
		SoftAssert sa = new SoftAssert();
		
		
		Assert.assertEquals(myValue,"Vijya","The expected value is incorrect..");
		
		System.out.println("After assert statement...");
	}
}
