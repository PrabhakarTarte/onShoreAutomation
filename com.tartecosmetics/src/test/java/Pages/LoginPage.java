package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tarte.config.Config;

public class LoginPage {
	WebDriver driver = null;
	LoginPage loginPage;
	/*String username ="tarte.prabhakar.qa01@gmail.com";
	String password= "tarte@2017";
	*/

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(how = How.XPATH, xpath = "(.//*[contains(text(),'My Account')])[1]")
	static WebElement link_MyAccount;

	@FindBy(how = How.XPATH, xpath = "(.//*[contains(text(),'Login') and @class='account-link'])[1]")
	static WebElement link_Login;
	
	@FindBy(how = How.XPATH, xpath = ".//input[@id='dwfrm_login_username']")
	static WebElement input_EmailAddress;
	
	@FindBy(how = How.XPATH, xpath = ".//input[@id='dwfrm_login_password']")
	static WebElement input_Password;
	
	@FindBy(how = How.XPATH, xpath = ".//button[@name='dwfrm_login_login' and contains(text(),'Login')]")
	static WebElement btn_Login;
	

	/*
	 * public LoginPage click() {
	 * 
	 * }
	 */

	public LoginPage click_link_MyAccount() {
		try{
			link_MyAccount.click();	
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Already logged in" +e.getMessage());
			driver.quit();
		}
		finally {
			
		}
		
		return this;
	}

	public LoginPage click_link_Login() {
		link_Login.click();
		return this;
	}
	
	public LoginPage enterCredentils(String username,String password ) throws InterruptedException {
		input_EmailAddress.clear();
		//Thread.sleep(1000);
		
		input_EmailAddress.sendKeys(username);
		input_Password.clear();
		input_Password.sendKeys(password);
		//Thread.sleep(1000);
		btn_Login.click();
		
		return this;
	}

	/*
	 * @FindBy(how=How.XPATH, xpath="(//a[contains(text(),'makeup')])[1]") static
	 * WebElement link_Makeup;
	 */

}
