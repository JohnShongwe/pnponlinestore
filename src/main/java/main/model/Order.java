package main.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "customerOrder")
public class Order {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderNum;
	private Date orderdate;
	public Order() {
		super();
	}
	public Order(int orderNum, Date orderdate, float orderTotalprice, String orderStatus, int user_id) {
		super();
		this.orderNum = orderNum;
		this.orderdate = orderdate;
		this.orderTotalprice = orderTotalprice;
		this.orderStatus = orderStatus;
		this.user_id = user_id;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public float getOrderTotalprice() {
		return orderTotalprice;
	}
	public void setOrderTotalprice(float orderTotalprice) {
		this.orderTotalprice = orderTotalprice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	private float orderTotalprice;
	private String orderStatus;
	private int user_id;
	
	
}
