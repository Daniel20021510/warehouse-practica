package org.example.controllers;

import org.example.DTOs.WarehouseDTO;
import org.example.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/{id}")
    WarehouseDTO getById(@PathVariable int id) throws Throwable {
        return (WarehouseDTO) warehouseService.findWarehouse(id).orElseThrow(() -> HttpClientErrorException.create(HttpStatus.NOT_FOUND, "not found", null, null, null));
    }

    @GetMapping("/min")
    Iterable<WarehouseDTO> genConsinmentNoteWithMinProducts() {
        return warehouseService.genConsinmentNoteWithMinProducts();
    }

    @GetMapping("")
    Iterable<WarehouseDTO> getAll() {
        return warehouseService.findWarehouses();
    }

    @PostMapping("")
    WarehouseDTO create(@RequestBody WarehouseDTO warehouse) {
        return warehouseService.register(warehouse);
    }

    @DeleteMapping("/{id}")
    void dalete(@PathVariable Integer id) {
        warehouseService.expel(id);
    }

    @PutMapping("/{id}")
    WarehouseDTO update(@RequestBody WarehouseDTO warehouse, @PathVariable int id) {
        return warehouseService.update(warehouse, id);
    }

}