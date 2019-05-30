package main.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class product {
	
	
	
	@Id
	private int productCode;
	private String productName;
	private String productDescription;
	private float  productPrice;
	private float productVolume;
	private String productVolumeType;
	private Date productExpDate;
	private String	productCategoryCode;
	private String	brandCode;
	private String productImage;
	
	
	
	
	
	
	
	
	
	
	
	public product() {
		super();
	}
	public product(int productCode, String productName, String productDescription, float productPrice,
			float productVolume, String productVolumeType, Date productExpDate, String productCategoryCode,
			String brandCode, String productImage) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productVolume = productVolume;
		this.productVolumeType = productVolumeType;
		this.productExpDate = productExpDate;
		this.productCategoryCode = productCategoryCode;
		this.brandCode = brandCode;
		this.productImage = productImage;
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
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
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
	public String getProductCategoryCode() {
		return productCategoryCode;
	}
	public void setProductCategoryCode(String productCategoryCode) {
		this.productCategoryCode = productCategoryCode;
	}
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	

	
	
}
