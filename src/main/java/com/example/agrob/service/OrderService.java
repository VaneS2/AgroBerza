package com.example.agrob.service;



import com.example.agrob.model.Naracka;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public List<Naracka> findAll();
    public Naracka editOrderById(Long id, Naracka naracka);

    public List<Naracka> findAllByOrderedByUserId(Long userId);

    public List<Naracka> findAllByOrderToUserId(Long userId);

    public List<Naracka> findAllByProduct(Long id);

    public void deleteById(Long id);

    public Optional<Naracka> findById(Long id);
    public void removeProductFromOrder(Long productId, Long orderId);
    public Naracka addOrder(Naracka naracka);
}
