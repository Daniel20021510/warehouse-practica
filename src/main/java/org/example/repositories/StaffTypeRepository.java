package org.example.repositories;

import org.example.models.StaffType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StaffTypeRepository extends CrudRepository<StaffType, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE StaffType t SET t.staffTypeName = :staffTypeName WHERE t.id = :id")
    void update(@Param(value = "id") int id, @Param(value = "staffTypeName") String staffTypeName);
}
