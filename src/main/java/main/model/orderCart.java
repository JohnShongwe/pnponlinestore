package main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderCart")
public class orderCart 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderCartNum;
	 private int orderNum ;
	 private String product_code;
	 private String product_name;
	 private int quantity;
	 private float price;
	 private String user_email;
	 private String image;
	 
	 
	 
	public int getOrderCartNum() {
		return orderCartNum;
	}
	public void setOrderCartNum(int orderCartNum) {
		this.orderCartNum = orderCartNum;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	public String getUser_image() {
		return image;
	}
	public void setUser_image(String image) {
		this.image = image;
	}
	
	
	public orderCart(int orderCartNum, int orderNum, String product_code, String product_name, int quantity,
			float price, String user_email, String image) {
		super();
		this.orderCartNum = orderCartNum;
		this.orderNum = orderNum;
		this.product_code = product_code;
		this.product_name = product_name;
		this.quantity = quantity;
		this.price = price;
		this.user_email = user_email;
		this.image = image;
		
	}
	public orderCart() {
		super();
	} 
}