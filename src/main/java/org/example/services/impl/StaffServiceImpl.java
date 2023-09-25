package org.example.services.impl;

import org.example.DTOs.StaffDTO;
import org.example.models.Staff;
import org.example.models.StaffStaffTypeRelation;
import org.example.repositories.StaffRepository;
import org.example.services.StaffService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StaffServiceImpl implements StaffService<Integer> {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StaffDTO register(StaffDTO staff) {
        return modelMapper.map(
                staffRepository.save(modelMapper.map(staff, Staff.class)),
                StaffDTO.class
        );
    }

    @Override
    public StaffDTO update(StaffDTO staff, int id) {
        staffRepository.update(id, staff.getFirstName(), staff.getLastName(), staff.getMiddleName(), staff.getStaffType());
        return modelMapper.map(this.findStaff(id), StaffDTO.class);
    }

    @Override
    public void expel(StaffDTO staff) {
        staffRepository.delete(modelMapper.map(staff, Staff.class));
    }

    @Override
    public void expel(Integer id) {
        staffRepository.deleteById(id);
    }


    @Override
    public Optional<StaffDTO> findStaff(Integer id) {
        return Optional.ofNullable(modelMapper.map(staffRepository.findById(id), StaffDTO.class));
    }

    @Override
    public List<StaffDTO> findStaffs() {
        Iterable<Staff> staffs = staffRepository.findAll();
        List<StaffDTO> staffsDTO = new ArrayList<>();
        for (Staff staff: staffs) {
            staffsDTO.add(modelMapper.map(staff, StaffDTO.class));
        }
        return staffsDTO;
    }
}