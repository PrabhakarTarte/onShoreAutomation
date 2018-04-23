package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tarte.config.Config;

public class BillingPage {
	
	WebDriver driver = null;

	public BillingPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='creditCardList']")
	static WebElement selectACC;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_billing_paymentMethods_creditCard_owner']")
	static WebElement nameOnCard;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_billing_paymentMethods_creditCard_type']")
	static WebElement cardType;

	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_billing_paymentMethods_creditCard_number']")
	static WebElement cardNumber;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_billing_paymentMethods_creditCard_expiration_month']")
	static WebElement monthDrpDown;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_billing_paymentMethods_creditCard_expiration_year']")
	static WebElement yearDrpDown;
	
	@FindBy(how=How.XPATH, xpath=".//input[@id='dwfrm_billing_paymentMethods_creditCard_saveCard']")
	static WebElement chkBox_SavethisCard;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_billing_paymentMethods_creditCard_cvn']")
	static WebElement CVV;
	
	@FindBy(how=How.XPATH, xpath=".//button[@id='billingSubmitButton']")
	static WebElement btn_continueToReview;
	
	@FindBy(how=How.XPATH, xpath=".//table[@class=\"order-totals-table\"]//following::td[contains(text(),'Shipping & Handling')]//following-sibling::td")
	static WebElement txt_ShippingaandHandling;
	
	
	
	public BillingPage enter_SelectCredit() {
	
		//WebElement selectCC=driver.findElement(By.xpath(".//*[@id='creditCardList']//following::*[contains(text(),'New Card')]"));
		try {
			WebElement selectCC=driver.findElement(By.xpath(".//*[@id='creditCardList']//following::*[contains(text(),'New Card')]"));
			if(selectACC.isDisplayed()) {
				Config.selectDropDown(".//*[@id='creditCardList']", "New Card", driver);
				// Config.selectDropDown(".//*[@id='creditCardList']", "New Card", driver);
			}
		}
		catch(Exception e) {
			System.out.println("NO SUCH ELEMENT- "+"New Card");
			return this;
		}
		return this;
			
					
		
		
		
		
	}
		
		
	public BillingPage enter_nameOnCard(String txt) {
	    this.enter_SelectCredit();
		nameOnCard.clear();
		nameOnCard.sendKeys(txt);
		return this;
	}

	public BillingPage enter_cardType(String txt) {
		
		
		Config.selectDropDown(".//*[@id='dwfrm_billing_paymentMethods_creditCard_type']", txt, driver);
		return this;
	}

	public BillingPage enter_cardNumber(String txt) {
		
		cardNumber.clear();
		cardNumber.sendKeys(txt);
		return this;
	}

	public BillingPage enter_monthDrpDown(String txt) {
		Config.selectDropDown(".//*[@id='dwfrm_billing_paymentMethods_creditCard_expiration_month']", txt, driver);
		return this;
	}

	public BillingPage enter_yearDrpDown(String txt) {
		Config.selectDropDown(".//*[@id='dwfrm_billing_paymentMethods_creditCard_expiration_year']", txt, driver);
		return this;
	}
	
	public BillingPage enter_CVV(String txt) {
		CVV.clear();
		CVV.sendKeys(txt);
		return this;
		
	}

	public BillingPage click_btn_continueToReview() {
		/*if(chkBox_SavethisCard.isSelected()) {
			chkBox_SavethisCard.click();
		}
		
		chkBox_SavethisCard.click();*/
		btn_continueToReview.click();
		return this;
	}
	
	public float get_ShippingandHanding() {
		String shippingAmt=txt_ShippingaandHandling.getText();
		System.out.println(shippingAmt);
		String tmp= null;
		tmp=shippingAmt.substring(1, (shippingAmt.length()-1));
		System.out.println();
		float Shipprice= Float.parseFloat(tmp);
		
		return Shipprice ;
		
	}
}
