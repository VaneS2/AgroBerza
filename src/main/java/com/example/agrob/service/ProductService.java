package com.example.agrob.service;



import com.example.agrob.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    List<Product> findAllByOwnerId(Long id);

    Optional<Product> findById(Long id);

    List<Product> findProductByName(String name);

    void deleteById(Long id);

    Product edit(Product p);

    Product add(Product p);
}
