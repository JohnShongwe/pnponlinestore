package main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerInfo {

	
	@Id
	private int custNumber;
	public CustomerInfo() {
		super();
	}
	public CustomerInfo(int custNumber, String user_email, String custAddress, String province, String city,
			int zip_code) {
		super();
		this.custNumber = custNumber;
		this.user_email = user_email;
		CustAddress = custAddress;
		this.province = province;
		this.city = city;
		this.zip_code = zip_code;
	}
	public int getCustNumber() {
		return custNumber;
	}
	public void setCustNumber(int custNumber) {
		this.custNumber = custNumber;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getCustAddress() {
		return CustAddress;
	}
	public void setCustAddress(String custAddress) {
		CustAddress = custAddress;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	private String user_email;
	private String CustAddress;
	private String province;
	private String city;
	private int zip_code;
	
}
