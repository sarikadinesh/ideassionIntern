package com.hotelmanagementsystem.repository;

import com.hotelmanagementsystem.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    // Custom query methods can be added if needed
}
