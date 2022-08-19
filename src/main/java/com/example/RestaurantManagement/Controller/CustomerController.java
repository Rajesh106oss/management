package com.example.RestaurantManagement.Controller;


import com.example.RestaurantManagement.Repository.CustomerRepository;
import com.example.RestaurantManagement.Validator.CreateCustomerInfo;
import com.example.RestaurantManagement.Validator.CreateCustomerValidator;
import com.example.RestaurantManagement.Validator.UpdateCustomerInfo;
import com.example.RestaurantManagement.Validator.UpdateCustomerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CreateCustomerValidator createCustomerValidator;
    private final UpdateCustomerValidator updateCustomerValidator;

    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomerInfo customerInfo) {
        final var binder = new DataBinder(customerInfo);
        binder.setValidator(createCustomerValidator);
        binder.validate();
        if (binder.getBindingResult().hasErrors())
            return new ResponseEntity<>(binder.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(customerRepository.createCustomer(customerInfo), HttpStatus.OK);
    }

    @PutMapping("/customers/customerId")
    public ResponseEntity<?> updateCustomer(@RequestBody UpdateCustomerInfo customerInfo,
                                            @PathVariable Integer customerId) {
        customerInfo.setCustomer_id(customerId);
        var binder = new DataBinder(customerInfo);
        binder.setValidator(updateCustomerValidator);
        binder.validate();
        if (binder.getBindingResult().hasErrors())
            return new ResponseEntity<>(binder.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(customerRepository.updateCustomer(customerInfo), HttpStatus.OK);
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