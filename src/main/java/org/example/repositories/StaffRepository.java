package org.example.repositories;

import org.example.models.Staff;
import org.example.models.StaffStaffTypeRelation;
import org.example.models.StaffType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Integer> {
    @Modifying
    @Query("UPDATE Staff s SET s.firstName = :firstName, s.lastName = :lastName, s.middleName = :middleName, s.staffType = :staffType WHERE s.id = :id")
    void update(@Param(value = "id") int id, @Param(value = "firstName") String firstName, @Param(value = "lastName") String lastName, @Param(value = "middleName") String middleName, @Param(value = "type") Set<StaffStaffTypeRelation> staffType);
}
