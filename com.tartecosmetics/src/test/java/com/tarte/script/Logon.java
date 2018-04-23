package com.tarte.script;
import org.testng.annotations.Test;
import jxl.Sheet;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.tarte.config.Config.waitThread;
import static com.tarte.config.Config.loadPro;
import static com.tarte.config.Config.click;
import static com.tarte.config.Config.getChromeDriver;
import static com.tarte.config.Config.setText;
import static com.tarte.config.Config.loadExcel;
import static com.tarte.config.Config.waitForSpinner;
import static com.tarte.config.Config.javaScriptClick;

import java.util.Properties;

public class Logon {

	WebDriver driver;
	Properties propSignup;
	Sheet s;

	@BeforeTest
	public void logon() {
		propSignup = loadPro("src\\test\\resources\\repository\\signup.properties");
		driver = getChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tartecosmetics.com");
		s = loadExcel("INPUT\\signup.xls");
		waitForSpinner(driver);
		waitThread(2000l);
	}
	
	@Test
	public void signUp() {

		String fname = s.getCell(0, 1).getContents();
		String lname = s.getCell(1, 1).getContents();
		String bday = s.getCell(2, 1).getContents();
		String email = s.getCell(3, 1).getContents();
		String pass = s.getCell(4, 1).getContents();

		click(propSignup.getProperty("myaccount"), driver);
		
		waitThread(2);
		
		setText(fname, propSignup.getProperty("firstname"), driver);
		setText(lname, propSignup.getProperty("lastname"), driver);
		setText(bday, propSignup.getProperty("bday"), driver);
		setText(email, propSignup.getProperty("email"), driver);
		setText(email, propSignup.getProperty("confirmemail"), driver);
		setText(pass, propSignup.getProperty("password"), driver);
		setText(pass, propSignup.getProperty("confirmpassword"), driver);
		
		click(propSignup.getProperty("create"), driver);

	}
	
	
	public static void click(String xpath, WebDriver driver) {
		driver.findElement(By.xpath(xpath)).click();
	}
	public static void setText(String text, String xpath, WebDriver driver) {
		try {

			driver.findElement(By.xpath(xpath)).click();
			waitThread(100l);
			driver.findElement(By.xpath(xpath)).sendKeys(text);
		} catch (Exception e) {
			System.out.println("catch0");
		}
		
	}
}
