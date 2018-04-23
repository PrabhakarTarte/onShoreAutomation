package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tarte.config.Config;

public class GC_Page extends Config {
	
	WebDriver driver =null;
	LandingPage landingPage;
	
	public GC_Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
        this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_giftcert_purchase_recipient']")
	 static WebElement 	txt_friendsName;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_giftcert_purchase_recipientEmail']")
	 static WebElement 	txt_friendsEmail;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_giftcert_purchase_confirmRecipientEmail']")
	 static WebElement 	txt_confirm_friendsEmail;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_giftcert_purchase_message']")
	 static WebElement 	txt_Message;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='dwfrm_giftcert_purchase_amount']")
	 static WebElement 	input_Amount;
	
	@FindBy(how=How.XPATH, xpath="//*[contains(text(),'Add to Bag')]")
	 static WebElement 	btn_AddToBag;
	
	public void fillEGCDetails(String friendsName,String friendsEmail, String confirmEmail,String message, String amount) {
		txt_friendsName.sendKeys(friendsName);
		txt_friendsEmail.sendKeys(friendsEmail);
		txt_confirm_friendsEmail.sendKeys(confirmEmail);
		txt_Message.sendKeys(message);
		input_Amount.sendKeys(String.valueOf(amount));
		btn_AddToBag.click();
		
		
	}

}
