package main.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.model.User;
import main.model.items;
import main.model.product;


@Repository //Mark this interface as a Repository
public interface ProductRepository  extends CrudRepository <product, Integer>
{

	//@Query lets you generate your own query instead of using the one from the CrudRepository
	@Query("SELECT p FROM product p WHERE p.productCategoryCode = :productCategoryCode")
	public ArrayList<product> viewByCategoryCode(@Param("productCategoryCode") String productCategoryCode);
	

}
