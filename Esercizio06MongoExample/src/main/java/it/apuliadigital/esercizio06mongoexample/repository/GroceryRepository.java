package it.apuliadigital.esercizio06mongoexample.repository;

import it.apuliadigital.esercizio06mongoexample.document.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GroceryRepository extends MongoRepository<GroceryItem, String> {

    @Query("{ 'name' : ?0 }")
    GroceryItem findByName(String name);

    @Query(value = "{category :  '?0'}", fields = "{name : 1, quantity : 1}")
    List<GroceryItem> findByCategory(String category);

    public long count();
}
