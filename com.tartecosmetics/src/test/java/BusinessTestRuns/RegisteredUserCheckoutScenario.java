package BusinessTestRuns;


import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tarte.config.Config;
import com.tarte.listener.TestListener;

import Base.Xls_Reader;
import Pages.AddToBag;
import Pages.BillingPage;
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
import tarte.tests.BillingDriver;
import tarte.tests.LaunchEnvironment;
import tarte.tests.LoginCustomer;
import tarte.tests.ShippingDriver;


@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class})

public class RegisteredUserCheckoutScenario extends Config  {

    WebDriver driver= null;
	LandingPage landingPage;
	AddToBag addToBag;
	CheckOutPage checkOutPage;
	LaunchEnvironment launch;
	LoginCustomer logincustomer;
	
	ShippingDriver shippingDriver;
	BillingDriver billingdriver;
	BillingPage billingPage;
	OrderReview orderReview;
	OrderConfirmationPage confirmationPage;
	Xls_Reader reader;
	static Logger Log = Logger.getLogger(org.testng.log4testng.Logger.class.getName());
	/*
	 * Data for the DataDriven
	 */
	int testRow=2;  // 
	String username = null;
	String password = null;
	String tier=null;
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
	String LocaleName = null;
	
	String subcatagory= null;
	String multipleLine=null;
	String category2 = null;
	String category3 = null;
	String flagSubcatagory=null;
	String increaseQuantity=null;
	String flagShadeName=null;
	
	
	{
		
		
		System.out.println("STATIC  Registered user"+System.getProperty("user.dir")+"\\atu.properties");
		System.setProperty("atu.reporter.config",
    			System.getProperty("user.dir")+"\\atu.properties");
		
		
		
	}
	
	public void readLocaleAddress() {
		Address1 = reader.getCellData("Address", LocaleName, 2);
		Address2 = reader.getCellData("Address", LocaleName, 3);
		Zip = reader.getCellData("Address", LocaleName, 4);
		City = reader.getCellData("Address", LocaleName, 5);
		Country = reader.getCellData("Address", LocaleName, 6);
		Phone = reader.getCellData("Address", LocaleName, 7);
		
	}
	
   @BeforeMethod	
		   public void firstMeth() {
	    	//driver=getChromeDriver();
	    	
	    	System.out.println("Inside Before Method Registered user checkout" );
	    	
	        	ATUReports.setWebDriver(driver);
	    	 ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
	    	 ATUReports.indexPageDescription = "My Project Description <br/> <b>Can include Full set of HTML Tags</b>";
	    	 ATUReports.currentRunDescription="Run for registered user check out";
	    	
	   //reader = new Xls_Reader("C:\\Users\\psharma\\Desktop\\QA\\TestData.xlsx"); 	
	   
	    	
		reader = new Xls_Reader(".\\INPUT\\TestData.xlsx");
		LocaleName=reader.getCellData("TC1", "Locale", testRow);
		username = reader.getCellData("TC1", "UserName", testRow);
		password = reader.getCellData("TC1", "Password", testRow);
		category = reader.getCellData("TC1", "Catagory", testRow);
		subcatagory=reader.getCellData("TC1", "SubcatagoryName", testRow);
		FirstName = reader.getCellData("TC1", "FirstName", testRow);
		LastName = reader.getCellData("TC1", "LastName", testRow);
		
		
		
		NameOnCard = reader.getCellData("TC1", "NameOnCard", testRow);
		CardType = reader.getCellData("TC1", "CardType", testRow);
		CardNumber = reader.getCellData("TC1", "CardNumber", testRow);
		Month = reader.getCellData("TC1", "Month", testRow);
		Year = reader.getCellData("TC1", "Year", testRow);
		CVV = reader.getCellData("TC1", "CVV", testRow);
		cartSpecial = reader.getCellData("TC1", "CartSpecial", testRow);
		tier=reader.getCellData("TC1", "CustomerType", testRow);
		multipleLine=reader.getCellData("TC1", "MultipleLine", testRow);
		category2 = reader.getCellData("TC1", "Catagory2", testRow);
		category3 = reader.getCellData("TC1", "Catagory3", testRow);
		flagSubcatagory=reader.getCellData("TC1", "SubCatagory", testRow);
		increaseQuantity=reader.getCellData("TC1", "IncreaseQuantity", testRow);;
		flagShadeName=reader.getCellData("TC1", "SelectShade", testRow);

		System.out.println("User name is-" + username);
		System.out.println("password is-" + password);
		System.out.println("Test data row-" + testRow);
		
		
		
		}
	

