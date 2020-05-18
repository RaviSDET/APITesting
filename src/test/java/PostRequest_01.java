
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest_01 {

	@Test
	public void postMethod() {

		// Give Base Url
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// Request Object
		RequestSpecification httprequest = RestAssured.given();

		// Adding Json Body

		JSONObject requestpayload = new JSONObject();
		requestpayload.put("FirstName", "ra4vi");
		requestpayload.put("LastName", "edf");
		requestpayload.put("Username", "1");
		requestpayload.put("Password", "145t");
		requestpayload.put("Email", "test@gmail.com");

		// adding headers
		httprequest.header("Content-type", "application/JSON");
		// converting into json string
		httprequest.body(requestpayload.toJSONString());

		// response object

		Response response = httprequest.request(Method.POST,"/register");

		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 201);
		
		String successcode=response.jsonPath().get("Successcode");
		System.out.println(successcode);
		//Assert.assertEquals(actual, expected);
		

	}
}
