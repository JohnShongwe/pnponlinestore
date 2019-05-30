package main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Driver;
import main.model.Order;
import main.repository.CustomerInfoRepository;
import main.repository.OrderRepository;

@Service //Marks the class as a Service
public class OrderService 
{

	@Autowired //@Autowired  marks the field as Autowired, meaning you don't need the setter method
	public OrderRepository orderRepository; //(e.g private  CustomerInfoRepository customerInfoRepository = new CustomerInfoRepositoryImpl())
	
	

	public void makeOrder(Order Order) {
		
		
		orderRepository.save(Order);
	}
		
	
	public List<Order> viewOrder()
	{
		List<Order> orders = new ArrayList<>();
		orderRepository.findAll()
		.forEach(orders::add);
		return orders;
	}
	
	
	public void UpdateOrder(int orderNum, Order order) 
	{

		orderRepository.save(order);
	}
	
		
}
