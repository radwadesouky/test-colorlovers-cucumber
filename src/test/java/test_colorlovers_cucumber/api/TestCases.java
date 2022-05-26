package test_colorlovers_cucumber.api;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCases {

	String URL = "http://www.colourlovers.com/";
	String getURl = "api/patterns";
	Response response;
	int expectedNumViews = 4000;

	@BeforeTest
	public void defineBaseURL()
	{
		// Specify the base URL to the RESTful api
		RestAssured.baseURI = URL;
	}
	@Test
	public void defineRequest()
	{
		RequestSpecification request = GetMethods.specifyRequest("json");
		response = GetMethods.returnResponse(request, getURl);
	}
	@Test
	public void validateNumOfViewsFromResponse()
	{
		// Get the JsonPath object instance from the Response interface(ParseJSON)
		JsonPath js = response.jsonPath();

		//Get value of numViews from response
		List<Integer> list = js.getList("numViews");
		for(int i = 0;i<list.size();i++)
		{
			//Validate that <numViews> (from response) to be greater than 4000” 
			int numViews = list.get(i);
			System.out.print("Value = "+numViews+"\n");
			assertTrue(numViews>expectedNumViews);
		}
	}
	@AfterTest
	public void validateResponseStatus()
	{
		//Validate that response code is OK
		assertEquals(response.statusCode(), 200);
	}


}
