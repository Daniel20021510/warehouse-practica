package org.example.repositories;

import org.example.models.Staff;
import org.example.models.StaffStaffTypeRelation;
import org.example.models.StaffType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface StaffStaffTypeRelationRepository extends CrudRepository<StaffStaffTypeRelation, Integer> {
    @Modifying
    @Query("UPDATE StaffStaffTypeRelation r SET r.staffType = :staffType, r.staff = :staff WHERE r.id = :id")
    void update(@Param(value = "id") int id, @Param(value = "staffType") StaffType staffType, @Param(value = "staff") Staff staff);
}
