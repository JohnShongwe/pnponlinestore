package main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.orderCart;


@Repository //Mark this interface as a Repository
public interface CartProductRepository  extends CrudRepository <orderCart, Integer>
{

}
