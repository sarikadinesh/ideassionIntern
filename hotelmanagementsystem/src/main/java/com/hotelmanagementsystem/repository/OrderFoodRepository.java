package com.hotelmanagementsystem.repository;

import com.hotelmanagementsystem.model.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFoodRepository extends JpaRepository<OrderFood, Long> {
    // Custom query methods (if needed) can be added here
}
