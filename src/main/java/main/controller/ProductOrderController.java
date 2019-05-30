package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.Driver;
import main.model.Order;

import main.service.OrderService;

@RestController  //Marks the class as a Rest controller
public class ProductOrderController {

	
	@Autowired //@Autowired  marks the field as Autowired, meaning you don't need the setter method
	public OrderService orderService;  //(e.g private UserService userService = new UserServiceImpl())
	
	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
	@RequestMapping(method = RequestMethod.POST,value = "/CreateOrder")
	public void makeOrder(@RequestBody Order order)
	{
		//@RequestBody used to bind the HTTP request body with an object in method parameter
				//Meaning it converts the body of HTTP request to objects
		orderService.makeOrder(order);
		
		
	}
	
	@RequestMapping("/GetOrder")
	public List<Order> getOrders()
	
	{
		return orderService.viewOrder();
		
	}
	
	
	@RequestMapping(method = RequestMethod.PUT,value = "/UpdateOrder/{orderNum}")
	public void UpdateOrder (@RequestBody  Order order, @PathVariable int orderNum)
	{//@PathVariable Identifies the path of the incoming data
		
		orderService.UpdateOrder(orderNum, order);
		
	}
	
	
}
