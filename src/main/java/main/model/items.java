package main.model;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class items {

	

	public items() {
		super();
	}
	@Id
	private char brandCode;
	public items(char brandCode, String decription) {
		super();
		this.brandCode = brandCode;
		this.decription = decription;
	}
	private String decription;
	
	public int getId() {
		return brandCode;
	}
	public void setId(char brandCode) {
		this.brandCode = brandCode;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	
	
}
