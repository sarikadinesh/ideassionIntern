package com.hotelmanagementsystem.service;

import com.hotelmanagementsystem.model.User;
import com.hotelmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create or Update a User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Retrieve all Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a User by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Delete a User by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Update a User
    public User updateUser(Long id, User user) {
        Optional<User> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            // Update the fields of the existing user
            existingUser.setName(user.getName()); // Example: Update the name
            existingUser.setRole(user.getRole()); // Example: Update the role

            // Save the updated user back to the database
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }
}
