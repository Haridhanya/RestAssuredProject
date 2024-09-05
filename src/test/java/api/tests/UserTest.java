package api.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoint;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTest {

	User Userpayload=new User();
	Faker fr=new Faker();
	@BeforeClass
	public void UserSetup()
	{
		Userpayload.setId(fr.idNumber().hashCode());
		Userpayload.setUsername(fr.name().username());
		Userpayload.setFirstName(fr.name().firstName());
		Userpayload.setLastName(fr.name().lastName());
		Userpayload.setEmail(fr.internet().safeEmailAddress());
		Userpayload.setPassword(fr.internet().password(5,10));
		Userpayload.setPhone(fr.phoneNumber().cellPhone());	
		Userpayload.setUserStatus(0);
		
		
	}
	
	@Test(priority=1)
	public void createUser()
	{
	
		
		Response res=UserEndpoint.CreateUser(Userpayload);
		res.then().statusCode(200);
	
	}
	@Test(priority=2)
	public void getUser()
	{
		Response res=UserEndpoint.getUser(Userpayload.getUsername());
		res.then().log().all();
	}
	@Test(priority=3)
	public void updateUser()
	{
		//updating the request
		Userpayload.setFirstName(fr.name().firstName());
		Userpayload.setLastName(fr.name().lastName());
		Response res=UserEndpoint.updateUser(Userpayload, Userpayload.getUsername());
		res.then().log().all();
	
	}
	@Test (priority=4)
	public void deleteUser()
	{
		Response res=UserEndpoint.deleteUser(Userpayload.getUsername());
		res.then().log().all();
	}
	
	
}
