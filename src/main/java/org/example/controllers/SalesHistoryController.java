package org.example.controllers;

import org.example.DTOs.SalesHistoryDTO;
import org.example.services.SalesHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/saleshistories")
public class SalesHistoryController {

    @Autowired
    private SalesHistoryService salesHistoryService;

    @GetMapping("/{id}")
    SalesHistoryDTO getById(@PathVariable int id) throws Throwable {
        return (SalesHistoryDTO) salesHistoryService.findSalesHistory(id).orElseThrow(() -> HttpClientErrorException.create(HttpStatus.NOT_FOUND, "not found", null, null, null));
    }

    @GetMapping("")
    Iterable<SalesHistoryDTO> getAll() {
        return salesHistoryService.findSalesHistorys();
    }

    @PostMapping("")
    SalesHistoryDTO create(@RequestBody SalesHistoryDTO salesHistory) {
        return salesHistoryService.register(salesHistory);
    }

    @DeleteMapping("/{id}")
    void dalete(@PathVariable Integer id) {
        salesHistoryService.expel(id);
    }

    @PutMapping("/{id}")
    SalesHistoryDTO update(@RequestBody SalesHistoryDTO salesHistory, @PathVariable int id) {
        return salesHistoryService.update(salesHistory, id);
    }

}