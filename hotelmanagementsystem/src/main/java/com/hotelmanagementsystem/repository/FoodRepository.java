package com.hotelmanagementsystem.repository;

import com.hotelmanagementsystem.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    // Custom query methods (if needed) can be added here
}
