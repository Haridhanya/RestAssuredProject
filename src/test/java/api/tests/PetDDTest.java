package api.tests;


import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import api.endpoints.PetEndpoint;
import api.endpoints.UserEndpoint;
import api.payloads.Pet;
import api.payloads.PetCategory_SubClass;
import api.payloads.PetTags_SubClass;
import api.payloads.User;
import api.utilities.DataProviderS;

import io.restassured.response.Response;


public class PetDDTest {

	public Logger logger;
	
	Pet petPayload=new Pet();
	
	@Test(priority=1,dataProvider="PetData",dataProviderClass=DataProviderS.class)
	public void createPet(String id,String cid,String cname,String name,String photourl,String tid,String tname,String status)
	{
		logger=LogManager.getLogger(this.getClass());
		
				
				petPayload.setId(Integer.parseInt(id));
				//create category
				PetCategory_SubClass cat=new PetCategory_SubClass();
				cat.setId(Integer.parseInt(cid));
				cat.setName(cname);
				petPayload.setCategory(cat);
				petPayload.setName(name);
				petPayload.setPhotoUrls(Arrays.asList(photourl));
				//create Tag
				PetTags_SubClass tag=new PetTags_SubClass();
				tag.setId(Integer.parseInt(tid));
				tag.setName(tname);
				petPayload.setTags(Arrays.asList(tag));
				petPayload.setStatus(status);
					
		
		PetEndpoint.createPet(petPayload);


		}
	
	@Test(priority=2,dataProvider="PetId",dataProviderClass=DataProviderS.class)
	public void deletePet(String petid)
	{
		logger.info("=======Deleting the pet===========");
		
		PetEndpoint.deletePet(Integer.parseInt(petid));
		
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
