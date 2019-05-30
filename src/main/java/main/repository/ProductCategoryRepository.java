package main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.ProductCategory;

@Repository //Mark this interface as a Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, String>{
	

}
