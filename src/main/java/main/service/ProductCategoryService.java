package main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.ProductCategory;
import main.model.User;
import main.model.orderCart;
import main.repository.CustomerInfoRepository;
import main.repository.ProductCategoryRepository;


@Service //Marks the class as a Service
public class ProductCategoryService {

	@Autowired //@Autowired  marks the field as Autowired, meaning you don't need the setter method
	public ProductCategoryRepository productCategoryRepository; //(e.g private  CustomerInfoRepository CustomerInfoRepositoryImpl = new UserServiceImpl())
	
	
	//List all the product categories
	public List<ProductCategory> getProductCategory()
	{
		
		List<ProductCategory> productCategory = new ArrayList<>();
		productCategoryRepository.findAll()
		.forEach(productCategory::add);
		
		return  productCategory;
		
	}
	
	
	
	
	//Add a new Category
	public void AddCategory(ProductCategory productCategory) {
		
		
		productCategoryRepository.save(productCategory);
		
	}

	

}
