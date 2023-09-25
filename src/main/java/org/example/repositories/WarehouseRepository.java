package org.example.repositories;

import org.example.models.Warehouse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {

    @Query("SELECT w FROM Warehouse w WHERE w.count < w.minCount")
    List<Warehouse> findAllMinThanMinCount();

    @Modifying
    @Transactional
    @Query("UPDATE Warehouse w SET w.count = :count, w.invNumber = :invNumber, w.minCount = :minCount WHERE w.id = :id")
    void update(@Param(value = "id") int id, @Param(value = "count") int count, @Param(value = "invNumber") String invNumber, @Param(value = "minCount") int minCount);
}
