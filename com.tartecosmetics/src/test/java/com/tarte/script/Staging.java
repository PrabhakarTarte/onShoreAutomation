package com.tarte.script;

import static com.tarte.config.Config.click;
import static com.tarte.config.Config.getNewDriver;
import static com.tarte.config.Config.loadExcel;
import static com.tarte.config.Config.loadPro;
import static com.tarte.config.Config.waitForSpinner;
import static com.tarte.config.Config.waitThread;
import static com.tarte.config.Config.setText;
import static com.tarte.config.Config.selectDropDown;
import static com.tarte.config.Config.getText;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import jxl.Sheet;

public class Staging {

	WebDriver driver;
	Properties propOrderUS;
	Sheet s;

	@BeforeTest
	public void guestcheckout() throws Exception {
		driver = getNewDriver();
		driver.manage().window().maximize();
		propOrderUS = loadPro("src\\test\\resources\\repository\\OrderUS.properties");
		s = loadExcel("INPUT\\checkout.xls");
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

		waitForSpinner(driver);
		waitThread(2001);
	}

	@Test
	public void usacheckout() {
		String promo = s.getCell(0, 1).getContents();
		String email = s.getCell(1, 1).getContents();
		String fname = s.getCell(2, 1).getContents();
		String lname = s.getCell(3, 1).getContents();
		String address = s.getCell(4, 1).getContents();
		String zip = s.getCell(5, 1).getContents();
		String city = s.getCell(6, 1).getContents();
		String phone = s.getCell(8, 1).getContents();
		String cardname = s.getCell(9, 1).getContents();
		String cardno = s.getCell(10, 1).getContents();
		String cvv = s.getCell(11, 1).getContents();

		click(propOrderUS.getProperty("countrydd"), driver);
		click(propOrderUS.getProperty("usdd"), driver);
		click(propOrderUS.getProperty("newarrivals"), driver);
		click(propOrderUS.getProperty("itemquickview"), driver);
		click(propOrderUS.getProperty("addtobag"), driver);
		click(propOrderUS.getProperty("bag"), driver);
		waitThread(2);

		setText(promo, propOrderUS.getProperty("enterpromo"), driver);

		click(propOrderUS.getProperty("apply"), driver);
		click(propOrderUS.getProperty("checkout"), driver);
		click(propOrderUS.getProperty("guestcheckout"), driver);

		setText(email, propOrderUS.getProperty("email"), driver);
		setText(fname, propOrderUS.getProperty("firstname"), driver);
		setText(lname, propOrderUS.getProperty("lastname"), driver);
		setText(address, propOrderUS.getProperty("address"), driver);
		setText(zip, propOrderUS.getProperty("zipcode"), driver);
		setText(city, propOrderUS.getProperty("city"), driver);
		selectDropDown(propOrderUS.getProperty("state"), "New York", driver);

		setText(phone, propOrderUS.getProperty("phone"), driver);
		click(propOrderUS.getProperty("continue"), driver);
		setText(cardname, propOrderUS.getProperty("cardname"), driver);
		setText(cardno, propOrderUS.getProperty("cardno"), driver);

		selectDropDown(propOrderUS.getProperty("expyear"), "2018", driver);

		setText(cvv, propOrderUS.getProperty("cvv"), driver);

		click(propOrderUS.getProperty("review"), driver);

		while (!(driver.findElements(By.xpath(propOrderUS.getProperty("placeorder"))).size() > 0)) {
		}

		driver.findElement(By.xpath(propOrderUS.getProperty("placeorder"))).sendKeys(Keys.DOWN);

		click(propOrderUS.getProperty("placeorder"), driver);

	}

	@AfterTest
	public void test() {
		waitThread(2000l);
		click(propOrderUS.getProperty("close"), driver);
		waitThread(500l);

		String orderNumber = getText(propOrderUS.getProperty("orderNo"), driver).replaceAll("\\D", "");

		System.out.println("Order number: " + orderNumber);

	}
}
