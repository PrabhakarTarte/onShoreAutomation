package com.tarte.config;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Config {

	static WebDriver driver;

	public static Properties loadPro(String path) {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(new File(path)));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pro;
	}

	
	
	public static WebDriver getChromeDriver() {
		Properties p = loadPro("src\\test\\resources\\repository\\browser.properties");
		System.setProperty(p.getProperty("chromepro"), p.getProperty("chromedriver"));
		if (driver == null)
			driver = new ChromeDriver();
		else
			driver = getNewDriver();
		return driver;
	}
	
	/* Ayush : Added new method for firefox*/
	
	public static WebDriver getFirefoxDriverDriver() {
		Properties p = loadPro("src\\test\\resources\\repository\\browser.properties");
		System.setProperty(p.getProperty("Firefoxpro"), p.getProperty("Firefoxdriver"));
		if (driver == null)
			driver = new FirefoxDriver();
		else
			driver = getNewDriver();
		return driver;
	}
	
	

	public static WebDriver getNewDriver() {
		Properties p = loadPro("src\\test\\resources\\repository\\browser.properties");
		System.setProperty(p.getProperty("chromepro"), p.getProperty("chromedriver"));
		return new ChromeDriver();

	}

	public static void waitThread(long millisecond) {
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setText(String text, String xpath, WebDriver driver) {
		try {

			driver.findElement(By.xpath(xpath)).click();
			waitThread(100l);
			driver.findElement(By.xpath(xpath)).sendKeys(text);
		} catch (Exception e) {
			System.out.println("catch0");
		}
	}

	public static void clickJS(String xpath, WebDriver driver) {
		WebElement webElement = null;
		webElement = driver.findElement(By.xpath(xpath));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", webElement);

	}

	public static void click(String xpath, WebDriver driver) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static Sheet loadExcel(String path) {
		Sheet s = null;
		Workbook w = null;
		try {
			w = Workbook.getWorkbook(new File(path));
			s = w.getSheet(0);
		} catch (Exception e) {
		}
		return s;
	}

	public static void waitForSpinner(WebDriver driver) {
		int time = 0;
		while (!(driver.findElements(By.xpath("//div[contains(text(),'No thanks')]")).size() > 0)) {
			waitThread(100l);
			if (time > 50)
				break;
			time++;
		}

		waitThread(500l);
		if (driver.findElements(By.xpath("//div[contains(text(),'No thanks')]")).size() > 0)
			driver.findElement(By.xpath("//div[contains(text(),'No thanks')]")).click();
	}

	public static void javaScriptClick(String xpath, WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void takeScreenShot(String screenshotname, String path, WebDriver driver) {
		path = path + "\\" + screenshotname;
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(path));
		} catch (Exception e) {
		}
	}

	public static void writeToExcel(WritableSheet ws, int col, int row, String str) {

		try {
			Label lab;
			lab = new Label(col, row, str);
			ws.addCell(lab);
		} catch (Exception e) {
		}

	}

	public static WritableWorkbook createExcel(String path) {
		WritableWorkbook ww = null;
		try {
			File f = new File(path);
			ww = Workbook.createWorkbook(f);
		} catch (Exception e) {
		}
		return ww;

	}

	public static void closeExcel(WritableWorkbook ww) {
		try {
			ww.write();
			ww.close();
		} catch (Exception e) {
		}
	}

	public static void selectDropDown(String xpath, String data, WebDriver driver) {
		WebElement webElement = driver.findElement(By.xpath(xpath));
		Select s = new Select(webElement);
		s.selectByVisibleText(data);
	}

	public static void selectDropDownInput(String xpath, String xpath2, String text, WebDriver driver) {

		try {
			if (driver.findElement(By.xpath(xpath)) != null) {
				WebElement webElement = driver.findElement(By.xpath(xpath));
				Select s = new Select(webElement);
				s.selectByVisibleText(text);
			} else {
				setText(text, xpath2, driver);
			}
		} catch (Exception e) {
			setText(text, xpath2, driver);

		}
	}

	public static String getText(String xpath, WebDriver driver) {
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public static void setCountry(String country, WebDriver driver) {
		int count = driver.findElements(By.xpath(".//*[@id='wrapper']/div[2]/div[3]/div/div[2]/div/div")).size();
		for (int i = 1; i < count; i++) {
			WebElement webElement = driver
					.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[3]/div/div[2]/div/div[" + i + "]/a"));

			String COUNTRY = webElement.getText().split(Pattern.quote("("))[0].trim();
			System.out.println(COUNTRY);
			if (COUNTRY.equalsIgnoreCase(country)) {
				waitThread(1001);
				webElement.click();
				break;
			}
		}
	}

	public static void setmousehover(String text1, String text2, WebDriver driver) {
		WebElement element = driver.findElement(By.linkText(text1));

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText(text2)).click();
	}

	public static void scrolldown() {
	//	WebDriver driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
	}
	
	public static void scrolldownUntilVisisble(WebElement element) throws InterruptedException {
		//	WebDriver driver = new ChromeDriver();
			
		//	WebElement element = driver.findElement(By.id("id_of_element"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 
		}
	
	public static void  waitTillElementPresent(int waitTime,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	public static void windowscroll() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	
	public void TearDown() {
		driver.quit();
	}
	
}
