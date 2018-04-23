package com.tarte.script;

import static com.tarte.config.Config.clickJS;
import static com.tarte.config.Config.getNewDriver;
import static com.tarte.config.Config.loadExcel;
import static com.tarte.config.Config.loadPro;
import static com.tarte.config.Config.setCountry;
import static com.tarte.config.Config.setText;
import static com.tarte.config.Config.takeScreenShot;
import static com.tarte.config.Config.waitForSpinner;
import static com.tarte.config.Config.waitThread;
import static com.tarte.config.Config.setmousehover;
import static com.tarte.config.Config.windowscroll;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import jxl.Sheet;

public class ProductionReviewCheckout {
	WebDriver driver;
	Properties propproductionreview;
	Sheet s;

	public void initializeXL() {
		propproductionreview = loadPro("src\\test\\resources\\repository\\productionreview.properties");
		s = loadExcel("INPUT\\endtoend_production.xls");

	}

	@BeforeTest
	public void productionreview() {
		driver = getNewDriver();
		driver.manage().window().maximize();
		driver.get("http://tartecosmetics.com");

		waitThread(1001);

		waitForSpinner(driver);

	}

	
	public void productioncheckout() throws Exception {

		initializeXL();

		for (int i = 15; i < s.getRows(); i++) {
			
			if (s.getRows() == 0) {
				break;
			}

			String country = s.getCell(0, i).getContents();
			waitThread(1001);

			clickJS(propproductionreview.getProperty("countrydd"), driver);
			setText(country, propproductionreview.getProperty("countryinput"), driver);
			setCountry(country, driver);
			setmousehover("MAKEUP", "Eyeliner", driver);
			windowscroll();
			windowscroll();
			takeScreenShot(country + ".png",
					"C:\\Users\\Unicode\\eclipse-workspace\\com.tartecosmetics\\screenshot\\pass", driver);

			test();
		}
	}

	private void test() {
		waitThread(2001);

	}

	@AfterTest
	public void stop() {
		driver.close();
	}
}
