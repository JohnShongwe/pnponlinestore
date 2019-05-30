package main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "payment")
public class Payment
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PaymentNum ;
	private String cardNumber;
	private String  cardType;
	private int cvv2;
	public Payment() {
		super();
	}
	public Payment(int paymentNum, String cardNumber, String cardType, int cvv2, String expDate, int orderNum,
			String user_email) {
		super();
		PaymentNum = paymentNum;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.cvv2 = cvv2;
		this.expDate = expDate;
		this.orderNum = orderNum;
		this.user_email = user_email;
	}
	public int getPaymentNum() {
		return PaymentNum;
	}
	public void setPaymentNum(int paymentNum) {
		PaymentNum = paymentNum;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getCvv2() {
		return cvv2;
	}
	public void setCvv2(int cvv2) {
		this.cvv2 = cvv2;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	private String expDate;
	private int orderNum;
	private String user_email;
	
	

}
