package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	
	WebDriver driver;

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how=How.XPATH, xpath=".//*[@id='primary']/div/div[1]/h1")
	public static WebElement orderNumber;
	
	public String getOrderNumber() {
		String message= orderNumber.getText();
		int indexOne= message.indexOf('2');
		int indexLast= message.length();
		String confirmationOrder= message.substring(indexOne, indexLast); 
	
		//System.out.println(message +" ~~~  "+index);
		
		return confirmationOrder;
	}
	
	
	
	

}
