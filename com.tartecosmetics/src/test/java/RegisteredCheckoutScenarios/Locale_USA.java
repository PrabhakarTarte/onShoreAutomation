package RegisteredCheckoutScenarios;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
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

public class Locale_USA extends Config {
	
	
	 
	//private static final String LocaleData = null;
	//WebDriver driver;
	
	{
		
		
		/*System.out.println("STATIC  Registered user"+System.getProperty("user.dir")+"\\atu.properties");
		System.setProperty("atu.reporter.config",
   			System.getProperty("user.dir")+"\\atu.properties");*/
		
		
		
	}
	
	
	RunnerScripts rsc= new RunnerScripts();;
	//@Test( dataProvider="localeData")  String LocaleNumber, String LocaleData
	@Test (enabled=false)
	@Parameters({"DataSheetRow"})
	public void reg_Promo_CreditCard(String dataRow) throws Exception {
		 int row= Integer.parseInt(dataRow);
		rsc.suiteRunner("United States of America",row);
	}
	
	@Test
	public void EGCCheckout() throws Exception {
		rsc.EGCsuiteRunner(6);
		
	}
	
	
	
	
		
	/*@Test
	public void Australia_Promo_CreditCard() throws Exception {
		rsc.suiteRunner("Australia");
	}	
	
	
	@Test
	public void UAE_Promo_CreditCard() throws Exception {
		rsc.suiteRunner("United Arab Emirates");
	}	
	
	@Test
	public void germany_Promo_CreditCard() throws Exception {
		rsc.suiteRunner("Germany");
	}	
	
	
	@Test
	public void kuwait_Promo_CreditCard() throws Exception {
		rsc.suiteRunner("Kuwait");
	}	
	
	@Test
	public void france_Promo_CreditCard() throws Exception {
		rsc.suiteRunner("France");
	}	
	*/
	









	/*@DataProvider(name="localeData")
	public Object[][] getLocaleData(){
		
		return new Object[][] {{"Locale-1","Australia"},{"Locale-2","United Arab Emirates"},{"Locale-3","Germany"},{"Locale-4","United States of America"},{"Locale-5","Kuwait"}};
	//	return new Object[][] {{"Locale-1","United States of America"}};
		//Germany
	}*/
	

}
