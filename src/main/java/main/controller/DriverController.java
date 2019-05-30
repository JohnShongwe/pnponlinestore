package main.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.Driver;
import main.model.orderCart;
import main.service.DriverService;

@RestController //Marks the class as a Rest controller
public class DriverController {

	@Autowired //marks the field as Autowired, meaning you don't need the setter method
	public DriverService driverService; //(e.g DeliveryService deliveryService = new UserServiceImpl())
	
	@RequestMapping("/GetDriver")
	public List<Driver> getDriver() 
	{
		return driverService.getdrivers();
	}
	
	
	
	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
	@RequestMapping(method = RequestMethod.POST,value = "/AddDriver")
	public void AddDriver(@RequestBody Driver driver)
	{
		
		driverService.AddDriver(driver);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/UpdateDriver/{driverId}")
	public void updatecart (@RequestBody   Driver driver, @PathVariable int driverId)
	{//@RequestBody used to bind the HTTP request body with an object in method parameter
		//Meaning it converts the body of HTTP request to objects
		//@PathVariable Identifies the path of the incoming data
		
		
		driverService.updateDriver(driverId, driver);
		
	}
	
	
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/DeleteDriver/{driverId}")
	public void deleteDriver(@PathVariable int driverId)
	{
		driverService.deleteDriver(driverId);
	}
	
	

	
}
