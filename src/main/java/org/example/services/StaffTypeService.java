package org.example.services;

import org.example.DTOs.StaffTypeDTO;

import java.util.List;
import java.util.Optional;

public interface StaffTypeService<ID> {

    StaffTypeDTO register(StaffTypeDTO staffType);

    StaffTypeDTO update(StaffTypeDTO staffType, int id);

    void expel(StaffTypeDTO staffType);

    void expel(ID id);

    Optional<StaffTypeDTO> findStaffType(ID id);

    List<StaffTypeDTO> findStaffTypes();
}


