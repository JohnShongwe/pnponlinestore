package main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import main.model.ProductRequest;
import main.repository.ProductRequestRepository;

@Service
public class ProductRequestService {

	
	@Autowired
	public ProductRequestRepository productRequestRepository;
	
	public List<ProductRequest> getRequest()
	{
		List<ProductRequest> productRequest = new ArrayList<>();
		productRequestRepository.findAll()
		.forEach(productRequest::add);
		
		return productRequest;
		
		
	}
	
public void SendMessage(ProductRequest productRequest) 
{
		
	productRequestRepository.save(productRequest);
			
		}
	
}
