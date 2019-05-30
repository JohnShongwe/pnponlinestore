package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.Inventory;
import main.service.InventoryService;



@RestController //Marks the class as a RestController
public class InventoryController {

	
	@Autowired  //marks the field as Autowired, meaning you don't need the setter method
	private InventoryService inventoryService; //(e.g DeliveryService deliveryService = new UserServiceImpl())
	
	

	@RequestMapping("/GetInventoryProducts")
	public List<Inventory> getInventoryproducts() 
	{
		return inventoryService.getInventoryproducts();
	}
	
	
	
	
	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
	@RequestMapping(method = RequestMethod.POST,value = "/InsertInventoryProducts")
	public void AddInventoryProduct(@RequestBody Inventory inventory)
	{//
		
		inventoryService.AddInventoryProduct(inventory);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/UpdateInventoryProduct/{productCode}")
	public void updateInventoryProduct(@RequestBody  Inventory inventory, @PathVariable int productCode)
	{//@PathVariable Identifies the path of the incoming data 
		
		inventoryService.updateInventoryProduct(productCode, inventory);
		
	}
	
	
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/DeleteInventoryProduct/{productCode}")
	public void deleteProduct(@PathVariable int productCode) 
	{
		inventoryService.deleteInventoryProduct(productCode);
	}
	
	
}
