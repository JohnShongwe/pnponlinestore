package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.model.items;
import main.service.ItemService;




@RestController //Marks the class as a RestController
public class ItemController 
{

	@Autowired //marks the field as Autowired, meaning you don't need the setter method
	private ItemService itemService;
	
	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
	@RequestMapping("/GetItems")
	public List<items> getAllItems()
	{
		return itemService.getAllItems();
	}
	
}
