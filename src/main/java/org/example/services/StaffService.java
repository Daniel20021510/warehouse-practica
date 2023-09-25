package org.example.services;

import org.example.DTOs.StaffDTO;

import java.util.List;
import java.util.Optional;

public interface StaffService<ID> {

    StaffDTO register(StaffDTO staff);

    StaffDTO update(StaffDTO staff, int id);

    void expel(StaffDTO staff);

    void expel(ID id);

    Optional<StaffDTO> findStaff(ID id);

    List<StaffDTO> findStaffs();
}


