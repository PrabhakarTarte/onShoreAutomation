package RegisteredCheckoutScenarios;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.InvokedMethod;

import com.tarte.config.Config;
import com.tarte.listener.TestListener;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class})
public class RegisteredUser_USA extends Config{
	
	 
	WebDriver driver;
	
	{
		
	/*	
		System.out.println("STATIC  Registered user"+System.getProperty("user.dir")+"\\atu.properties");
		System.setProperty("atu.reporter.config",
    			System.getProperty("user.dir")+"\\atu.properties");
		*/
		
		
	}
	
	
	RunnerScripts rsc;
	@Test(dataProvider="localeData") 
	public void userCheckout_Promo_CreditCard(String LocaleNumber, String LocaleData) throws Exception {
		System.out.println("The Data provider vale - "+LocaleData);
		
		
		//driver= getNewDriver();
	//	ATUReports.setWebDriver(driver);
		rsc = new RunnerScripts();
		//rsc.LocaleName=LocaleData;
		rsc.logintoTarte(LocaleData);
		rsc.SelectItem();
		rsc.shoppingBagPage();
		rsc.shippingPageInfo();
		
		System.out.println("Iteration- "+LocaleNumber+ " ~~~~ "+"_Locale Name-"+ LocaleData);
		rsc.billingPageInfo();
		rsc.orderReviewPage();
		
	}
	
	
	
	
	
	@DataProvider(name="localeData")
	public Object[][] getLocaleData(){
		
		return new Object[][] {{"Locale-1","United Arab Emirates"},{"Locale-2","United Arab Emirates"},{"Locale-3","Germany"},{"Locale-4","Australia"},{"Locale-5","Kuwait"}};
	//	return new Object[][] {{"Locale-1","United Arab Emirates"}};
		//Germany
	}

}
