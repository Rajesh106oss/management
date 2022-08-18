package com.example.RestaurantManagement.Controller;


import com.example.RestaurantManagement.Repository.CustomerRepository;
import com.example.RestaurantManagement.Validator.CreateCustomerInfo;
import com.example.RestaurantManagement.Validator.UpdateCustomerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomerInfo customerInfo) {
        var customer = customerRepository.createCustomer(customerInfo);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/customers/customerId")
    public ResponseEntity<?> updateCustomer(@RequestBody UpdateCustomerInfo customerInfo) {
        var customer = customerRepository.updateCustomer(customerInfo);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<?> findCustomer(@PathVariable Integer customerId) {
        return customerRepository.getCustomerById(customerId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer customerId) {
        return customerRepository.deleteCustomer(customerId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}