package org.example.services.impl;

import org.example.DTOs.StaffTypeDTO;
import org.example.models.StaffType;
import org.example.repositories.StaffTypeRepository;
import org.example.services.StaffTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffTypeServiceImpl implements StaffTypeService<Integer> {

    @Autowired
    private StaffTypeRepository staffTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StaffTypeDTO register(StaffTypeDTO StaffType) {
        return modelMapper.map(
                staffTypeRepository.save(modelMapper.map(StaffType, StaffType.class)),
                StaffTypeDTO.class
        );
    }

    @Override
    public StaffTypeDTO update(StaffTypeDTO StaffType, int id) {
        staffTypeRepository.update(id, StaffType.getStaffTypeName());
        return modelMapper.map(this.findStaffType(id), StaffTypeDTO.class);
    }

    @Override
    public void expel(StaffTypeDTO StaffType) {
        staffTypeRepository.delete(modelMapper.map(StaffType, StaffType.class));
    }

    @Override
    public void expel(Integer id) {
        staffTypeRepository.deleteById(id);
    }


    @Override
    public Optional<StaffTypeDTO> findStaffType(Integer id) {
        return Optional.ofNullable(modelMapper.map(staffTypeRepository.findById(id), StaffTypeDTO.class));
    }

    @Override
    public List<StaffTypeDTO> findStaffTypes() {
        Iterable<StaffType> StaffTypes = staffTypeRepository.findAll();
        List<StaffTypeDTO> StaffTypesDTO = new ArrayList<>();
        for (StaffType StaffType: StaffTypes) {
            StaffTypesDTO.add(modelMapper.map(StaffType, StaffTypeDTO.class));
        }
        return StaffTypesDTO;
    }
}