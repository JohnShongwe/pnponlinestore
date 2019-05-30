package main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Driver {

	@Id
	private int driverId;
	private String driverStatus;
	private String license_code;
	private String license_exp_date;
	
	
	
	public Driver() {
		super();
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	public String getDriverStatus() {
		return driverStatus;
	}
	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}
	public String getLicense_code() {
		return license_code;
	}
	public void setLicense_code(String license_code) {
		this.license_code = license_code;
	}
	public String getLicense_exp_date() {
		return license_exp_date;
	}
	public void setLicense_exp_date(String license_exp_date) {
		this.license_exp_date = license_exp_date;
	}
	public Driver(int driverId,  String driverStatus, String license_code, String license_exp_date) {
		super();
		this.driverId = driverId;
	
		this.driverStatus = driverStatus;
		this.license_code = license_code;
		this.license_exp_date = license_exp_date;
	}


}

