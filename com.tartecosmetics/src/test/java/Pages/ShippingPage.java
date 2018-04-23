package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tarte.config.Config;

public class ShippingPage {
	
	
	WebDriver driver = null;
	ShippingPage shippingPage;

	public ShippingPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']")
	static WebElement shipping_firstName;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_singleshipping_shippingAddress_addressFields_lastName']")
	static WebElement shipping_lastName;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_singleshipping_shippingAddress_addressFields_address1']")
	static WebElement shipping_Address1;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_singleshipping_shippingAddress_addressFields_address2']")
	static WebElement shipping_Address2;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_singleshipping_shippingAddress_addressFields_postal']")
	static WebElement shipping_Zip;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_singleshipping_shippingAddress_addressFields_city']")
	static WebElement shipping_City;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_singleshipping_shippingAddress_addressFields_address2']")
	static WebElement shipping_dropDownStates;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_singleshipping_shippingAddress_addressFields_phone']")
	static WebElement shipping_PhoneNumber;
	
	//@FindBy(how=How.XPATH, xpath=".//button[@value='Continue to Billing']")
	@FindBy(how=How.XPATH, xpath=".//*[@value='Continue to Billing' or name='dwfrm_singleshipping_shippingAddress_save']")
	static WebElement btn_ContinueToBilling;
	
	
	public ShippingPage enter_shipping_firstName(String txt) {
		shipping_firstName.clear();
		shipping_firstName.sendKeys(txt);
		return this;
	}

	public ShippingPage enter_shipping_lastName(String txt) {
		shipping_lastName.clear();
		shipping_lastName.sendKeys(txt);
		return this;
	}

	public ShippingPage enter_shipping_Address1(String txt) {
		shipping_Address1.clear();
		shipping_Address1.sendKeys(txt);
		return this;
	}

	public ShippingPage enter_shipping_Address2(String txt) {
		shipping_Address2.clear();
		shipping_Address2.sendKeys(txt);
		return this;
	}
	
	public ShippingPage enter_shipping_Zip(String txt) throws Exception {
		try {
		if(shipping_Zip.isDisplayed()) {
		shipping_Zip.clear();
		shipping_Zip.sendKeys(txt);
		}}
		catch (Exception e) {
		System.err.println("NO Zip Present in Billing Page"  + e.getMessage() );
			// TODO: handle exception
		}
		 Thread.sleep(500);
		return this;
	}
	
	public ShippingPage enter_shipping_City(String txt) {
		shipping_City.clear();
		shipping_City.sendKeys(txt);
		return this;
	}
	
	
	 public ShippingPage enter_shipping_PhoneNumber(String txt) {
		 shipping_PhoneNumber.clear();
		 shipping_PhoneNumber.sendKeys(txt);	 
		 return this;
		 
	 }
	 
	 public ShippingPage select_StateDrpDown(String txt) throws Exception {
		 Thread.sleep(500);
		 try {
			
			
			 Config.selectDropDown(".//*[@id='dwfrm_singleshipping_shippingAddress_addressFields_states_state']", txt, driver);
			
		 }
			 
		 catch(Exception e) {
			 
			 driver.findElement(By.xpath(".//*[@id='dwfrm_singleshipping_shippingAddress_addressFields_stateCodeAux']")).sendKeys(txt);
			 System.out.println("International Locale "+e.getMessage());
			 
		 }
		 
		 return this;
	 }
	 
	 public void click_btn_ContinueToBilling() throws InterruptedException {
		
		 Config.waitTillElementPresent(500, btn_ContinueToBilling);
		 Config.scrolldownUntilVisisble(btn_ContinueToBilling);
		
		 Thread.sleep(1000);
		 Actions actions = new Actions(driver);
		actions.moveToElement(btn_ContinueToBilling);
		actions.click();
		actions.build().perform();
		 Thread.sleep(1000);
		// btn_ContinueToBilling.click();
	// btn_ContinueToBilling.submit();
		// Thread.sleep(4000);
	 }
	

}
