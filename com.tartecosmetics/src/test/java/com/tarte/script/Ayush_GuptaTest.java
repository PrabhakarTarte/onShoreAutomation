package com.tarte.script;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ayush_GuptaTest {

	// public static void main (String [] args) throws InterruptedException,
	// IOException {
	WebDriver driver ;
	
	

	@Test
	public void MyTest() throws InterruptedException, IOException {

			
		// If Selenium Version is above 3.0 include this

		System.setProperty("webDriver.chrome.driver",
				"C:\\Users\\Unicode\\eclipse-workspace\\com.tartecosmetics\\lib\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("Test Start");

		driver.get("http://www.tartecosmetics.com");

		driver.findElement(By.xpath("//a[contains(text(), \"Contact Us\")]")).click();

		driver.findElement(By.xpath("//input[@id=\'name\']")).sendKeys("Ayush");

		driver.findElement(By.xpath("//input[@id=\'email\']")).sendKeys("Ayush@test.com");

		Select selectDrop = new Select(driver.findElement(By.id("00N4600000AOGvP")));
		selectDrop.selectByVisibleText("Ulta");

		driver.findElement(By.xpath("//input[@id=\'order-no\']")).sendKeys("5547");

		Select selectDropCountry = new Select(driver.findElement(By.id("00N4600000AOTZq")));
		selectDropCountry.selectByVisibleText("Albania");

		Select selectDropHelp = new Select(driver.findElement(By.id("options")));
		selectDropHelp.selectByVisibleText("Promos");

		driver.findElement(By.xpath(
				"//span[@class= \'recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox\']"))
				.click();
		;

		driver.findElement(By.xpath("//button[@name =\'submit\']")).click();

		Thread.sleep(5000);

		TakesScreenshot src = ((TakesScreenshot) driver);
		File SrcFile = src.getScreenshotAs(OutputType.FILE);

		File DestFile = new File("C://AyushTest.jpeg");

		FileUtils.copyFile(SrcFile, DestFile);

	}
}