package org.example.services.impl;

import org.example.DTOs.ProductDTO;
import org.example.models.Product;
import org.example.repositories.ProductRepository;
import org.example.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService<Integer> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO register(ProductDTO product) {
        return modelMapper.map(
                productRepository.save(modelMapper.map(product, Product.class)),
                ProductDTO.class
        );
    }

    @Override
    public ProductDTO update(ProductDTO product, int id) {
        productRepository.update(id, product.getName());
        return modelMapper.map(this.findProduct(id), ProductDTO.class);
    }

    @Override
    public void expel(ProductDTO product) {
        productRepository.delete(modelMapper.map(product, Product.class));
    }

    @Override
    public void expel(Integer id) {
        productRepository.deleteById(id);
    }


    @Override
    public Optional<ProductDTO> findProduct(Integer id) {
        return Optional.ofNullable(modelMapper.map(productRepository.findById(id), ProductDTO.class));
    }

    @Override
    public List<ProductDTO> findProducts() {
        Iterable<Product> products = productRepository.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();
        for (Product product: products) {
            productsDTO.add(modelMapper.map(product, ProductDTO.class));
        }
        return productsDTO;
    }
}