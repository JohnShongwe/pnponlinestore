package main.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.orderCart;
import main.repository.CartProductRepository;
import main.repository.CustomerInfoRepository;
import main.repository.OrderCartRepository;

@Service //Marks the class as a Service
public class OrderCartService {

	
	@Autowired  //@Autowired  marks the field as Autowired, meaning you don't need the setter method
	public OrderCartRepository orderCartRepository; //(e.g  CustomerInfoRepository customerInfoRepositorye = new CustomerInfoRepositoryImpl())
	
	@Autowired
	public CartProductRepository cartProductRepository;
	
	
	//View Cart Based on the logged in user
	public ArrayList<orderCart> viewOrderCart(String user_email)
	{
		return orderCartRepository.viewByUserId(user_email);
	}
	
	
	//Customer Adding products to cart
	public void AddCart(orderCart orderCarts) {
		
		
		cartProductRepository.save(orderCarts);
		
	}
	
	//Update the cart after Checking out
	public void updatecart(int orderCartNum, orderCart orderCarts)
	{
		
		cartProductRepository.save(orderCarts);
		
	}
	
	
	public void deletecart(int orderCartNum) 
	{
		
		cartProductRepository.delete(orderCartNum);
		
	}
	
}
