package main.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Delivery {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deliveryNum;
	private Date deliveyDate;
	private int orderNum;
	private int driverId;
	public int getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(int deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	public Date getDeliveyDate() {
		return deliveyDate;
	}
	public void setDeliveyDate(Date deliveyDate) {
		this.deliveyDate = deliveyDate;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public Delivery(int deliveryNum, Date deliveyDate, int orderNum, int driverId) {
		super();
		this.deliveryNum = deliveryNum;
		this.deliveyDate = deliveyDate;
		this.orderNum = orderNum;
		this.driverId = driverId;
	}
	public Delivery() {
		super();
	}
	
	
	
}
