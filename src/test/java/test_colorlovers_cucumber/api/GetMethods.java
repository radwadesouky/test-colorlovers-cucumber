package test_colorlovers_cucumber.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethods {
	public static RequestSpecification specifyRequest(String formatType) {
		// Get the RequestSpecification of the request to be sent to the server
		RequestSpecification httpRequest=RestAssured.given().log().all()
				.queryParam("format", formatType)
			    .header("Content-Type", "application/json; charset=utf-8")
				.header("User-Agent","PostmanRuntime/7.29.0").header("Connection","keep-alive");
		return httpRequest;
	}
	public static Response returnResponse(RequestSpecification httpRequest,String url)
	{
		// specify the method type (GET)
		Response response = httpRequest.when().get(url);
		return response;
	}

}
