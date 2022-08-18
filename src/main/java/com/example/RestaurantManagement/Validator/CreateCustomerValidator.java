package com.example.RestaurantManagement.Validator;

import org.springframework.lang.NonNull;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CreateCustomerValidator implements Validator {
    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {

        CreateCustomerInfo customers = (CreateCustomerInfo) target;
        final var FieldName = "name";
        ValidationUtils.rejectIfEmpty(errors, FieldName, "Customer.name.notBlank");
        if (!(customers.getCustomer_name().length() > 6 && customers.getCustomer_name().length() < 30))
            errors.rejectValue(FieldName, "Invalid Customer Name");
        if (errors.hasErrors()) return;
        var optionalOrderManagement = orderRepository.getOrderById(orders.getOrder_id());
        if (optionalOrderManagement.isEmpty())
            errors.rejectValue("orderId", "Please provide valid orderId");
    }
}
