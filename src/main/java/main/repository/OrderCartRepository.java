package main.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.model.orderCart;

@Repository //Mark this interface as a Repository
public interface OrderCartRepository  extends CrudRepository <orderCart, Integer> {

	//@Query lets you generate your own query instead of using the one from the CrudRepository
	@Query("SELECT o FROM orderCart o WHERE o.user_email = :user_email")
	public ArrayList<orderCart> viewByUserId(@Param("user_email") String user_email);
	
	
	
	
}
