package main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.CustomerInfo;
import main.model.Order;
import main.model.User;
import main.repository.CustomerInfoRepository;

@Service //Marks the class as a Service
public class CustomerInfoService {

	
	@Autowired  //@Autowired  marks the field as Autowired, meaning you don't need the setter method
	public CustomerInfoRepository customerInfoRepository; //(e.g private  CustomerInfoRepository customerInfoRepository = new CustomerInfoRepositoryImpl())
	
	
	
	
	
	public ArrayList<CustomerInfo> viewCustomerInfo(String user_email)
	{
		return customerInfoRepository.viewByCustomerEmail(user_email);
	}

	
	
	
	
	public void AddCustomerInfo(CustomerInfo customerInfo) {
		
		
		customerInfoRepository.save(customerInfo);
		
	}
	
	
	public void UpdateCustomerInfo(int custNumber, CustomerInfo customerInfo) 
	{

		customerInfoRepository.save(customerInfo);
	
	}

	
}
