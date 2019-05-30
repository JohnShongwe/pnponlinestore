package main.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.items;
import main.repository.CustomerInfoRepository;
import main.repository.ItemRepository;

@Service //Marks the class as a Service
public class ItemService
{

	@Autowired  //@Autowired  marks the field as Autowired, meaning you don't need the setter method
	public ItemRepository itemRepository;  //(e.g private  CustomerInfoRepository customerInfoRepository= new CustomerInfoRepositoryImpl())
	
	
	//List All the products
	public List<items> getAllItems()
	{
		
		List<items> item = new ArrayList<>();
		itemRepository.findAll()
		.forEach(item::add);
		return item;
		
	}
	
	
	
}
