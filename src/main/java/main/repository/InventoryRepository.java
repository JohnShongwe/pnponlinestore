package main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.Inventory;

@Repository //Mark this interface as a Repository
public interface InventoryRepository extends CrudRepository<Inventory,Integer> {

}
