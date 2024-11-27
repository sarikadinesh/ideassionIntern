package com.hotelmanagementsystem.service;

import com.hotelmanagementsystem.model.OrderFood;
import com.hotelmanagementsystem.repository.OrderFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderFoodService {

    @Autowired
    private OrderFoodRepository orderFoodRepository;

    // Create or Update an Order-Food entry
    public OrderFood saveOrderFood(OrderFood orderFood) {
        return orderFoodRepository.save(orderFood);
    }

    // Retrieve all Order-Food entries
    public List<OrderFood> getAllOrderFoodEntries() {
        return orderFoodRepository.findAll();
    }

    // Retrieve an Order-Food entry by ID
    public Optional<OrderFood> getOrderFoodById(Long id) {
        return orderFoodRepository.findById(id);
    }

    // Delete an Order-Food entry by ID
    public void deleteOrderFood(Long id) {
        orderFoodRepository.deleteById(id);
    }
}
