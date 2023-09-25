package org.example.controllers;

import org.example.DTOs.StaffTypeDTO;
import org.example.services.StaffTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/StaffTypes")
public class StaffTypeController {

    @Autowired
    private StaffTypeService staffTypeService;

    @GetMapping("/{id}")
    StaffTypeDTO getById(@PathVariable int id) throws Throwable {
        return (StaffTypeDTO) staffTypeService.findStaffType(id).orElseThrow(() -> HttpClientErrorException.create(HttpStatus.NOT_FOUND, "not found", null, null, null));
    }

    @GetMapping("")
    Iterable<StaffTypeDTO> getAll() {
        return staffTypeService.findStaffTypes();
    }

    @PostMapping("")
    StaffTypeDTO create(@RequestBody StaffTypeDTO staffType) {
        return staffTypeService.register(staffType);
    }

    @DeleteMapping("/{id}")
    void dalete(@PathVariable Integer id) {
        staffTypeService.expel(id);
    }

    @PutMapping("/{id}")
    StaffTypeDTO update(@RequestBody StaffTypeDTO staffType, @PathVariable int id) {
        return staffTypeService.update(staffType, id);
    }

}