package RegisteredCheckoutScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.Xls_Reader;
import Pages.GC_Page;
import Pages.LandingPage;

public class EGC_Runner extends RunnerScripts {
	
	   
	public void addEGCItem(WebDriver driver) throws InterruptedException {
		Thread.sleep(500);
		scrolldownUntilVisisble(driver.findElement(By.xpath("//a[contains(text(),'Gift Card')]")));
		Thread.sleep(500);
		LandingPage.getGiftCard().click();
		reader = new Xls_Reader(".\\INPUT\\TestData.xlsx");
        int testRow=2;
        String friendsName= reader.getCellData("EGC", "Friends Name", testRow);
        String friendsEmail= reader.getCellData("EGC", "Email", testRow);
        String confirmEmail= reader.getCellData("EGC", "ConfirmEmail", testRow);
        String message= reader.getCellData("EGC", "Messgae", testRow);
        String amount= reader.getCellData("EGC", "Amount", testRow);
        
        System.out.println(friendsName+friendsEmail+confirmEmail+message+amount);
        GC_Page gc= new GC_Page(driver);
        gc.fillEGCDetails(friendsName, friendsEmail, confirmEmail, message, amount);
        
        

	    
	
	}
	
	
  

}
