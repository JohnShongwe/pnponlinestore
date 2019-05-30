package main.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.solr.core.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.model.orderCart;
import main.service.OrderCartService;

@RestController //Marks the class as a RestController
public class OrderCartController {
	
	@Autowired //marks the field as Autowired, meaning you don't need the setter method
	private OrderCartService orderCartService;  //(e.g private UserService userService = new UserServiceImpl())
	
	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
	@RequestMapping(method = RequestMethod.POST,value = "/InsertCart")
	public void AddCart(@RequestBody orderCart orderCarts)
	{//@RequestBody used to bind the HTTP request body with an object in method parameter
		//Meaning it converts the body of HTTP request to objects
	
			orderCartService.AddCart(orderCarts);
	
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/UpdateCart/{orderCartNum}")
	public void updatecart (@RequestBody  orderCart orderCarts, @PathVariable int orderCartNum)
	{//@PathVariable Identifies the path of the incoming data
		
		orderCartService.updatecart(orderCartNum, orderCarts);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/DeleteCart/{orderCartNum}")
	public void deletecart(@PathVariable int orderCartNum)
	{
		orderCartService.deletecart(orderCartNum);
	}
	
}
