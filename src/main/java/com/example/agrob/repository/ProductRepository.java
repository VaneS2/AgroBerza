package com.example.agrob.repository;


import com.example.agrob.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteById(Long id);

    /*@Query("SELECT p from Products p where upper(name)  like "%1%" ")*/
    List<Product> findProductByNameContainingIgnoreCase(String name);

    List<Product> findAllByOwnerId(Long ownerId);
}
