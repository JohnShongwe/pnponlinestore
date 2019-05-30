package main.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {

	
	@Id
	private int productCode;
	private String productName;
	private String productDescription;
	private float productVolume;
	private String productVolumeType;
	private Date productExpDate;
	private String	productQuantity;
	
	
	
	
	
	public Inventory() {
		super();
	}
	public Inventory(int productCode, String productName, String productDescription, float productVolume,
			String productVolumeType, Date productExpDate, String productQuantity) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productVolume = productVolume;
		this.productVolumeType = productVolumeType;
		this.productExpDate = productExpDate;
		this.productQuantity = productQuantity;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public float getProductVolume() {
		return productVolume;
	}
	public void setProductVolume(float productVolume) {
		this.productVolume = productVolume;
	}
	public String getProductVolumeType() {
		return productVolumeType;
	}
	public void setProductVolumeType(String productVolumeType) {
		this.productVolumeType = productVolumeType;
	}
	public Date getProductExpDate() {
		return productExpDate;
	}
	public void setProductExpDate(Date productExpDate) {
		this.productExpDate = productExpDate;
	}
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	

}
