package TestNG_Projects;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenerSravani implements ITestListener 

{
	public void  onTestSuccess(ITestResult result)
	{
		System.out.println("This is Success");
	}

	
	public void onTestFailure​(ITestResult result)
	{
		System.out.println("This is Failure");
	}
	
	public void onTestSkipped​(ITestResult result)
	{
		System.out.println("This is Skipped");
	}
	
	public void onStart​(ITestContext context)
	{
		System.out.println("This is Started");
	}
	
	public void onFinish​(ITestContext context)
	{
		System.out.println("This is finished");
	}
}
