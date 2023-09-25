package org.example.services;

import org.example.DTOs.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService<ID> {

    ProductDTO register(ProductDTO product);

    ProductDTO update(ProductDTO product, int id);

    void expel(ProductDTO product);

    void expel(ID id);

    Optional<ProductDTO> findProduct(ID id);

    List<ProductDTO> findProducts();
}
