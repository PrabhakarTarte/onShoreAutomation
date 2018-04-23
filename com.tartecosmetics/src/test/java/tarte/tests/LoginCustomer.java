package tarte.tests;

import org.openqa.selenium.WebDriver;

import Pages.LoginPage;

public class LoginCustomer {
	
	LoginPage loginpage;
	
	WebDriver driver;
	public LoginCustomer(WebDriver driver) {
		this.driver=driver;
		loginpage= new LoginPage(driver);
	}
	
	
	public void navigateToLoginPage(String username,String password) throws InterruptedException {
		Thread.sleep(500);
		loginpage.click_link_MyAccount();
		Thread.sleep(500);
		loginpage.click_link_Login();
		Thread.sleep(1000);
		loginpage.enterCredentils(username, password);
	}
	
	
	

}
