package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tarte.config.Config;

public class CheckOutPage extends Config {
	WebDriver driver = null;
	CheckOutPage checkOutPage;
	ShippingPage shippingPage;

	public CheckOutPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(how=How.XPATH, xpath="(.//a[contains(text(),'new arrivals')])[1]")
	static WebElement title_ShoppingBag; 
	
	@FindBy(how=How.XPATH, xpath="(//button[@title='Add to Bag'])[1]")
	static WebElement btn_AddtoBagCartSpecial;
	
	@FindBy(how=How.XPATH, xpath=".//button[@id='add-to-cart']")
	static WebElement btn_AddtoBagCartSpecialPopUp;
	
	@FindBy(how=How.XPATH, xpath=".//table[@class='order-totals-table']//following::td[@class='order-value']")
	static WebElement txt_EstimatedTotal;
	
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'Enter Promo Code')]/preceding-sibling::input[@type='text']")
	static WebElement txtBox_EnterPromoCode;
	
	@FindBy(how=How.XPATH, xpath="(//div[@class='bonus-item-promo']//following::button)[1]/*[contains(text(),'Select')]")
	static WebElement first_SampleItem;
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='add-coupon']")
	static WebElement btn_AddCoupon;
	
	@FindBy(how=How.XPATH, xpath="(.//button[contains(text(),'Checkout') and @name='dwfrm_cart_checkoutCart'])[1]")
	static WebElement btn_CheckOut;
	
	
	
	public static WebElement getBtn_AddtoBagCartSpecial() {
		return btn_AddtoBagCartSpecial;
	}

	public static WebElement getBtn_AddtoBagCartSpecialPopUp() {
		return btn_AddtoBagCartSpecialPopUp;
	}

	public static WebElement getTitle_ShoppingBag() {
		return title_ShoppingBag;
	}

	public static WebElement getTxt_EstimatedTotal() {
		return txt_EstimatedTotal;
	}

	public static WebElement getTxtBox_EnterPromoCode() {
		return txtBox_EnterPromoCode;
	}

	public static WebElement getFirst_SampleItem() {
		return first_SampleItem;
	}

	

	public CheckOutPage clickbtn_AddtoBagCartSpecial() {
		waitTillElementPresent(10, btn_AddtoBagCartSpecial);
		btn_AddtoBagCartSpecial.click();
		return this;
	}

	public CheckOutPage clickbtn_AddtoBagCartSpecialPopUp() {
		btn_AddtoBagCartSpecialPopUp.click();
		return this;
	}

	public CheckOutPage click_first_SampleItem() {
		//Config.scrolldown();
		
		first_SampleItem.submit();;
		return this;
	}
	
	public CheckOutPage click_btn_AddCoupon() {
		btn_AddCoupon.click();
		return this;
	}
	
	public ShippingPage click_btn_CheckOut() {
		
		btn_CheckOut.click();
		return shippingPage;
	}
	
			
			
	
	
	
	
	
	
	
	
	/*
	@FindBy(how=How.XPATH, xpath="(.//a[contains(text(),'new arrivals')])[1]")
	static WebElement link_NewArrival;  */
	
	
	
	
	
	
	

}
