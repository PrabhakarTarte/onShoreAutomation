package tarte.tests;

import static com.tarte.config.Config.waitForSpinner;
import static com.tarte.config.Config.waitThread;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.regexp.recompile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.tarte.config.Config;

import BusinessTestRuns.RegisteredUserCheckoutScenario;

public class LaunchEnvironment extends Config {
	Properties pro;
	WebDriver driver;
	
	
	

	
	public LaunchEnvironment(WebDriver driver) {
		
		this.driver = driver;
	}


	public static String environmentName;
	String userName;
	String password;
    String path=".\\src\\test\\resources\\repository\\environment.properties";
	
	
   
    public void launchEnvionmentURL() throws AWTException {
    	pro=loadPro(path);
    	driver.manage().window().maximize();
    	environmentName=pro.getProperty("environment");
    	System.out.println("Running on environment -"+ environmentName);
    	if(environmentName.equalsIgnoreCase("staging")||environmentName.equalsIgnoreCase("dev")){
    		userName=pro.getProperty("username");
    		password=pro.getProperty("password");
    		System.out.println(userName+password+environmentName);
    		
    		driver.get("https://storefront:tarte2017@staging.tartecosmetics.com/");
    		
    		//driver.get("https://staging.tartecosmetics.com");
    		
    		/*waitThread(1001);
    		Robot r = new Robot();
    		waitThread(1001);
    		StringSelection ss = new StringSelection("storefront");
    		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    		waitThread(1001);
    		r.keyPress(KeyEvent.VK_CONTROL);
    		r.keyPress(KeyEvent.VK_V);
    		r.keyRelease(KeyEvent.VK_CONTROL);
    		r.keyRelease(KeyEvent.VK_V);
    		r.keyPress(KeyEvent.VK_TAB);
    		r.keyRelease(KeyEvent.VK_TAB);
    		waitThread(1001);
    		ss = new StringSelection("tarte2017");
    		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    		waitThread(1001);
    		r.keyPress(KeyEvent.VK_CONTROL);
    		r.keyPress(KeyEvent.VK_V);
    		r.keyRelease(KeyEvent.VK_CONTROL);
    		r.keyRelease(KeyEvent.VK_V);
    		r.keyPress(KeyEvent.VK_ENTER);
    		r.keyRelease(KeyEvent.VK_ENTER);
    		waitThread(6001);
    		//waitForSpinner(driver);
*/    		
    		
    	}
    	
    	else {
    		driver.get("https://tartecosmetics.com/");
    	}
    	
    }
     

}
