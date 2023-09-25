package org.example.repositories;

import org.example.models.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Modifying
    @Query("UPDATE Product p SET p.name = :name WHERE p.id = :id")
    void update(@Param(value = "id") int id, @Param(value = "name") String name);
}
