package com.hotelmanagementsystem.controller;

import com.hotelmanagementsystem.model.Food;
import com.hotelmanagementsystem.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    // Create a new Food item
    @PostMapping
    public ResponseEntity<Food> createFood(@Validated @RequestBody Food food) {
        Food createdFood = foodService.saveFood(food);
        URI location = URI.create("/api/food/" + createdFood.getId());
        return ResponseEntity.created(location).body(createdFood);
    }

    // Get all Food items
    @GetMapping
    public ResponseEntity<List<Food>> getAllFoodItems() {
        return ResponseEntity.ok(foodService.getAllFoodItems());
    }

    // Get Food item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Food item by ID
    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @Validated @RequestBody Food food) {
        Optional<Food> updatedFood = foodService.updateFood(id, food);
        return updatedFood.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Food item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        if (foodService.getFoodById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
}
