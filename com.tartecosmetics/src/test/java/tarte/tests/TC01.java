package tarte.tests;

import java.awt.AWTException;
import java.sql.Driver;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.asserts.Assertion;
import org.testng.annotations.Test;

import com.tarte.config.Config;
import com.tarte.script.Logon;

import Base.Xls_Reader;
import BusinessTestRuns.RegisteredUserCheckoutScenario;
import Pages.AddToBag;
import Pages.CheckOutPage;
import Pages.LandingPage;
import Pages.OrderConfirmationPage;
import Pages.OrderReview;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import jxl.common.Assert;
import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })

public class TC01 extends Config {

	WebDriver driver =null;
	LandingPage landingPage;
	AddToBag addToBag;
	CheckOutPage checkOutPage;
	LaunchEnvironment launch;
	LoginCustomer logincustomer;
	ShippingDriver shippingDriver;
	BillingDriver billingdriver;
	OrderReview orderReview;
	OrderConfirmationPage confirmationPage;
	Xls_Reader reader;

	/*
	 * Data for the DataDriven
	 */
	String username = null;
	String password = null;
	String category = null;
	String FirstName = null;
	String LastName = null;
	String Address1 = null;
	String Address2 = null;
	String Zip = null;
	String City = null;
	String Country = null;
	String Phone = null;
	String NameOnCard = null;
	String CardType = null;
	String CardNumber = null;
	String Month = null;
	String Year = null;
	String CVV = null;
	String cartSpecial = null;
	

	{
		//driver = getDriver();
		System.out.println("STATIC TC01");

		System.setProperty("atu.reporter.config",
				"C:\\Users\\psharma\\Desktop\\QA\\eclipse-workspace\\com.tartecosmetics\\atu.properties");
		
		
	}
	
	@Test(priority=0)
	public void firstMeth() throws Exception, InterruptedException
	{
		System.out.println("Priority 0");
		
		System.out.println("Inside Before Method TCO1" );
		driver=getChromeDriver();
		ATUReports.setWebDriver(driver);
		 ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    	 ATUReports.indexPageDescription = "My Project Description <br/> <b>Can include Full set of HTML Tags</b>";
    	ATUReports.currentRunDescription="Run TCO01";
		 
    	 
    	
    	
		logincustomer = new LoginCustomer(driver);
		addToBag = new AddToBag(driver); 
		orderReview = new OrderReview(driver);
        landingPage = new LandingPage(driver);
		checkOutPage = new CheckOutPage(driver);
		shippingDriver = new ShippingDriver(driver);
		billingdriver = new BillingDriver(driver);

		
		confirmationPage = new OrderConfirmationPage(driver);

		
		reader = new Xls_Reader("C:\\Users\\psharma\\Desktop\\QA\\TestData.xlsx");
		username = reader.getCellData("TC1", "UserName", 2);
		password = reader.getCellData("TC1", "Password", 2);
		category = reader.getCellData("TC1", "Catagory", 2);
		FirstName = reader.getCellData("TC1", "FirstName", 2);
		LastName = reader.getCellData("TC1", "LastName", 2);
		Address1 = reader.getCellData("TC1", "Address1", 2);
		Address2 = reader.getCellData("TC1", "Address2", 2);
		Zip = reader.getCellData("TC1", "Zip", 2);
		City = reader.getCellData("TC1", "City", 2);
		Country = reader.getCellData("TC1", "Country", 2);
		Phone = reader.getCellData("TC1", "Phone", 2);
		NameOnCard = reader.getCellData("TC1", "NameOnCard", 2);
		CardType = reader.getCellData("TC1", "CardType", 2);
		CardNumber = reader.getCellData("TC1", "CardNumber", 2);
		Month = reader.getCellData("TC1", "Month", 2);
		Year = reader.getCellData("TC1", "Year", 2);
		CVV = reader.getCellData("TC1", "CVV", 2);
		cartSpecial = reader.getCellData("TC1", "CartSpecial", 2);

		System.out.println("User name is-" + username);
		System.out.println("password is-" + password);
  
	   
		
	}

	//}

	@Test(priority=1)
	public void launchURL() throws AWTException, InterruptedException {
		System.out.println("Inside 1");
		
	//	this.firstMeth();
		
		

		launch = new LaunchEnvironment(driver);
		launch.launchEnvionmentURL();

		waitThread(5000);

		logincustomer.navigateToLoginPage(username, password);

		     
	/*
	 * 
	 */
   
	
	
	
	}

	@Test(enabled = false)
	public void testAllLinks() {
		/*
		 * System.out.println("Inside TCO2 click link methnod");
		 * landingPage.click_Makeup().click_bestSellers().click_Sale().click_NewArrivals
		 * ();
		 */

		// driver.findElement(By.linkText("iPads")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'makeup')])[1]/following::a[contains(text(),'mascara')]"));

	}

	/*
	 * 
	 * Selects the product mascara - opening act lash primer
	 *
	 *
	 *
	 */

