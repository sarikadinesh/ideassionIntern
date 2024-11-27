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

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }

    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public Optional<Orders> updateOrder(Long id, Orders updatedOrder) {
        return ordersRepository.findById(id).map(existingOrder -> {
            existingOrder.setCustomer(updatedOrder.getCustomer());
            existingOrder.setChef(updatedOrder.getChef());
            existingOrder.setServer(updatedOrder.getServer());
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
            existingOrder.setOrderStatus(updatedOrder.getOrderStatus());
            existingOrder.setPaymentStatus(updatedOrder.getPaymentStatus());
            return ordersRepository.save(existingOrder);
        });
    }

    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }

    public void deleteAllOrders() {
        ordersRepository.deleteAll();
    }
}
