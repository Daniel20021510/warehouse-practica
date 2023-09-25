package org.example.services;

import org.example.DTOs.WarehouseDTO;
import org.example.DTOs.ProductDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface WarehouseService<ID> {

    WarehouseDTO register(WarehouseDTO warehouse);

    WarehouseDTO update(WarehouseDTO warehouse, int id);

    void expel(WarehouseDTO warehouse);

    void expel(ID id);

    Optional<WarehouseDTO> findWarehouse(ID id);

    List<WarehouseDTO> findWarehouses();
    Set<ProductDTO> genConsinmentNoteWithMinProducts();
}
