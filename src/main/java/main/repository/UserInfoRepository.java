package main.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.model.User;
import main.model.orderCart;


@Repository //Mark this interface as a Repository
public interface UserInfoRepository  extends CrudRepository <User, Integer> {

	//@Query lets you generate your own query instead of using the one from the CrudRepository
	@Query("SELECT u FROM User u WHERE u.email = :email")
	public ArrayList<User> viewByUserId(@Param("email") String email);
	
}
