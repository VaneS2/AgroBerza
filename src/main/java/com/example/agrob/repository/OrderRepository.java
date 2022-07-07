package com.example.agrob.repository;



import com.example.agrob.model.Naracka;
import com.example.agrob.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Naracka, Long> {
    List<Naracka> findNarackasByOrderedByUserId(Long orderedByUserId);

    List<Naracka> findAllByOrderToUserId(Long orderToUserId);

    List<Naracka> findAllByProducts(Product product);

    Optional<Naracka> findById(Long id);
}
