package stepsdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test_colorlovers_cucumber.api.TestCases;

public class getColorsPatterns extends TestCases{
	TestCases TCobj;
	@Given("specify the base URL of colourloversAPIs")
	public void specify_the_base_url_of_colourlovers_ap_is() {
		TCobj.defineBaseURL();
	}
	@When("user defines request parameters , headers and HTTP method")
	public void user_defines_request_parameters_headers_and_http_method() {
		TCobj.defineRequest();
	}
	@Then("The returned response should be is ok")
	public void the_returned_response_should_be_is_ok() {
		TCobj.validateResponseStatus();
	}
	@Then("verify if number of views are greater than {int}")
	public void verify_if_number_of_views_are_greater_than(Integer int1) {
		TCobj.validateNumOfViewsFromResponse();
	}

}
