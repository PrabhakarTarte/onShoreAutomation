package tarte.tests;

import java.awt.AWTException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tarte.config.Config;
import com.tarte.script.Guestcheckout2;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;



@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class RegisteredCustomerTier1 extends Config{
	
	WebDriver driver=getChromeDriver();;
	@Test(priority = 1)
	public void test1() {
	 

		System.setProperty("atu.reporter.config",
				"C:\\Users\\psharma\\Desktop\\QA\\eclipse-workspace\\com.tartecosmetics\\atu.properties");
		ATUReports.setWebDriver(driver);
		ATUReports.add("Registered User Tier 1", "USA", "Mascara ",
				"Runwith", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		
		
		
		}	
	/*@Test(priority = 2)
	public void test2() {
		

		
		ATUReports.add("Registered User Tier 1", "Method 2", "Mascara ",
				"Runwith", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		}	
	
	@Test(priority = 3)
	public void test3() throws AWTException, InterruptedException{
		
		
		System.out.println("Hellow Registered customwr 1");
		driver.close();
		
		TC01 tc= new TC01();
		tc.launchURL();
		
		}	
	*/

}
