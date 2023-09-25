package org.example.services.impl;

import org.example.DTOs.ProductDTO;
import org.example.DTOs.WarehouseDTO;
import org.example.models.Product;
import org.example.models.Warehouse;
import org.example.repositories.WarehouseRepository;
import org.example.services.WarehouseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WarehouseServiceImpl implements WarehouseService<Integer> {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public WarehouseDTO register(WarehouseDTO warehouse) {
        return modelMapper.map(
                warehouseRepository.save(modelMapper.map(warehouse, Warehouse.class)),
                WarehouseDTO.class
        );
    }

    @Override
    public WarehouseDTO update(WarehouseDTO warehouse, int id) {
        warehouseRepository.update(id, warehouse.getCount(), warehouse.getInvNumber(), warehouse.getMinCount());
        return modelMapper.map(this.findWarehouse(id), WarehouseDTO.class);
    }

    @Override
    public void expel(WarehouseDTO warehouse) {
        warehouseRepository.delete(modelMapper.map(warehouse, Warehouse.class));
    }

    @Override
    public void expel(Integer id) {
        warehouseRepository.deleteById(id);
    }


    @Override
    public Optional<WarehouseDTO> findWarehouse(Integer id) {
        return Optional.ofNullable(modelMapper.map(warehouseRepository.findById(id), WarehouseDTO.class));
    }

    @Override
    public List<WarehouseDTO> findWarehouses() {
        Iterable<Warehouse> warehouses = warehouseRepository.findAll();
        List<WarehouseDTO> warehousesDTO = new ArrayList<>();
        for (Warehouse warehouse: warehouses) {
            warehousesDTO.add(modelMapper.map(warehouse, WarehouseDTO.class));
        }
        return warehousesDTO;
    }
    @Override
    public Set<ProductDTO> genConsinmentNoteWithMinProducts() {
        Set<ProductDTO> products = new HashSet<ProductDTO>();
        List<Warehouse> warehouses = warehouseRepository.findAllMinThanMinCount();
        for (Warehouse item : warehouses) {
            products.add(modelMapper.map(item.getProduct(), ProductDTO.class));
        }
        return products;
    }
}
