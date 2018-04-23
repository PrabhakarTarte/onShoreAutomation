package com.tarte.script;

import static com.tarte.config.Config.click;
import static com.tarte.config.Config.clickJS;
import static com.tarte.config.Config.getChromeDriver;
import static com.tarte.config.Config.getNewDriver;
import static com.tarte.config.Config.loadExcel;
import static com.tarte.config.Config.loadPro;
import static com.tarte.config.Config.waitForSpinner;
import static com.tarte.config.Config.waitThread;
import static com.tarte.config.Config.setText;
import static com.tarte.config.Config.takeScreenShot;
import static com.tarte.config.Config.selectDropDown;
import static com.tarte.config.Config.selectDropDownInput;
import static com.tarte.config.Config.setCountry;
import static com.tarte.config.Config.getText;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import jxl.Sheet;

public class Registercheckout {
	WebDriver driver;
	Properties propregister;
	Sheet s;

	public void initializeXL() {
		propregister = loadPro("src\\test\\resources\\repository\\registercheckout.properties");
		s = loadExcel("INPUT\\inputregister.xls");
	}

	@BeforeTest
	public void Registercheckoutstaging() throws Exception {
		initializeXL();
		driver = getChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://staging.tartecosmetics.com");
		Robot r = new Robot();
		waitThread(1001);
		StringSelection ss = new StringSelection("storefront");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		waitThread(1001);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		waitThread(1001);
		ss = new StringSelection("tarte2017");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		waitThread(1001);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		waitThread(1001);
		waitForSpinner(driver);
		// waitThread(20001);
		// while
		// (!(driver.findElements(By.xpath("html/body/div[7]/div[3]/div/div/div/a")).size()>0))
		// {}
		/*
		 * if
		 * (driver.findElements(By.xpath("html/body/div[7]/div[3]/div/div/div/a")).size(
		 * ) > 0) { WebElement webElement =
		 * driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div/div/a"));
		 * Actions ac = new Actions(driver); ac.moveToElement(webElement);
		 * JavascriptExecutor executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].click();", webElement); }
		 */
	}

	@BeforeTest
	public void login() {
		String username = s.getCell(0, 2).getContents();
		String password = s.getCell(1, 2).getContents();
		click(propregister.getProperty("myaccountdd"), driver);
		click(propregister.getProperty("login1"), driver);
		setText(username, propregister.getProperty("username"), driver);
		setText(password, propregister.getProperty("password"), driver);
		click(propregister.getProperty("rememberme"), driver);
		click(propregister.getProperty("login"), driver);
	}

	@Test(priority = 1)
	public void Register_USA_Checkout_Sample_CartSpecial() {
		RegisterCheckout(2);
		throw new SkipException("Register_USA_Checkout_Sample_CartSpecial");
	}

	@Test(priority = 2)
	public void Register_CANADA_Checkout_Sample_CartSpecial() {
		RegisterCheckout(3);
		throw new SkipException("Register_CANADA_Checkout_Sample_CartSpecial");
	}

	@Test(priority = 3)
	public void Register_UNITEDKINGDOM_Checkout_Sample_CartSpecial() {
		RegisterCheckout(4);
		throw new SkipException("Register_UNITEDKINGDOM_Checkout_Sample_CartSpecial");
	}

	@Test(priority = 4)
	public void Register_GERMANY_Checkout_Sample_CartSpecial() {
		RegisterCheckout(5);
		throw new SkipException("Register_GERMANY_Checkout_Sample_CartSpecial");
	}

	@Test(priority = 5)
	public void Register_FRANCE_Checkout_Sample_CartSpecial() {
		RegisterCheckout(6);
		throw new SkipException("Register_FRANCE_Checkout_Sample_CartSpecial");
	}

	@Test(priority = 6)
	public void Register_AUSTRALIA_Checkout_Sample_CartSpecial() {
		RegisterCheckout(7);
		throw new SkipException("Register_AUSTRALIA_Checkout_Sample_CartSpecial");
	}

	@Test(priority = 7)
	public void Register_SAUDIARABIA_Checkout_Sample_CartSpecial() {
		RegisterCheckout(8);
		throw new SkipException("Register_SAUDIARABIA_Checkout_Sample_CartSpecial");
	}

	@Test(priority = 8)
	public void Register_UNITERARABEMIRATES_Checkout_Sample_CartSpecial() {
		RegisterCheckout(9);
		throw new SkipException("Register_UNITEDARABEMIRATES_Checkout_Sample_CartSpecial");
	}

