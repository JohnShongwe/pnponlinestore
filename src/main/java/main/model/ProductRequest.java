package main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductRequest {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestID;
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
	private String Message;
	public ProductRequest(int requestID, String message) {
		super();
		this.requestID = requestID;
		Message = message;
	}
	public ProductRequest() {
		super();
	}
	
	
}
