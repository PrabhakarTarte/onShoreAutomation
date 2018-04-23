package tarte.tests;

import org.openqa.selenium.WebDriver;

import Pages.ShippingPage;

public class ShippingDriver {
	WebDriver driver;
	ShippingPage shipingpage;
	
	public ShippingDriver(WebDriver driver) {
        this.driver=driver;   
		shipingpage= new ShippingPage(driver);

	}
	
	public void fillShippingInfo(String fname, String lname,String add1,String add2,String zip, String city, String country,String phone) throws Exception {
		shipingpage.enter_shipping_firstName(fname).enter_shipping_lastName(lname).enter_shipping_Address1(add1)
		
		.enter_shipping_Address2(add2)
		.enter_shipping_Zip(zip)
		.enter_shipping_City(city)
		.select_StateDrpDown(country)
		.enter_shipping_PhoneNumber(phone)
		.click_btn_ContinueToBilling();
		
	}
	

}
