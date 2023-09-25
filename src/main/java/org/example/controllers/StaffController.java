package org.example.controllers;

import org.example.DTOs.StaffDTO;
import org.example.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/Staffs")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/{id}")
    StaffDTO getById(@PathVariable int id) throws Throwable {
        return (StaffDTO) staffService.findStaff(id).orElseThrow(() -> HttpClientErrorException.create(HttpStatus.NOT_FOUND, "not found", null, null, null));
    }

    @GetMapping("")
    Iterable<StaffDTO> getAll() {
        return staffService.findStaffs();
    }

    @PostMapping("")
    StaffDTO create(@RequestBody StaffDTO staff) {
        return staffService.register(staff);
    }

    @DeleteMapping("/{id}")
    void dalete(@PathVariable Integer id) {
        staffService.expel(id);
    }

    @PutMapping("/{id}")
    StaffDTO update(@RequestBody StaffDTO staff, @PathVariable int id) {
        return staffService.update(staff, id);
    }

}