	@Test(priority = 9)
	public void Register_MALAYSIA_Checkout_Sample_CartSpecial() {
		RegisterCheckout(10);
		throw new SkipException("Register_MALAYSIA_Checkout_Sample_CartSpecial");
	}

	@Test(priority = 10)
	public void Register_SINGAPORE_Checkout_Sample_CartSpecial() {
		RegisterCheckout(11);
		throw new SkipException("Register_SINGAPORE_Checkout_Sample_CartSpecial");
	}

	@Test(priority = 11)
	public void Register_KUWAIT_Checkout_Sample_CartSpecial() {
		RegisterCheckout(12);
		throw new SkipException("Register_KUWAIT_Checkout_Sample_CartSpecial");
	}

	public void login(int i) {
		initializeXL();
		String username = s.getCell(0, i).getContents();
		String password = s.getCell(1, i).getContents();
		click(propregister.getProperty("myaccountdd"), driver);
		click(propregister.getProperty("login1"), driver);
		setText(username, propregister.getProperty("username"), driver);
		setText(password, propregister.getProperty("password"), driver);
		click(propregister.getProperty("rememberme"), driver);
		click(propregister.getProperty("login"), driver);
	}

	public void RegisterCheckout(int i) {

		// int i = 0;
		String country = s.getCell(2, i).getContents();
		String promo = s.getCell(3, i).getContents();
		String email = s.getCell(4, i).getContents();
		String fname = s.getCell(5, i).getContents();
		String lname = s.getCell(6, i).getContents();
		String address = s.getCell(7, i).getContents();
		String zip = s.getCell(8, i).getContents();
		String city = s.getCell(9, i).getContents();
		String state = s.getCell(10, i).getContents();
		String phone = s.getCell(11, i).getContents();
		// String EGC_Redeem = s.getCell(12, i).getContents();
		String cardname = s.getCell(13, i).getContents();
		String cardno = s.getCell(14, i).getContents();
		String expmonth = s.getCell(15, i).getContents();
		String expyear = s.getCell(16, i).getContents();
		String cvv = s.getCell(17, i).getContents();
		clickJS(propregister.getProperty("countrydd"), driver);
		setText(country, propregister.getProperty("countryinput"), driver);
		setCountry(country, driver);
		click(propregister.getProperty("newarrivals"), driver);
		click(propregister.getProperty("itemquickview"), driver);
		click(propregister.getProperty("addtobag"), driver);
		click(propregister.getProperty("bag"), driver);
		waitThread(101);
		setText(promo, propregister.getProperty("enterpromo"), driver);
		click(propregister.getProperty("apply"), driver);
		click(propregister.getProperty("checkout"), driver);
		click(propregister.getProperty("guestcheckout"), driver);
		setText(email, propregister.getProperty("email"), driver);
		setText(fname, propregister.getProperty("firstname"), driver);
		setText(lname, propregister.getProperty("lastname"), driver);
		setText(address, propregister.getProperty("address"), driver);
		setText(zip, propregister.getProperty("zipcode"), driver);
		setText(city, propregister.getProperty("city"), driver);
		waitThread(2001);
		selectDropDownInput(propregister.getProperty("statedd"), propregister.getProperty("statein"), state, driver);
		setText(phone, propregister.getProperty("phone"), driver);
		waitThread(3001);
		click(propregister.getProperty("continue"), driver);
		setText(cardname, propregister.getProperty("cardname"), driver);
		setText(cardno, propregister.getProperty("cardno"), driver);
		selectDropDown(propregister.getProperty("expmonth"), expmonth, driver);
		selectDropDown(propregister.getProperty("expyear"), expyear, driver);
		setText(cvv, propregister.getProperty("cvv"), driver);
		click(propregister.getProperty("review"), driver);
		waitThread(2001);
		while (!(driver.findElements(By.xpath(propregister.getProperty("placeorder"))).size() > 0)) {
		}
		driver.findElement(By.xpath(propregister.getProperty("placeorder"))).sendKeys(Keys.DOWN);
		click(propregister.getProperty("placeorder"), driver);
		click(propregister.getProperty("close"), driver);
		waitThread(1001);
		takeScreenShot(country + ".png", "C:\\Users\\Unicode\\eclipse-workspace\\com.tartecosmetics\\screenshot\\pass",
				driver);
		String orderNumber = getText(propregister.getProperty("orderNo"), driver).replaceAll("\\D", "");
		System.out.println("Order number: " + orderNumber);
		waitThread(2000l);
		click(propregister.getProperty("tartelogo"), driver);
		waitThread(200l);

	}

	@AfterTest
	public void closetest() {
		driver.quit();
	}

}
