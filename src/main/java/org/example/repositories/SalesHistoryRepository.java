package org.example.repositories;

import org.example.DTOs.ProductDTO;
import org.example.DTOs.StaffDTO;
import org.example.models.Product;
import org.example.models.SalesHistory;
import org.example.models.Staff;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SalesHistoryRepository extends CrudRepository<SalesHistory, Integer> {
    @Modifying
    @Query("UPDATE SalesHistory h SET h.count = :count, h.product = :product, h.staff = :staff WHERE h.id = :id")
    void update(@Param(value = "id") int id, @Param(value = "count") int count, @Param(value = "product") ProductDTO product, @Param(value = "staff") StaffDTO staff);
}

