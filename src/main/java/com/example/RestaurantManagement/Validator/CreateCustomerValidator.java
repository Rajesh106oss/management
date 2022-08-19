package com.example.RestaurantManagement.Validator;

import com.example.RestaurantManagement.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class CreateCustomerValidator implements Validator {

    private final CustomerRepository customerRepository;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return CreateCustomerInfo.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {

        CreateCustomerInfo customers = (CreateCustomerInfo) target;
        final var FieldName = "name";
        ValidationUtils.rejectIfEmpty(errors, FieldName, "Customer.name.notBlank");
        if (!(customers.getCustomer_name().length() > 6 && customers.getCustomer_name().length() < 30))
            errors.rejectValue(FieldName, "Invalid Customer Name");
        if (errors.hasErrors()) return;
        var optionalCustomerManagement = customerRepository.getCustomerById(customers.getCustomer_id());
        if (optionalCustomerManagement.isEmpty())
            errors.rejectValue("customerId", "Please provide valid customerId");
    }
}
