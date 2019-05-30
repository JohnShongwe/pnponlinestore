package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.Payment;

import main.service.PaymentService;



@RestController //Marks the class as a RestController
public class PaymentController {

	
	

	@Autowired //@Autowired  marks the field as Autowired, meaning you don't need the setter method
	private PaymentService paymentService; //(e.g private UserService userService = new UserServiceImpl())
	
	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
	@RequestMapping(method = RequestMethod.POST, value = "/processPayment")
	public void ProcessPayment(@RequestBody Payment payment)
	{//@RequestBody used to bind the HTTP request body with an object in method parameter
		//Meaning it converts the body of HTTP request to objects
		
		
	
		paymentService.ProcessPayment(payment);
		
		
		
	}
	
}
