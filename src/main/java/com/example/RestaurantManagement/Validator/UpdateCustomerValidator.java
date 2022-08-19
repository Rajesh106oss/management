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
public class UpdateCustomerValidator implements Validator {

    private final CustomerRepository customerRepository;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return UpdateCustomerInfo.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        UpdateCustomerInfo customers = (UpdateCustomerInfo) target;
        var FieldId = "id";
        var FieldName = "name";
        ValidationUtils.rejectIfEmpty(errors, FieldId, "Customer Id is empty");
        if (errors.hasErrors()) return;
        ValidationUtils.rejectIfEmpty(errors, FieldName, "Customer name is empty");
        if (errors.hasErrors()) return;
        if (!(customers.getCustomer_name().length() > 6 && customers.getCustomer_name().length() < 20))
            errors.rejectValue("name", "Invalid Customer Name");
        if (errors.hasErrors()) return;
        var validCustomerId = customerRepository.getCustomerById(customers.getCustomer_id());
        if (validCustomerId.isEmpty())
            errors.rejectValue("id", "Please provide valid customerId");
    }
}
