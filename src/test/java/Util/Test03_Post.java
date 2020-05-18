package Util;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test03_Post {


@Test
public void RegistrationSuccessful()
{ 
 RestAssured.baseURI ="http://restapi.demoqa.com/customer";
 RequestSpecification request = RestAssured.given();
 
 JSONObject requestParams = new JSONObject();
 requestParams.put("FirstName", "Vi123r"); 
 requestParams.put("LastName", "Singh1233");
 requestParams.put("UserName", "sdimpleuser2");
 requestParams.put("Password", "passwor122");
 
 requestParams.put("Email",  "sampl1@gmail.com");
 request.body(requestParams.toJSONString());
 Response response = request.post("/register");
              String responsebody=   response.getBody().asString();
              System.out.println(responsebody);
 int statusCode = response.getStatusCode();
 Assert.assertEquals(String.valueOf(statusCode), "201");
 String successCode = response.jsonPath().get("SuccessCode");
 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
}
}
