
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest_01 {

	@Test
	public void getMethod() {

		// Base Url
		RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city/mumbai";

		// Request Object
		RequestSpecification httprequest = RestAssured.given();

		// getting Response
		Response response = httprequest.request(Method.GET);

		String responsebody = response.getBody().asString();

		System.out.println("Response body is " + responsebody);


		// statusCode
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);

		// statusline
		String StatusLine = response.getStatusLine();
		System.out.println(StatusLine);

	}

}
