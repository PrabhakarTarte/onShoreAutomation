package com.tarte.listener;
import org.testng.*;


public class MyTestListener extends TestListenerAdapter  {
	
	 @Override
	    public void onTestFailure(ITestResult result) {
	        // do what you want to do
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        // do what you want to do
	    }

	   @Override
	    public void onTestSkipped(ITestResult result) {
	        // do what you want to do
	    }
	
	

}
