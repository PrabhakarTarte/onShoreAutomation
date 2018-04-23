package com.tarte.script;

import static com.tarte.config.Config.getNewDriver;
import static com.tarte.config.Config.loadPro;
import static com.tarte.config.Config.loadExcel;
import static com.tarte.config.Config.takeScreenShot;
import static com.tarte.config.Config.waitThread;
import static com.tarte.config.Config.click;
import static com.tarte.config.Config.clickJS;
import static com.tarte.config.Config.setCountry;
import static com.tarte.config.Config.setText;
import static com.tarte.config.Config.windowscroll;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import jxl.Sheet;

public class NewProductLaunch {
	WebDriver driver;
	Properties propnewitem;
	Sheet s;

	public void initializeXL() {
		propnewitem = loadPro("src\\test\\resources\\repository\\newproduct.properties");
		s = loadExcel("INPUT\\newproduct.xls");

	}

	@BeforeTest
	public void productionreview() {
		driver = getNewDriver();
		driver.manage().window().maximize();
		driver.get("http://tartecosmetics.com");

		waitThread(10001);
	
	}

	@Test
	public void newproducttest() throws Exception {
		initializeXL();
		for (int i = 1; i < s.getRows(); i++) {

			if (s.getRows() == 0) {
				break;
			}
			String country = s.getCell(0, i).getContents();
			waitThread(1001);
			clickJS(propnewitem.getProperty("countrydd"), driver);
			setText(country,propnewitem.getProperty("countryinput"), driver);
			setCountry(country, driver);
			for (int j = 1; j < s.getRows(); j++) {
				if (s.getRows() == 0) {
					break;
				}
				String Item = s.getCell(1, j).getContents();
				setText(Item, propnewitem.getProperty("search"), driver);
				waitThread(2001);
				click(propnewitem.getProperty("clicksearch"), driver);
				windowscroll();
				takeScreenShot(country+Item+".png", "C:\\Users\\Unicode\\eclipse-workspace\\com.tartecosmetics\\screenshot\\new Item", driver);
				
			}
		}
		}
	@AfterTest
	public void stop()
	{
		driver.close();
	}
}
