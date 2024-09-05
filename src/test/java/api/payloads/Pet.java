package api.payloads;

import java.util.List;

public class Pet {

	int id;
	PetCategory_SubClass category;
	String name;
	List<String> photoUrls;
	List<PetTags_SubClass> tags;
	String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PetCategory_SubClass getCategory() {
		return category;
	}
	public void setCategory(PetCategory_SubClass cat) {
		this.category = cat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<PetTags_SubClass> getTags() {
		return tags;
	}
	public void setTags(List<PetTags_SubClass> tag) {
		this.tags = tag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
