package main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import main.model.product;
import main.service.ProductService;


@RestController   //Marks the class as a Rest controller
public class ProductController {

	
	 
	@Autowired  //@Autowired  marks the field as Autowired, meaning you don't need the setter method
	private ProductService productService; //(e.g private UserService userService = new UserServiceImpl())
	
	@RequestMapping("/GetProducts")
	public List<product> getAllproducts() 
	{
		return productService.getAllproducts();
	}
	
	
	
	
	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
	@RequestMapping(method = RequestMethod.POST,value = "/InsertProducts")
	public void AddProduct(@RequestBody product products)
	{//@RequestBody used to bind the HTTP request body with an object in method parameter
		//Meaning it converts the body of HTTP request to objects
		
		productService.AddProduct(products);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/UpdateProduct/{id}")
	public void updateProduct(@RequestBody product products, @PathVariable int id)
	{
		
		productService.updateProduct(id, products);
		
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/DeleteProduct/{id}")
	public void deleteProduct(@PathVariable int id)
	{//@PathVariable Identifies the path of the incoming data
		productService.deleteProduct(id);
	}
	
	
	@RequestMapping(value = "/GetAllProducts/{productCategoryCode}", method = RequestMethod.GET)
	public ArrayList<product> getProdutcs(@PathVariable String productCategoryCode)

	{
		ArrayList<product> listProduct = productService.ViewProductInfo(productCategoryCode);
	 
		System.out.println( listProduct);
		
	return listProduct;
	}
	
	
	
	
	
}
