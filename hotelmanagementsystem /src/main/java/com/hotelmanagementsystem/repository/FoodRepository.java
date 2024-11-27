package com.hotelmanagementsystem.repository;

import com.hotelmanagementsystem.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
