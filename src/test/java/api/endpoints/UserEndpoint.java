package api.endpoints;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.http.Header;

public class UserEndpoint {

	
	public static ResourceBundle geturl()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	
	public static Response CreateUser(User payload)
	{
		
		String createUrl=geturl().getString("createUser");
		
		Response res=given().accept("application/json")
				.contentType("application/json")
				
		.body(payload).log().all()
		.when().post(createUrl);
		res.then().statusCode(200);
		
		return res;
		
	}
	
	public static Response getUser(String username)
	{
		String getUrl=geturl().getString("getUser");
		Response res=given().pathParam("username", username)
		.when().get(getUrl);
		
		return res;
		
	}
	
	public static Response updateUser(User body,String Username)
	{
		String updateUrl=geturl().getString("updateUser");
		
		Response res=given().accept("application/json")
				.contentType("application/json")
				.body(body).log().all()
				.pathParam("username", Username)
				.when().put(updateUrl);
		
		
		return res;
		
	}
	public static Response deleteUser(String username)
	{
		String deleteUrl=geturl().getString("deleteUser");
		Response res=given().pathParam("username", username)
		.when()
		.delete(deleteUrl);
		
		return res;
		
	}
	
	
}
