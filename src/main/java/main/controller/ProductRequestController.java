package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import main.model.ProductRequest;
import main.service.ProductRequestService;


@RestController
public class ProductRequestController {

	
	@Autowired
	private ProductRequestService productRequestService; 
	
	@RequestMapping("/GetMessage")
	public List<ProductRequest> getRequest() 
	{
		return productRequestService.getRequest();
	}
	
	
	
	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
		@RequestMapping(method = RequestMethod.POST,value = "/SendMessage")
		public void SendMessage(@RequestBody ProductRequest productRequest)
		{//@RequestBody used to bind the HTTP request body with an object in method parameter
			//Meaning it converts the body of HTTP request to objects
			
			
			productRequestService.SendMessage(productRequest);
			System.out.println( "dvchjdv");
			  
		}
		
}
