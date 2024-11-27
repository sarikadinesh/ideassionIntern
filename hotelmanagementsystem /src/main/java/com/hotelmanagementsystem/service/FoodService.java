package com.hotelmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagementsystem.model.Food;
import com.hotelmanagementsystem.repository.FoodRepository;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    // Create or Update a Food item
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    // Retrieve all Food items
    public List<Food> getAllFoodItems() {
        return foodRepository.findAll();
    }

    // Retrieve a Food item by ID
    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    // Delete a Food item by ID
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }

    // Update a Food item by ID
    public Optional<Food> updateFood(Long id, Food food) {
        Optional<Food> existingFood = foodRepository.findById(id);
        if (existingFood.isPresent()) {
            Food updatedFood = existingFood.get();
            updatedFood.setName(food.getName());  // Update the food name
            updatedFood.setCategory(food.getCategory());  // Update the category
            return Optional.of(foodRepository.save(updatedFood));  // Save and return the updated food
        }
        return Optional.empty();  // Return empty if not found
    }
}
