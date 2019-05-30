package main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.ProductRequest;

@Repository
public interface ProductRequestRepository extends CrudRepository<ProductRequest, Integer> {

}
