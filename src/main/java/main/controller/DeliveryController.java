package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.Delivery;
import main.model.Driver;
import main.service.DeliveryService;

@RestController //Marks the class as a Rest controller
public class DeliveryController {

	
	
	@Autowired //marks the field as Autowired, meaning you don't need the setter method
	public DeliveryService deliveryService; //(e.g DeliveryService deliveryService = new UserServiceImpl())
	
	
	@RequestMapping("/GetDelivery")
	public List<Delivery> getDelivery() 
	{
		return deliveryService.getDelivery();
	}
	
	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
	@RequestMapping(method = RequestMethod.POST,value = "/ProcessDelivery")
	public void addDelivery(@RequestBody Delivery delivery)
	{//@RequestBody used to bind the HTTP request body with an object in method parameter
		//Meaning it converts the body of HTTP request to objects
		
		
		deliveryService.AddDelivery(delivery);
		
		
	}
	
}
