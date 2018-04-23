package Pages;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import com.tarte.config.Config;

import tarte.tests.LaunchEnvironment;

public class OrderReview extends Config{
	WebDriver driver;

	public OrderReview(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='primary']//following::button[contains(text(),'Place Order')]")
	public  WebElement placeOrder;
	
	public OrderReview click_placeOrder() throws InterruptedException {
		//Config.scrolldown();
		//Config.scrolldown();
	    Config.scrolldownUntilVisisble(placeOrder);
	    Config.waitTillElementPresent(1000, placeOrder);
	    Thread.sleep(200);
		placeOrder.click();
		Thread.sleep(500);
		return this;
	}
	
	
	

}
