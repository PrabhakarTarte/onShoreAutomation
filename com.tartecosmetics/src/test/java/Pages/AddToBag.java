package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tarte.config.Config;

public class AddToBag extends Config{

	/**
	 * Author Prabhakar Page Object model- Page is to add the product to the
	 * checkout bag
	 * 
	 */

	WebDriver driver = null;
	CheckOutPage checkOutPage;

	public AddToBag(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

		PageFactory.initElements(this.driver, this);
	}
  
	
		@FindBy(how=How.XPATH, xpath="(.//*[@id='add-to-cart'])")
		 WebElement btn_addToCart;
		
		
		
		@FindBy(how=How.XPATH, xpath=".//*[@id='mini-cart']//following::span[@class='minicart-quantity']")
		  WebElement btn_ViewBagCheckOut ;
		

		@FindBy(how=How.XPATH, xpath=".//*[@id='wrapper']/footer/div[3]/svg")
		 static WebElement 	arrow_ScrollUP;
		
	
		
		public AddToBag clickaddToCart() throws InterruptedException {
			Thread.sleep(1500);
			btn_addToCart.click();
			return this;
		}
	
		public CheckOutPage clickViewBagCheckOut() throws InterruptedException {
		    Thread.sleep(3000);
			waitTillElementPresent(10, btn_ViewBagCheckOut);
			btn_ViewBagCheckOut.click();
			return checkOutPage ;
		}
		
		public AddToBag click_ScrollUp() throws InterruptedException {
			
			arrow_ScrollUP.click();
			return this;
		}
	
		
/*
		.//*[@id='wrapper']/footer/div[3]/svg

		@FindBy(how=How.XPATH, xpath="(.//*[@id='add-to-cart']")
		 static WebElement 	btn_addToCart;

		@FindBy(how=How.XPATH, xpath="(.//*[@id='add-to-cart']")
		 static WebElement 	btn_addToCart;

		@FindBy(how=How.XPATH, xpath="(.//*[@id='add-to-cart']")
		 static WebElement 	btn_addToCart;

		@FindBy(how=How.XPATH, xpath="(.//*[@id='add-to-cart']")
		 static WebElement 	btn_addToCart;

		@FindBy(how=How.XPATH, xpath="(.//*[@id='add-to-cart']")
		 static WebElement 	btn_addToCart;

		@FindBy(how=How.XPATH, xpath="(.//*[@id='add-to-cart']")
		 static WebElement 	btn_addToCart;

		@FindBy(how=How.XPATH, xpath="(.//*[@id='add-to-cart']")
		 static WebElement 	btn_addToCart;

		@FindBy(how=How.XPATH, xpath="(.//*[@id='add-to-cart']")
		 static WebElement 	btn_addToCart;

		@FindBy(how=How.XPATH, xpath="(.//*[@id='add-to-cart']")
		 static WebElement 	btn_addToCart;

		@FindBy(how=How.XPATH, xpath="(.//*[@id='add-to-cart']")
		 static WebElement 	btn_addToCart;

		@FindBy(how=How.XPATH, xpath="(.//*[@id='add-to-cart']")
		 static WebElement 	btn_addToCart;
	*/
	
	
}
