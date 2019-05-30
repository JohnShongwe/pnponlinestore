package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.CustomerInfo;
import main.service.CustomerInfoService;


@RestController//Marks the class as a Rest controller
public class CustomerInfoController {
	
	

	@Autowired //marks the field as Autowired, meaning you don't need the setter method
	private CustomerInfoService customerInfoService; //(e.g private UserService userService = new UserServiceImpl())
	
	
	
	
	
	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
	@RequestMapping(method = RequestMethod.POST,value = "/InsertCustomerInfo")
	public void AddCustomerInfo(@RequestBody CustomerInfo customerInfo)
	{//@RequestBody used to bind the HTTP request body with an object in method parameter
		//Meaning it converts the body of HTTP request to objects
		
		
		customerInfoService.AddCustomerInfo(customerInfo);
		
		
	}
	
	
	@RequestMapping(method = RequestMethod.PUT,value = "/UpdateCustomerInfo/{custNumber}")
	public void UpdateCustomerInfo (@RequestBody CustomerInfo customerInfo, @PathVariable int custNumber)
	{//@PathVariable Identifies the path of the incoming data
		
		customerInfoService.UpdateCustomerInfo(custNumber, customerInfo);
		
	}
	
	
}
