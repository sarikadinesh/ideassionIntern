package com.hotelmanagementsystem.service;

import com.hotelmanagementsystem.model.Orders;
import com.hotelmanagementsystem.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    // Get all orders
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    // Get an order by ID
    public Optional<Orders> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }

    // Create a new order
    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    // Update an existing order
    public Optional<Orders> updateOrder(Long id, Orders order) {
        return ordersRepository.findById(id)
                .map(existingOrder -> {
                    existingOrder.setCustomer(order.getCustomer());
                    existingOrder.setChef(order.getChef());
                    existingOrder.setServer(order.getServer());
                    existingOrder.setOrderDate(order.getOrderDate());
                    existingOrder.setOrderStatus(order.getOrderStatus());
                    existingOrder.setPaymentStatus(order.getPaymentStatus());
                    return ordersRepository.save(existingOrder);
                });
    }

    // Delete an order by ID
    public boolean deleteOrder(Long id) {
        if (ordersRepository.existsById(id)) {
            ordersRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
