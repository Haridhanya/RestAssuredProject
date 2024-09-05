package api.endpoints;

//create user: https://petstore.swagger.io/v2/user
//get user : https://petstore.swagger.io/v2/user/{username}
//update user: https://petstore.swagger.io/v2/user/{username}
//delete user: https://petstore.swagger.io/v2/user/{username}



public class Routes {
	
	static String base_uri="https://petstore.swagger.io/v2";
	
	static String createUser=base_uri+"/user";

	static String getUser=base_uri+"/user/{username}";

	static String updateUser=base_uri+"/user/{username}";

	static String deleteUser=base_uri+"/user/{username}";
	

}
