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

import api.payloads.Pet;
import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.http.Header;


public class PetEndpoint {

	
	public static ResourceBundle geturl()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static void createPet(Pet payload)
	{
		String postUrl=geturl().getString("createPet");
		given().contentType(ContentType.JSON)
		.body(payload).log().all()
		.when().post(postUrl)
		.then().statusCode(200).log().all();
		
		
		
	}
	public static void getPet(int id)
	{
		
		String getUrl=geturl().getString("getPet");	
		given().pathParam("pet_id", id)	
		.when().get(getUrl)
		.then().statusCode(200).log().all();
		
	}
	public static void updatePet(Pet payload)
	{
		

		String updateUrl=geturl().getString("updatePet");
		given().contentType(ContentType.JSON)
		.body(payload).log().all()
		.when().post(updateUrl)
		.then().statusCode(200).log().all();
		
		
		
		
		
		
	}
	public static void deletePet(int id)
	{
		
		String deleteUrl=geturl().getString("deletePet");	
		given().pathParam("pet_id", id)	
		.when().get(deleteUrl)
		.then().statusCode(200).log().all();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
