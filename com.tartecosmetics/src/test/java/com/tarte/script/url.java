package com.tarte.script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static com.tarte.config.Config.getNewDriver;

public class url {

	WebDriver driver;

	@Test
	public void checkBrokenLinks() {

		driver = getNewDriver();
		driver.get("http://tartecosmetics.com");

		List<String> hrefs = new ArrayList<String>();
		List<WebElement> anchors = driver.findElements(By.tagName("a"));
		anchors.addAll(driver.findElements(By.tagName("img alt src"))); 
		for (WebElement anchor : anchors) {

			if (anchor.getAttribute("href") != null)
				hrefs.add(anchor.getAttribute("href"));

		}

		for (String href : hrefs) {

			try {

				int responseCode = returnStatusCode(new URL(href));
				if (responseCode != 200) {
					System.out.println("The broken Link is " + href);

				} else {
System.out.println("The Broken links are :" + href);
					System.out.println("The working Link is " + href);

				}
			} catch (Exception e) {
				System.out.println("URL: " + href + " returned " + e.getMessage());

			}

		}

	}

	public int returnStatusCode(URL url) {
		Response resp = given().

				when().

				get(url);

		return resp.getStatusCode();
	}

}