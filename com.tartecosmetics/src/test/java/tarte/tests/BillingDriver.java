package tarte.tests;

import org.openqa.selenium.WebDriver;

import com.tarte.config.Config;

import Pages.BillingPage;

public class BillingDriver {
	
	WebDriver driver;
	BillingPage billingpage;
	public BillingDriver(WebDriver driver) {
		
		this.driver = driver;
		billingpage=new BillingPage(driver);
		
	}
	
	public void fillBillingPageDetails(String nameOnCard,String cardType , String cardNumber, String month,String year, String cvv) {
		Config.scrolldown();
		
		billingpage.enter_nameOnCard(nameOnCard)
		.enter_cardType(cardType)
		.enter_cardNumber(cardNumber)
		.enter_monthDrpDown(month)
		.enter_yearDrpDown(year)
		.enter_CVV(cvv)
		.click_btn_continueToReview();
	}
	
	

}
