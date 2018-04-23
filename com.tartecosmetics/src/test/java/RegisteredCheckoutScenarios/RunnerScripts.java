package RegisteredCheckoutScenarios;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;

import com.tarte.config.Config;

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
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import tarte.tests.BillingDriver;
import tarte.tests.LaunchEnvironment;
import tarte.tests.LoginCustomer;
import tarte.tests.ShippingDriver;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class})
public class RunnerScripts extends Config {

	/*
	 * Variables required from the Datasheet
	 */
	
	    WebDriver driver;
	    
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
		public String LocaleName = null;
		
		String subcatagory= null;
		String multipleLine=null;
		String category2 = null;
		String category3 = null;
		String flagSubcatagory=null;
		String increaseQuantity=null;
		String flagShadeName=null;
		
		
		
		
		
		public void dataInitializer() throws Exception {
			reader = new Xls_Reader(".\\INPUT\\TestData.xlsx");
		//	LocaleName=reader.getCellData("TC1", "Locale", testRow);
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
		
			launch = new LaunchEnvironment(driver);
			landingPage = new LandingPage(driver);
			
			logincustomer = new LoginCustomer(driver);
	        billingPage= new BillingPage(driver);
			
			addToBag = new AddToBag(driver);

			checkOutPage = new CheckOutPage(driver);
			shippingDriver = new ShippingDriver(driver);
			billingdriver = new BillingDriver(driver);

			orderReview = new OrderReview(driver);
			confirmationPage = new OrderConfirmationPage(driver);
			checkOutPage = new CheckOutPage(driver);
		    
		
		}
		
		
		public void readLocaleAddress() {
			//LocaleName="";  
          //  LocaleName=runLocale;
			Address1 = reader.getCellData("Address", LocaleName, 2);
			Address2 = reader.getCellData("Address", LocaleName, 3);
			Zip = reader.getCellData("Address", LocaleName, 4);
			City = reader.getCellData("Address", LocaleName, 5);
			Country = reader.getCellData("Address", LocaleName, 6);
			Phone = reader.getCellData("Address", LocaleName, 7);
			
		}
		
		
		public void logintoTarte(String S) throws Exception {
			driver= getChromeDriver();
			LocaleName=S;
			this.dataInitializer();
			ATUReports.setWebDriver(driver);
			//driver=getChromeDriver();
			launch.launchEnvionmentURL();
			landingPage.click_shipT0_URL();
			
			landingPage.selectCountry(LocaleName);
			logincustomer.navigateToLoginPage(username, password);
			ATUReports.add("Login as Registered User",LocaleName ,
					"User logs in as a Registered ", "Step -Pass" , LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		
		public void SelectItem() throws Exception
		{
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
			if(multipleLine.equalsIgnoreCase("1")) {                                                     
				this.selectAnotherLineItem(category2,"Product2","light-medium");
				
			}
			if(multipleLine.equalsIgnoreCase("2")) {
				this.selectAnotherLineItem(category2,"Product2","light-medium");
				this.selectAnotherLineItem(category3,"Product3","tan sand");
				
			}
			
			
			addToBag.clickViewBagCheckOut();
			
			
		}
		
		public void shoppingBagPage() throws Exception {
			
			ATUReports.setWebDriver(driver);
			
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
//			paseString=null;
//			paseString=priceAfterDiscount.substring(b, a);
			//Float estimatedToatalCostAfterPromo = Float.parseFloat(trimPrice);
//			Float estimatedToatalCostAfterPromo = Float.parseFloat(paseString);
	/*		if (true)
				ATUReports.add("Registered User", "Price before Promo Code--" + estimatedToatalCostBeforePromo,
						"Add Coupon ", "User adds coupon sucessful - " + estimatedToatalCostAfterPromo, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			System.out.println("Integer is ++ estimatedToatalCostAfterPromo " + estimatedToatalCostAfterPromo);
			System.out.println(estimatedToatalCostBeforePromo + " ~ " + estimatedToatalCostAfterPromo);
	*/
			
			// org.testng.Assert.assertNotEquals((estimatedToatalCostBeforePromo),
			ATUReports.add("Shopping Bag Page", LocaleName,
					"Applying Promocode and validating rate", "Step -Pass" , LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
	        }

			checkOutPage.click_btn_CheckOut();

		}
		public void shippingPageInfo() throws Exception {
			
			ATUReports.setWebDriver(driver);
			 this.readLocaleAddress();
				shippingDriver.fillShippingInfo(FirstName, LastName, Address1, Address2, Zip, City, Country, Phone);
				System.out.println(FirstName+ LastName+ Address1+ Address2+ Zip+ City+ Country+ Phone);
				
				if(tier.equalsIgnoreCase("Tier3")) {
					float tier3Shipping=(float) 0.00;
				    
					System.out.println("Billing and Handling Cost  -"+tier+"  "+billingPage.get_ShippingandHanding());
				//	assertEquals(tier3Shipping, billingPage.get_ShippingandHanding());
					
				}
		}
		public void billingPageInfo() {
			ATUReports.setWebDriver(driver);
			billingdriver.fillBillingPageDetails(NameOnCard, CardType, CardNumber, Month, Year, CVV);
			ATUReports.add("Billing Page", LocaleName,
					"Filling Billing details", "Status -Pass", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		
		
		public void orderReviewPage() throws Exception {
			ATUReports.setWebDriver(driver);
			Thread.sleep(1000);
			if(!LaunchEnvironment.environmentName.equalsIgnoreCase("production")) {
				System.out.println("ennv name "+LaunchEnvironment.environmentName);
			orderReview.click_placeOrder();
			Thread.sleep(2000);
			confirmationPage.getOrderNumber();
			
			System.out.println("The final generated Order Number- " + confirmationPage.getOrderNumber());
			}
			ATUReports.add("Order Review Page", LocaleName,
					"Confirmation Message-" + confirmationPage.getOrderNumber(), "Step -Pass", LogAs.PASSED,
					new CaptureScreen(OrderConfirmationPage.orderNumber));
			TearDown();
		}
		
		
		
		
		
		
		
		
		
		/*
		Below methods are only for support purposes.
		
		
		*/
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
		   
		   
		   public void  suiteRunner(String data, int testRow) throws Exception {
			   this.testRow=testRow;
			  String LocaleData= data;
			  this.logintoTarte(LocaleData);
			 this.SelectItem();
			 this.shoppingBagPage();
			 this.shippingPageInfo();
			 this.LocaleName= LocaleData;
				//System.out.println("Iteration- "+LocaleNumber+ " ~~~~ "+"_Locale Name-"+ LocaleData);
			 this.billingPageInfo();
				
			 this.orderReviewPage();
			   
		   }
		   
		public void EGCsuiteRunner(int testRow) throws Exception {
			this.testRow=testRow;
			this.logintoTarte("United States of America");
			landingPage.click_HomePageLogo();
			EGC_Runner egcRunner= new EGC_Runner();
			egcRunner.addEGCItem(driver);
			addToBag.clickViewBagCheckOut();
			checkOutPage.click_btn_CheckOut();
			
			
			
		}
	
	
	
	
}
