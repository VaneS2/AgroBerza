package com.example.agrob.repository;


import com.example.agrob.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteById(Long id);

    List<Product> findProductByNameContainingIgnoreCase(String name);

    List<Product> findAllByOwnerId(Long ownerId);
}
