package com.tarte.script;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class responsecode {
	@Test
	public void GetWeatherDetails()
	{
		RestAssured.baseURI = "http://tartecosmetics.com";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();

		// Get the status code from the Response. In case of 
		// a successfull interaction with the web service, we
		// should get a status code of 200.
		int statusCode = response.getStatusCode();

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	}

}
