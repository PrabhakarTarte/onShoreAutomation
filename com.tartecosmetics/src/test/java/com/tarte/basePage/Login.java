package com.tarte.basePage;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;

import static com.tarte.config.Config.waitThread;
import java.util.Properties;
import static com.tarte.config.Config.loadPro;
import static com.tarte.config.Config.click;
import static com.tarte.config.Config.getChromeDriver;
import static com.tarte.config.Config.setText;
import static com.tarte.config.Config.loadExcel;
import static com.tarte.config.Config.waitForSpinner;

import jxl.Sheet;

public class Login {
	static WebDriver driver;
	Properties propSignin;
	Properties propSignout;
	Sheet s;

	@BeforeTest
	public void login() {
		propSignin = loadPro("src\\test\\resources\\repository\\signin.properties");
		driver = getChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tartecosmetics.com");
		s = loadExcel("INPUT\\signin.xls");
		waitForSpinner(driver);
		waitThread(2000l);
	}

	@Test
	public void signIn() {
		String email = s.getCell(0, 1).getContents();
		String password = s.getCell(1, 1).getContents();

		click(propSignin.getProperty("myaccount"), driver);
		click(propSignin.getProperty("login"), driver);
		waitThread(2000l);
		setText(email, propSignin.getProperty("email"), driver);
		setText(password, propSignin.getProperty("password"), driver);
		click(propSignin.getProperty("Login"), driver);
		waitThread(1001);
		click(propSignout.getProperty("Logout"),driver);
	}

	public static WebDriver returnDriver() {
		return driver;
	}

	@AfterTest
	public void logout() {
		propSignout = loadPro("src\\test\\resources\\repository\\signout.properties");
		click(propSignout.getProperty("logout"), driver);
	}
}
