package Pages;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tarte.config.Config;

import net.bytebuddy.implementation.bind.annotation.Super;

public class LandingPage extends Config {
	

	/**
	 * Author Prabhakar
	 * Page Object model- Page is to access the page element of the handing page
	 * 
	 */

	WebDriver driver =null;
	LandingPage landingPage;
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
        this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}

	/**
	 * 
	 */
	@FindBy(how=How.XPATH, xpath="(//a[contains(text(),'makeup')])[1]")
	 static WebElement 	link_Makeup;
	
	
	
	
	public static WebElement getLink_Makeup() {
		return link_Makeup;
	}
	public static WebElement getLink_NewArrival() {
		return link_NewArrival;
	}
	public static WebElement getLink_bestsellers() {
		return link_bestsellers;
	}
	public static WebElement getLink_SkinCare() {
		return link_SkinCare;
	}
	public static WebElement getLink_Sale() {
		return link_Sale;
	}
	public static WebElement getLink_Explore() {
		return link_Explore;
	}

	@FindBy(how=How.XPATH, xpath="//a[@title='tarte cosmetics Home']")
	static WebElement click_HomePageLogo;
	
	@FindBy(how=How.XPATH, xpath="(.//a[contains(text(),'new arrivals')])[1]")
	static WebElement link_NewArrival;
	
	
	@FindBy(how=How.XPATH, xpath="(.//a[contains(text(),'best sellers')])[1]")
	static WebElement link_bestsellers;
	
	@FindBy(how=How.XPATH, xpath="(.//a[contains(text(),'skincare')])[1]")
	static WebElement link_SkinCare;
	
	
	@FindBy(how=How.XPATH, xpath="(.//a[contains(text(),'sale')])[1]")
	static WebElement link_Sale;
	
	@FindBy(how=How.XPATH, xpath="(.//a[contains(text(),'explore')])[1]")
	static WebElement link_Explore;
	
	@FindBy(how=How.XPATH, xpath=".//form[@name='simpleSearch']//input[@name='q']")
	static WebElement searchBox;
	
	@FindBy(how=How.XPATH, xpath=".//*[@class='current-country']")
	static WebElement link_shipToCountry;
	
	@FindBy(how=How.XPATH, xpath=".//input[@class='input-text' and @name='countryFilter']")
	static WebElement input_CountryName;
	
	@FindBy(how=How.XPATH, xpath="//div[@class='selector-countries']//following::a[@class='locale selected']")
	static WebElement suggested_Locale;
	
	@FindBy(how=How.XPATH, xpath="//a[contains(text(),'Gift Card')]")
	static WebElement giftCard;
	
	
	public static WebElement getGiftCard() {
		return giftCard;
	}
	public LandingPage click_Makeup() {	
		
		System.out.println("Inside click makeup");
		//driver.findElement(By.xpath(".//*[@id='navigation']/ul[1]/li[3]/a")).click();;
	 	link_Makeup.click();		
		return this;		
	}
	public LandingPage click_NewArrivals() {		
	//	driver.findElement(arg0)
		link_NewArrival.click();		
		return this;		
	}
	public LandingPage click_bestSellers() {		
		link_bestsellers.click();		
		return this;		
	}
	public LandingPage click_SkinCare() {		
		link_SkinCare.click();		
		return this;		
	}
	public LandingPage click_Sale() {		
		link_Sale.click();		
		return this;		
	}
	public LandingPage click_Explore() {		
		link_Explore.click();		
		return this;		
	}
	public LandingPage click_shipT0_URL() throws InterruptedException {
		link_shipToCountry.click();	
		Thread.sleep(300);
		return this;
	}
	
	
   public void selectCountry(String txt) throws InterruptedException {
	   System.out.println("Inside sleect country" + txt);
	   
	   input_CountryName.clear();  
    	input_CountryName.sendKeys(txt);
	    Thread.sleep(1000);
	  //  suggested_Locale.click();
        setCountry(txt, driver);
   }
    
   public void click_HomePageLogo() {
	   System.out.println("Clicked home page logo");
    	click_HomePageLogo.click();
    }
	

	
	
	
	
	
	
	
/*	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	@FindBy(how=How.XPATH, xpath=".//*[contains(text(),'makeup')]")
	*/
	
	
	
	
	

}
