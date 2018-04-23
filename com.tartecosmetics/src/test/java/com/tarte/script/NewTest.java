package com.tarte.script;

import static com.tarte.config.Config.getChromeDriver;

import org.openqa.selenium.WebDriver;
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

public class NewTest {

	WebDriver driver;

	{
		System.out.println("1");
		driver = getChromeDriver();
		System.out.println("2" + driver);
		System.setProperty("atu.reporter.config","C:\\Users\\Unicode\\eclipse-workspace\\com.tartecosmetics\\lib\\atu.properties");
		System.out.println("3");
		ATUReports.setWebDriver(driver);
		System.out.println("4");
	}

	@Test
	public void f() {

		System.out.println("5");
		driver.get("https://www.facebook.com");
		System.out.println("6");
		driver.manage().window().maximize();
		System.out.println("7");
		if (true)
			ATUReports.add("test1", "input", "expected", "actual", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		ATUReports.add("", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
		System.out.println("8");
		System.out.println("Test Run Successfully");

	}
}
