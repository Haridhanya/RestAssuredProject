package api.tests;

import java.util.Arrays;
import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import api.endpoints.PetEndpoint;
import api.payloads.Pet;
import api.payloads.PetCategory_SubClass;
import api.payloads.PetTags_SubClass;

public class PetTest {
	
	 Pet petPayload=new Pet();
	
	@BeforeTest
	public void setup()
	{
		
		//create category
		PetCategory_SubClass cat=new PetCategory_SubClass();
		cat.setId(102102102);
		cat.setName("parrot");
//		HashMap hm=new HashMap();
//		hm.put("id", 102102102);
//		hm.put("name", "parrot");
		
		//create Tag
		PetTags_SubClass tag=new PetTags_SubClass();
		tag.setId(102102102);
		tag.setName("tutu");
		
		
		petPayload.setId(102102);
		
		petPayload.setCategory(cat);
		petPayload.setName("tutu");
		
		petPayload.setPhotoUrls(Arrays.asList("https://www.shutterstock.com/image-photo/parrot-on-branch-260nw-714651400.jpg"));
		
		petPayload.setTags(Arrays.asList(tag));
		petPayload.setStatus("avaialble");
			
	}
	@Test(priority=1)
	public void createPet()
	{
	PetEndpoint.createPet(petPayload);	
	}
	
	@Test(priority=2)
	public void getPet()
	{
		PetEndpoint.getPet(petPayload.getId());
		
	}
	@Test(priority=3)
	public void updatePet()
	{
		petPayload.setName("tutuUpdated");
		PetEndpoint.updatePet(petPayload);
	}
	@Test(priority=4)
	public void deletePet()
	{
		PetEndpoint.deletePet(petPayload.getId());
	}
	

}
