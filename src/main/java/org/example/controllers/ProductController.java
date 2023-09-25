package org.example.controllers;

import org.example.DTOs.ProductDTO;
import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    ProductDTO getById(@PathVariable int id) throws Throwable {
        return (ProductDTO) productService.findProduct(id).orElseThrow(() -> HttpClientErrorException.create(HttpStatus.NOT_FOUND, "not found", null, null, null));
    }

    @GetMapping("")
    Iterable<ProductDTO> getAll() {
        return productService.findProducts();
    }

    @PostMapping("")
    ProductDTO create(@RequestBody ProductDTO product) {
        return productService.register(product);
    }

    @DeleteMapping("/{id}")
    void dalete(@PathVariable Integer id) {
        productService.expel(id);
    }

    @PutMapping("/{id}")
    ProductDTO update(@RequestBody ProductDTO product, @PathVariable int id) {
        return productService.update(product, id);
    }

}