	@Test(priority=2)
	public void selectCatagory() throws InterruptedException {
  
	System.out.println("Inside 2");
		
		ATUReports.indexPageDescription="Registered User checkout for Top Locales";
		ATUReports.setAuthorInfo("Prabhakaar", "Automation", "Statging");
		
		Actions action = new Actions(driver);
		if (category.equalsIgnoreCase("makeup")) {
			action.moveToElement(LandingPage.getLink_Makeup()).build().perform();
			driver.findElement(By.xpath("(//a[contains(text(),'makeup')])[1]/following::a[contains(text(),'mascara')]"))
					.click();
			if ((reader.getCellData("TC1", "SubCategory", 2)).equalsIgnoreCase("Y")) {

				driver.findElement(By.xpath(reader.getCellData("TC1", "Product1", 2))).click(); // Product XPath from
																								// data sheet

			}

		} else {
			landingPage.click_bestSellers();
		}

		addToBag.clickaddToCart().clickViewBagCheckOut(); // Clicks Check Out button
		
		
		if (true)
			ATUReports.add("Registered User", "United States of America--Prabhakar", "Mascara selected -Prabhakar",
					"EGC Order Placed Successfull -Prabhakar", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	
		
		// scrolldown();
		// scrolldown();
		/*
		 * scrolldown(); scrolldown();
		 */

	}

	@Test(priority=3)
	public void checkOutPage1() throws InterruptedException {
		System.out.println("Inside 3");
		if (cartSpecial.equalsIgnoreCase("Y")) {
			checkOutPage.clickbtn_AddtoBagCartSpecial();
			
		}

		Thread.sleep(500);
		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(driver.findElement(By.
		 * xpath(".//*[contains(text(),'Cart Special:')]"))).build().perform();
		 * driver.findElement(By.xpath("//button[@id='add-to-cart']")).isEnabled();
		 * driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
		 */

		System.out.println("Clean till select POP up");
		Thread.sleep(2000);
		checkOutPage.click_first_SampleItem(); // Selects the sample Item
		Thread.sleep(1000);

		if (true)

			ATUReports.add("Registered User", "United States of America--Locale", "Checkout Item ",
					"User checks out sucessful", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		checkOutPage = new CheckOutPage(driver);

		String priceBeforeDiscount = CheckOutPage.getTxt_EstimatedTotal().getText();
		priceBeforeDiscount.length();
		String trimPrice = priceBeforeDiscount.substring(1, priceBeforeDiscount.length() - 1);
		// Integer estimatedToatalCostBeforePromo=Integer.parseInt(trimPrice);
		Float estimatedToatalCostBeforePromo = Float.parseFloat(trimPrice);
		trimPrice = null;

		System.out.println(trimPrice);

		CheckOutPage.getTxtBox_EnterPromoCode().sendKeys(reader.getCellData("TC1", "PromoCode", 2)); // Enters Promo
																										// Code
		Thread.sleep(2000);
		checkOutPage.click_btn_AddCoupon(); // Click on Add coupon button

		checkOutPage = new CheckOutPage(driver);
		String priceAfterDiscount = CheckOutPage.getTxt_EstimatedTotal().getText();
		priceBeforeDiscount.length();
		trimPrice = priceAfterDiscount.substring(1, priceAfterDiscount.length() - 1);
		Float estimatedToatalCostAfterPromo = Float.parseFloat(trimPrice);
		if (true)
			ATUReports.add("Registered User", "Price before Promo Code--" + estimatedToatalCostBeforePromo,
					"Add Coupon ", "User adds coupon sucessful - " + estimatedToatalCostAfterPromo, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		System.out.println("Integer is +++" + estimatedToatalCostAfterPromo);
		System.out.println(estimatedToatalCostBeforePromo + " " + estimatedToatalCostAfterPromo);

		// Assert.assertEquals();
		// org.testng.Assert.assertNotEquals((estimatedToatalCostBeforePromo),
		// (estimatedToatalCostAfterPromo));

		// org.testng.Assert.assertEquals(actual, expected);

		checkOutPage.click_btn_CheckOut();

		/*
		 * orderReview.click_placeOrder(); confirmationPage.getOrderNumber();
		 * System.out.println("The final generated Order Number" +
		 * confirmationPage.getOrderNumber()); ATUReports.add("Registered User3",
		 * "United States of America", "Confirmation Message-" +
		 * confirmationPage.getOrderNumber(), "Confirmation Page", LogAs.PASSED, new
		 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		 */

	}

	@Test(priority=4)
	public void shippingDetails() {
		System.out.println("Inside 4");
	//	shippingDriver.fillShippingInfo(FirstName, LastName, Address1, Address2, Zip, City, Country, Phone);

	}

	@Test(priority=5)
	public void billingPageDetails() throws InterruptedException {
		billingdriver.fillBillingPageDetails(NameOnCard, CardType, CardNumber, Month, Year, CVV);
		/*if (true)

			ATUReports.add("Registered User", "at billingPageDetails", "Checkout Item ", "Users shipping Details",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		checkOutPage = new CheckOutPage(driver);*/

	}

	@Test(priority=6)
	public void orderReviewPage() throws InterruptedException {
		System.out.println("Inside 6");
		Thread.sleep(2000);
		// Config.scrolldown();
		orderReview.click_placeOrder();
		confirmationPage.getOrderNumber();
		System.out.println("The final generated Order Number" + confirmationPage.getOrderNumber());
		ATUReports.add("Registered User3", "at orderReviewPage",
				"Confirmation Message-" + confirmationPage.getOrderNumber(), "Confirmation Page", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		
		ATUReports.add("Registered User", "Price before Promo Code--" ,
				"Add Coupon ", "SCREEN Capture", LogAs.PASSED,
				new CaptureScreen(OrderConfirmationPage.orderNumber));
		
		driver.close();
		

	}

}
