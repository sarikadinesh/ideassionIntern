package com.hotelmanagementsystem.repository;

import com.hotelmanagementsystem.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
