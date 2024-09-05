package api.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


import api.endpoints.UserEndpoint;
import api.payloads.User;
import api.utilities.DataProviderS;

import io.restassured.response.Response;


public class UserDDTest {

	public Logger logger;
	
	User UserPayload=new User();
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviderS.class)
	public void createUser(String id,String username,String firstname,String lastname,String email,String password,String phone)
	{
		logger=LogManager.getLogger(this.getClass());
		logger.info("===========Creating a new User===========");
		UserPayload.setId(Integer.parseInt(id));
		UserPayload.setUsername(username);
		UserPayload.setFirstName(firstname);
		UserPayload.setLastName(lastname);
		UserPayload.setEmail(email);
		UserPayload.setPassword(password);
		UserPayload.setPhone(phone);
		
		Response res=UserEndpoint.CreateUser(UserPayload);
		res.then().statusCode(200);
		}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviderS.class)
	public void deleteUser(String username)
	{
		logger.info("=======Deleting the user===========");
		
		Response res=UserEndpoint.deleteUser(username);
		res.then().log().all();
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
