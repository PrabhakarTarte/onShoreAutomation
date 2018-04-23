package com.tarte.listener;

import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import static com.tarte.config.Config.takeScreenShot;
import static com.tarte.config.Config.loadPro;
import static com.tarte.config.Config.createExcel;
import static com.tarte.config.Config.closeExcel;
import static com.tarte.config.Config.writeToExcel;
import static com.tarte.basePage.Login.returnDriver;

public class TestListener implements ITestListener ,ITestResult

{

	Properties p;
	WebDriver driver;
	WritableSheet ws;
	WritableWorkbook ww;

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		driver = returnDriver();
		p = loadPro("com.tartecosmetics\\src\\test\\resources\\repository\\paths.properties");
		takeScreenShot("fail.jpg", p.getProperty("failpath"), driver);

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		driver = returnDriver();
		p = loadPro("com.tartecosmetics\\src\\test\\resources\\repository\\paths.properties");
		takeScreenShot("fail.jpg", p.getProperty("failpath"), driver);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("Inside onTestFailure");
		System.out.println(arg0.getStatus());
		driver = returnDriver();
		p = loadPro("com.tartecosmetics\\src\\test\\resources\\repository\\paths.properties");
		//takeScreenShot("fail.jpg", p.getProperty("failpath"), driver);
		/*System.out.println("ITEST Quit");
		driver.quit();*/
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		driver = returnDriver();
		p = loadPro("com.tartecosmetics\\src\\test\\resources\\repository\\paths.properties");
		takeScreenShot("fail.jpg", p.getProperty("failpath"), driver);

	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		driver = returnDriver();
		p = loadPro("com.tartecosmetics\\src\\test\\resources\\repository\\paths.properties");
		takeScreenShot("fail.jpg", p.getProperty("failpath"), driver);

	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Inside onTestSuccess");
		System.out.println(arg0.getStatus());

		driver = returnDriver();
		p = loadPro("com.tartecosmetics\\src\\test\\resources\\repository\\paths.properties");
		takeScreenShot("pass.jpg", p.getProperty("passpath"), driver);
		excel();
		writeToExcel(ws, 0, 1, "SC1");
		writeToExcel(ws, 1, 1, "pass");
		closeExcel(ww);
	}

	public void excel() {
		ww = createExcel(p.getProperty("excelpath"));
		ws = ww.createSheet("result", 0);
		writeToExcel(ws, 0, 0, "scenario");
		writeToExcel(ws, 1, 0, "result");
	}

	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAttribute(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

	public Set<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object removeAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public int compareTo(ITestResult o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setStatus(int status) {
		// TODO Auto-generated method stub
		
	}

	public ITestNGMethod getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setParameters(Object[] parameters) {
		// TODO Auto-generated method stub
		
	}

	public IClass getTestClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Throwable getThrowable() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setThrowable(Throwable throwable) {
		// TODO Auto-generated method stub
		
	}

	public long getStartMillis() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getEndMillis() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setEndMillis(long millis) {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTestName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getInstanceName() {
		// TODO Auto-generated method stub
		return null;
	}

	public ITestContext getTestContext() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
