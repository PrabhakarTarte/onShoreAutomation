package com.tarte.script;

import static com.tarte.config.Config.click;
import static com.tarte.config.Config.getChromeDriver;
import static com.tarte.config.Config.loadExcel;
import static com.tarte.config.Config.loadPro;
import static com.tarte.config.Config.waitForSpinner;
import static com.tarte.config.Config.waitThread;
import static com.tarte.config.Config.setText;
import static com.tarte.config.Config.selectDropDown;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Sheet;

public class Order {
	
	WebDriver driver;
	Properties propOrderUS;
	Sheet s;

    @BeforeTest
	public void guestcheckout() {
		propOrderUS = loadPro("src\\test\\resources\\repository\\OrderUS.properties");
		driver = getChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tartecosmetics.com");
		s = loadExcel("INPUT\\checkout.xls");
		waitForSpinner(driver);
		waitThread(2000l);
	}

	
	@Test
	public void uscheckout() {
		
		
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
		setText(cvv, propOrderUS.getProperty("cvv"), driver);

		click(propOrderUS.getProperty("review"), driver);
		click(propOrderUS.getProperty("placeorder"), driver);
		
		
		

	}
}
