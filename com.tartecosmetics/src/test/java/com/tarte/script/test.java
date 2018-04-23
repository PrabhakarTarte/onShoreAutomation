package com.tarte.script;
import static com.tarte.config.Config.click;

import static com.tarte.config.Config.getNewDriver;
import static com.tarte.config.Config.loadExcel;
import static com.tarte.config.Config.loadPro;
import static com.tarte.config.Config.setText;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import jxl.Sheet;

public class test {
	//public static RemoteWebDriver driver;
	public static WebDriver driver;
	@Test
	public void checkout() throws MalformedURLException, InterruptedException{
 
 		String URL = "http://tartecosmetics.com";
 		String Node = "http://192.168.1.43:4444/wd/hub";
 		DesiredCapabilities cap = new DesiredCapabilities();
 				//cap = DesiredCapabilities.chrome();
 				cap = DesiredCapabilities.firefox();
 				cap = DesiredCapabilities.edge();
 		
 		driver = new RemoteWebDriver(new URL(Node), cap);
 		
 
 		driver.navigate().to(URL);
 		Thread.sleep(5000);
 		driver.quit();
 	}		
}
	

