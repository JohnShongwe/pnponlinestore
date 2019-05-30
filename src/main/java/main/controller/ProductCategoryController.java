package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.ProductCategory;
import main.model.orderCart;
import main.service.ProductCategoryService;

@RestController  //Marks the class as a Rest controller
public class ProductCategoryController
{


	@Autowired //@Autowired  marks the field as Autowired, meaning you don't need the setter method
	private ProductCategoryService productCategoryService;  //(e.g private UserService userService = new UserServiceImpl())
	
	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
	@RequestMapping("/GetProductCategory")
	public List<ProductCategory> getProductCategory()
	{
		return productCategoryService.getProductCategory();
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.POST,value = "/InsertCategory")
	public void AddCategory(@RequestBody ProductCategory productCategor)
	{//@RequestBody used to bind the HTTP request body with an object in method parameter
		//Meaning it converts the body of HTTP request to objects
		
		
		productCategoryService.AddCategory(productCategor);
		
		
	}
	
}
