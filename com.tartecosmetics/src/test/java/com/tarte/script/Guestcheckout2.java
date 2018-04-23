package com.tarte.script;

import static com.tarte.config.Config.click;
import static com.tarte.config.Config.clickJS;
import static com.tarte.config.Config.getChromeDriver;
import static com.tarte.config.Config.setCountry;
import static com.tarte.config.Config.loadExcel;
import static com.tarte.config.Config.loadPro;
import static com.tarte.config.Config.waitForSpinner;
import static com.tarte.config.Config.waitThread;
import static com.tarte.config.Config.setText;
import static com.tarte.config.Config.getText;
import static com.tarte.config.Config.selectDropDown;
import static com.tarte.config.Config.selectDropDownInput;
import static com.tarte.config.Config.takeScreenShot;
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
import org.testng.annotations.Test;

import org.testng.annotations.AfterTest;

import jxl.Sheet;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })

public class Guestcheckout2 {

	WebDriver driver;
	Properties propguestcheckout;

	Sheet s;
	{
		driver = getChromeDriver();
		/*System.setProperty("atu.reporter.config",
				"C:\\Users\\psharma\\Desktop\\QA\\eclipse-workspace\\com.tartecosmetics\\lib\\atu.properties");*/
		System.setProperty("atu.reporter.config",
    			System.getProperty("user.dir")+"\\atu.properties");
		
		ATUReports.setWebDriver(driver);
	}

	public void initializeXL() {
		propguestcheckout = loadPro("src\\test\\resources\\repository\\guestcheckout.properties");
		s = loadExcel("INPUT\\inputguest.xls");
	}

	@BeforeTest
	public void guestcheckoutstaging() throws Exception {
		initializeXL();
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
		if (driver.findElements(By.xpath("html/body/div[7]/div[3]/div/div/div/a")).size() > 0) {
			WebElement webElement = driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div/div/a"));
			Actions ac = new Actions(driver);
			ac.moveToElement(webElement);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", webElement);
		}
	}