	@Test( dataProvider="localeData")  // String LocaleNumber, String LocaleData
//@Test
	public void registerdCustomerCheckOut(String LocaleNumber, String LocaleData) throws Throwable {
		
        LocaleName=LocaleData;
        driver=getChromeDriver();
        ATUReports.setWebDriver(driver);
       
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    	 ATUReports.indexPageDescription = "My Project Description <br/> <b>Can include Full set of HTML Tags</b>";
      	ATUReports.currentRunDescription="Run for registered user check out";
        
        
        
//		if(driver==null) {
//			driver=getChromeDriver();
//		}
		
		launch = new LaunchEnvironment(driver);
		landingPage = new LandingPage(driver);
		launch.launchEnvionmentURL();

		//waitThread(2000);
		
		 System.out.println(LocaleNumber+" ~~~ "+LocaleName);
	 	//landingPage.click_HomePageLogo();
		
	//	Log.info("Clicked Home Pagestorefront");
	  
		landingPage.click_shipT0_URL();
		landingPage.selectCountry(LocaleName);
		logincustomer = new LoginCustomer(driver);
        billingPage= new BillingPage(driver);
		logincustomer.navigateToLoginPage(username, password);
        
		
		
		
		addToBag = new AddToBag(driver);

		checkOutPage = new CheckOutPage(driver);
		shippingDriver = new ShippingDriver(driver);
		billingdriver = new BillingDriver(driver);

		orderReview = new OrderReview(driver);
		confirmationPage = new OrderConfirmationPage(driver);
		checkOutPage = new CheckOutPage(driver);
	
   

		ATUReports.indexPageDescription="Registered User checkout for Top Locales";
		ATUReports.setAuthorInfo("Prabhakaar", "Automation", "Statging");
		
		
		Actions action = new Actions(driver);
		if (category.equalsIgnoreCase("makeup")) {
			action.moveToElement(LandingPage.getLink_Makeup()).build().perform();
			
			if ((reader.getCellData("TC1", "SubCategory",testRow )).equalsIgnoreCase("Y")) {
				
				String xpathSubCatagory ="(.//a[contains(text(),'makeup')])[1]//following::a[contains(text(),"+"'" +subcatagory+"'"+")]";
				System.out.println("xpathSubCatagory--"+ xpathSubCatagory);
				driver.findElement(By.xpath(xpathSubCatagory)).click();
				
				scrolldownUntilVisisble(driver.findElement(By.xpath(reader.getCellData("TC1", "Product1", testRow))));

				driver.findElement(By.xpath(reader.getCellData("TC1", "Product1", testRow))).click(); // Product XPath from
				//System.out.println(driver.findElement(By.xpath(reader.getCellData("TC1", "Product1", testRow))).getText());																				// data sheet

			}

		} else {
			landingPage.click_bestSellers();
			driver.findElement(By.xpath(reader.getCellData("TC1", "Product1", testRow))).click();
		}

		
		
		addToBag.clickaddToCart();
		
		/*
		 * Below code checks for multiple line items and calls the method selectAnotherLineItem
		 */
		
		if(multipleLine.equalsIgnoreCase("1")) {                                                     
			this.selectAnotherLineItem(category2,"Product2","light-medium");
			
		}
		if(multipleLine.equalsIgnoreCase("2")) {
			this.selectAnotherLineItem(category2,"Product2","light-medium");
			this.selectAnotherLineItem(category3,"Product3","tan sand");
			
		}
		
		
		addToBag.clickViewBagCheckOut(); // Clicks Check Out button
		
		
		
      
		
		if (cartSpecial.equalsIgnoreCase("Y")) {
			checkOutPage.clickbtn_AddtoBagCartSpecial();
			
		}

		Thread.sleep(500);
		
		System.out.println("Clean till select POP up");
		Thread.sleep(2000);
		checkOutPage.click_first_SampleItem(); // Selects the sample Item
		Thread.sleep(1000);

		
		
		
		checkOutPage = new CheckOutPage(driver);

		String priceBeforeDiscount = CheckOutPage.getTxt_EstimatedTotal().getText();
		priceBeforeDiscount.length();
		
		String trimPrice = priceBeforeDiscount.substring(1, priceBeforeDiscount.length() - 1);
		int a=priceBeforeDiscount.indexOf(".");
		int b=priceBeforeDiscount.indexOf(" ");
		System.out.println("a and B "+a+" -"+b);
	//	String paseString=priceBeforeDiscount.substring(b, a);
		
		// Integer estimatedToatalCostBeforePromo=Integer.parseInt(trimPrice);
	//	Float estimatedToatalCostBeforePromo = Float.parseFloat(trimPrice);
	//	Float estimatedToatalCostBeforePromo = Float.parseFloat(paseString);
		trimPrice = null;

		System.out.println(trimPrice);
		
        if(reader.getCellData("TC1", "PC", testRow).equalsIgnoreCase("Y")) {
		CheckOutPage.getTxtBox_EnterPromoCode().sendKeys(reader.getCellData("TC1", "PromoCode", testRow)); // Enters Promo // Code
		Thread.sleep(2000);
		checkOutPage.click_btn_AddCoupon(); // Click on Add coupon button

        	
        
		
		
		String priceAfterDiscount = CheckOutPage.getTxt_EstimatedTotal().getText();
		priceBeforeDiscount.length();
		trimPrice = priceAfterDiscount.substring(1, priceAfterDiscount.length() - 1);
		a=priceAfterDiscount.indexOf(".");
		b=priceAfterDiscount.indexOf(" ");
		System.out.println("a and B "+a+" -"+b);
//		paseString=null;
//		paseString=priceAfterDiscount.substring(b, a);
		//Float estimatedToatalCostAfterPromo = Float.parseFloat(trimPrice);
//		Float estimatedToatalCostAfterPromo = Float.parseFloat(paseString);
/*		if (true)
			ATUReports.add("Registered User", "Price before Promo Code--" + estimatedToatalCostBeforePromo,
					"Add Coupon ", "User adds coupon sucessful - " + estimatedToatalCostAfterPromo, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		System.out.println("Integer is ++ estimatedToatalCostAfterPromo " + estimatedToatalCostAfterPromo);
		System.out.println(estimatedToatalCostBeforePromo + " ~ " + estimatedToatalCostAfterPromo);
*/
		
		// org.testng.Assert.assertNotEquals((estimatedToatalCostBeforePromo),
		ATUReports.add("Registered User", "Price before Promo Code--" ,
				"Add Coupon ", "User adds coupon sucessful - " , LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
        }

		checkOutPage.click_btn_CheckOut();

         this.readLocaleAddress();
		shippingDriver.fillShippingInfo(FirstName, LastName, Address1, Address2, Zip, City, Country, Phone);
		
		
		if(tier.equalsIgnoreCase("Tier3")) {
			float tier3Shipping=(float) 0.00;
		    
			System.out.println("Billing and Handling Cost  -"+tier+"  "+billingPage.get_ShippingandHanding());
			assertEquals(tier3Shipping, billingPage.get_ShippingandHanding());
			
		}
		
		billingdriver.fillBillingPageDetails(NameOnCard, CardType, CardNumber, Month, Year, CVV);
	
	
		Thread.sleep(4000);
	  //  Config.scrolldown();
		if(!LaunchEnvironment.environmentName.equalsIgnoreCase("production")) {
			System.out.println("ennv name "+LaunchEnvironment.environmentName);
		orderReview.click_placeOrder();
		Thread.sleep(2000);
		confirmationPage.getOrderNumber();
		
		System.out.println("The final generated Order Number- " + confirmationPage.getOrderNumber());
		}
		ATUReports.add("Registered User3", "at orderReviewPage",
				"Confirmation Message-" + confirmationPage.getOrderNumber(), "Confirmation Page", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		
		
	//	 * orderReviewPage
		 
		
	/*	ATUReports.add("Registered User", "Price before Promo Code--" ,
				"Add Coupon ", "SCREEN Capture", LogAs.PASSED,
				new CaptureScreen(OrderConfirmationPage.orderNumber));*/
		//this.finalize();
		TearDown();		
     	
	
   }
	
	
	
	
	
   
	
   
   
   public void selectAnotherLineItem(String txt,String Product, String shade) throws InterruptedException {
	   Thread.sleep(500);
	   landingPage = new LandingPage(driver); 
	   addToBag = new AddToBag(driver);
    	checkOutPage = new CheckOutPage(driver);
	   	   
	   flagSubcatagory="N";
	  		System.out.println("Inside selectAnotherLineItem");
			landingPage.click_bestSellers();
			//driver.findElement(By.xpath(reader.getCellData("TC1", "Product2", testRow))).click();
			driver.findElement(By.xpath(reader.getCellData("TC1", Product, testRow))).click();
			this.selectShade(shade);
		  this.addQuantity(6);
		 addToBag.clickaddToCart();
		 flagSubcatagory="Y";
	   
   }
   
   public void addQuantity(int count) throws InterruptedException {
	   if(!increaseQuantity.equalsIgnoreCase("N")) {
	   for(int i=0;i<=count;i++) {
		   Thread.sleep(300);
	   driver.findElement(By.xpath(".//span[@class='quantity-button increase']")).click();;
	   }
	   }
   }
   
   public void selectShade(String shadeName) {
	   
	   if(!flagShadeName.equalsIgnoreCase("N")) {
	   String tmp=".//a[@data-value='"+shadeName+"']";
	   driver.findElement(By.xpath(tmp)).click();
	   
   }}
   
   
 
	
	
	@DataProvider(name="localeData")
	public Object[][] getLocaleData(){
		
//		return new Object[][] {{"Locale-1","United States of America"},{"Locale-2","United Arab Emirates"},{"Locale-3","Germany"},{"Locale-4","Australia"},{"Locale-5","Kuwait"}};
		return new Object[][] {{"Locale-1","United States of America"}};
		//Germany
	}
	
	


	

	


	

}
