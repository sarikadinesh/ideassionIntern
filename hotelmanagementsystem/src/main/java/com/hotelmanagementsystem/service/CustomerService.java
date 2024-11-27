package com.hotelmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagementsystem.model.Customer;
import com.hotelmanagementsystem.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Create or Update a Customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Retrieve all Customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Retrieve a Customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Delete a Customer by ID
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // Update Customer by ID
    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);

        if (existingCustomer.isPresent()) {
            Customer updatedCustomer = existingCustomer.get();

            // Update fields as needed
            updatedCustomer.setCustomerName(customer.getCustomerName());
            updatedCustomer.setOrderStatus(customer.getOrderStatus());
            updatedCustomer.setPaymentStatus(customer.getPaymentStatus());
            updatedCustomer.setUser(customer.getUser());  // Update the user, if necessary

            return customerRepository.save(updatedCustomer);  // Save the updated customer
        } else {
            throw new RuntimeException("Customer not found with id " + id); // Customer not found
        }
    }
}