	@Test(priority = 1)
	public void Guest_USA_Checkout_EGC() {
		EGC(2);
		if (true)
			ATUReports.add("Guest User EGC Checkout", "United States of America",
					"EGC Order Should be Placed Successfully", "EGC Order Placed Successfull", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	
	
	@Test(priority = 2)
	public void Guest_USA_Checkout_Sample_CartSpecial() {
		GuestCheckout(2);
		if (true)
			ATUReports.add("Guest User Multiple Line Item + Sample + Checkout Special Checkout",
					"United States of America", "Order Should be Placed Successfully", "Order Placed Successfull",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	@Test(priority = 3)
	public void Guest_CANADA_Checkout_Sample_CartSpecial() {
		GuestCheckout(3);
		if (true)
			ATUReports.add("Guest User Multiple Line Item + Sample + Checkout Special Checkout", "Canada",
					"Order Should be Placed Successfully", "Order Placed Successfull", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	@Test(priority = 4)
	public void Guest_UNITEDKINGDOM_Checkout_Sample_CartSpecial() {
		GuestCheckout(4);
		if (true)
			ATUReports.add("Guest User Multiple Line Item + Sample + Checkout Special Checkout", "United Kingdom",
					"Order Should be Placed Successfully", "Order Placed Successfull", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	@Test(priority = 5)
	public void Guest_GERMANY_Checkout_Sample_CartSpecial() {
		GuestCheckout(5);
		if (true)
			ATUReports.add("Guest User Multiple Line Item + Sample + Checkout Special Checkout", "Germany",
					"Order Should be Placed Successfully", "Order Placed Successfull", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

	}

	@Test(priority = 6)
	public void Guest_FRANCE_Checkout_Sample_CartSpecial() {
		GuestCheckout(6);
		if (true)
			ATUReports.add("Guest User Multiple Line Item + Sample + Checkout Special Checkout", "France",
					"Order Should be Placed Successfully", "Order Placed Successfull", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	@Test(priority = 7)
	public void Guest_AUSTRALIA_Checkout_Sample_CartSpecial() {
		GuestCheckout(7);
		if (true)
			ATUReports.add("Guest User Multiple Line Item + Sample + Checkout Special Checkout", "Australia",
					"Order Should be Placed Successfully", "Order Placed Successfull", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

	}

	@Test(priority = 8)
	public void Guest_SAUDIARABIA_Checkout_Sample_CartSpecial() {
		GuestCheckout(8);
		if (true)
			ATUReports.add("Guest User Multiple Line Item + Sample + Checkout Special Checkout", "Saudi Arabia",
					"Order Should be Placed Successfully", "Order Placed Successfull", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

	}

	@Test(priority = 9)
	public void Guest_UNITERARABEMIRATES_Checkout_Sample_CartSpecial() {
		GuestCheckout(9);
		if (true)
			ATUReports.add("Guest User Multiple Line Item + Sample + Checkout Special Checkout", "United Arab Emirates",
					"Order Should be Placed Successfully", "Order Placed Successfull", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

	}

	@Test(priority = 10)
	public void Guest_MALAYSIA_Checkout_Sample_CartSpecial() {
		GuestCheckout(10);
		if (true)
			ATUReports.add("Guest User Multiple Line Item + Sample + Checkout Special Checkout", "Malaysia",
					"Order Should be Placed Successfully", "Order Placed Successfull", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	@Test(priority = 11)
	public void Guest_SINGAPORE_Checkout_Sample_CartSpecial() {
		GuestCheckout(11);
		if (true)
			ATUReports.add("Guest User Multiple Line Item + Sample + Checkout Special Checkout", "Singapore",
					"Order Should be Placed Successfully", "Order Placed Successfull", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	@Test(priority = 12)
	public void Guest_KUWAIT_Checkout_Sample_CartSpecial() {
		GuestCheckout(12);
		if (true)
			ATUReports.add("Guest User Multiple Line Item + Sample + Checkout Special Checkout", "Kuwait",
					"Order Should be Placed Successfully", "Order Placed Successfull", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	public void GuestCheckout(int i) {
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
		clickJS(propguestcheckout.getProperty("countrydd"), driver);
		setText(country, propguestcheckout.getProperty("countryinput"), driver);
		setCountry(country, driver);
		click(propguestcheckout.getProperty("newarrivals"), driver);
		click(propguestcheckout.getProperty("itemquickview"), driver);
		click(propguestcheckout.getProperty("addtobag"), driver);
		click(propguestcheckout.getProperty("bag"), driver);
		waitThread(101);
		setText(promo, propguestcheckout.getProperty("enterpromo"), driver);
		click(propguestcheckout.getProperty("apply"), driver);
		click(propguestcheckout.getProperty("checkout"), driver);
		click(propguestcheckout.getProperty("guestcheckout"), driver);
		setText(email, propguestcheckout.getProperty("email"), driver);
		setText(fname, propguestcheckout.getProperty("firstname"), driver);
		setText(lname, propguestcheckout.getProperty("lastname"), driver);
		setText(address, propguestcheckout.getProperty("address"), driver);
		setText(zip, propguestcheckout.getProperty("zipcode"), driver);
		setText(city, propguestcheckout.getProperty("city"), driver);
		waitThread(2001);
		selectDropDownInput(propguestcheckout.getProperty("statedd"), propguestcheckout.getProperty("statein"), state,
				driver);
		setText(phone, propguestcheckout.getProperty("phone"), driver);
		waitThread(3001);
		click(propguestcheckout.getProperty("continue"), driver);
		setText(cardname, propguestcheckout.getProperty("cardname"), driver);
		setText(cardno, propguestcheckout.getProperty("cardno"), driver);
		selectDropDown(propguestcheckout.getProperty("expmonth"), expmonth, driver);
		selectDropDown(propguestcheckout.getProperty("expyear"), expyear, driver);
		setText(cvv, propguestcheckout.getProperty("cvv"), driver);
		click(propguestcheckout.getProperty("review"), driver);
		waitThread(2001);
		while (!(driver.findElements(By.xpath(propguestcheckout.getProperty("placeorder"))).size() > 0)) {
		}
		driver.findElement(By.xpath(propguestcheckout.getProperty("placeorder"))).sendKeys(Keys.DOWN);
		click(propguestcheckout.getProperty("placeorder"), driver);
		click(propguestcheckout.getProperty("close"), driver);
		waitThread(1001);
		takeScreenShot(country + ".png", "C:\\Users\\Unicode\\eclipse-workspace\\com.tartecosmetics\\screenshot\\pass",
				driver);
		String orderNumber = getText(propguestcheckout.getProperty("orderNo"), driver).replaceAll("\\D", "");
		System.out.println("Order number: " + orderNumber);

		ATUReports.add("Order number", "Input", orderNumber, "Actual", LogAs.INFO,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		waitThread(2000l);
		click(propguestcheckout.getProperty("tartelogo"), driver);
		waitThread(200l);

	}

	public void EGC(int i) {
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
		clickJS(propguestcheckout.getProperty("countrydd"), driver);
		setText(country, propguestcheckout.getProperty("countryinput"), driver);
		setCountry(country, driver);
		click(propguestcheckout.getProperty("egc"), driver);
		setText("Mohammad Zaki", propguestcheckout.getProperty("egcyourname"), driver);
		setText("Anurag Singh", propguestcheckout.getProperty("egcfriendname"), driver);
		setText("tarteqa@gmail.com", propguestcheckout.getProperty("egcfriendemail"), driver);
		setText("tarteqa@gmail.com", propguestcheckout.getProperty("egcconfirmemail"), driver);
		setText("100", propguestcheckout.getProperty("egcamount"), driver);
		click(propguestcheckout.getProperty("egcsubmit"), driver);
		click(propguestcheckout.getProperty("bag"), driver);
		waitThread(101);
		setText(promo, propguestcheckout.getProperty("enterpromo"), driver);
		click(propguestcheckout.getProperty("apply"), driver);
		click(propguestcheckout.getProperty("checkout"), driver);
		click(propguestcheckout.getProperty("guestcheckout"), driver);
		setText(fname, propguestcheckout.getProperty("fname"), driver);
		setText(lname, propguestcheckout.getProperty("lname"), driver);
		setText(address, propguestcheckout.getProperty("add"), driver);
		setText(zip, propguestcheckout.getProperty("zip"), driver);
		setText(city, propguestcheckout.getProperty("bcity"), driver);
		waitThread(2001);
		selectDropDownInput(propguestcheckout.getProperty("bstate"), propguestcheckout.getProperty("statein"), state,
				driver);
		setText(phone, propguestcheckout.getProperty("bphone"), driver);
		waitThread(3001);
		setText(email, propguestcheckout.getProperty("egcemail"), driver);
		setText(cardname, propguestcheckout.getProperty("cardname"), driver);
		setText(cardno, propguestcheckout.getProperty("cardno"), driver);
		selectDropDown(propguestcheckout.getProperty("expmonth"), expmonth, driver);
		selectDropDown(propguestcheckout.getProperty("expyear"), expyear, driver);
		setText(cvv, propguestcheckout.getProperty("cvv"), driver);
		click(propguestcheckout.getProperty("review"), driver);
		waitThread(2001);
		while (!(driver.findElements(By.xpath(propguestcheckout.getProperty("placeorder"))).size() > 0)) {
		}
		driver.findElement(By.xpath(propguestcheckout.getProperty("placeorder"))).sendKeys(Keys.DOWN);
		click(propguestcheckout.getProperty("placeorder"), driver);
		click(propguestcheckout.getProperty("close"), driver);
		waitThread(1001);
		takeScreenShot(country + ".png", "C:\\Users\\Unicode\\eclipse-workspace\\com.tartecosmetics\\screenshot\\pass",
				driver);
		String orderNumber = getText(propguestcheckout.getProperty("orderNo"), driver).replaceAll("\\D", "");
		System.out.println("Order number: " + orderNumber);
		ATUReports.add("Order number", "Input", orderNumber, "Actual", LogAs.INFO,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		waitThread(2000l);
		click(propguestcheckout.getProperty("tartelogo"), driver);
		waitThread(200l);

	}

	@AfterTest
	public void closetest() {
		driver.quit();
	}
}
