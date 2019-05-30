package main.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.Driver;

@Repository //Mark this interface as a Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {

}
