package main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pruductCategory")
public class ProductCategory 
{
	
	@Id
	private String productCategoryCode;
	private String categotyDescription;
	
	
	
	public ProductCategory() {
		super();
	}
	public ProductCategory(String productCategoryCode, String categotyDescription) {
		super();
		this.productCategoryCode = productCategoryCode;
		this.categotyDescription = categotyDescription;
	}
	public String getProductCategoryCode() {
		return productCategoryCode;
	}
	public void setProductCategoryCode(String productCategoryCode) {
		this.productCategoryCode = productCategoryCode;
	}
	public String getCategotyDescription() {
		return categotyDescription;
	}
	public void setCategotyDescription(String categotyDescription) {
		this.categotyDescription = categotyDescription;
	}
	
	
	
}
