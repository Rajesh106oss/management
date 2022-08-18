package com.example.RestaurantManagement.Validator;

import com.example.RestaurantManagement.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
@RequiredArgsConstructor
public class CreateOrderValidator implements Validator {

    private final OrderRepository orderRepository;
    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return CreateOrderInfo.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        CreateOrderInfo orders = (CreateOrderInfo) target;
        final var FieldName = "name";
        ValidationUtils.rejectIfEmpty(errors, FieldName, "Order.name.notBlank");
        if (!(orders.getFood_name().length() > 7 && orders.getFood_name().length() < 40))
            errors.rejectValue(FieldName, "Invalid Order Name");
        if (errors.hasErrors()) return;
        var optionalOrderManagement = orderRepository.getOrderById(orders.getOrder_id());
        if (optionalOrderManagement.isEmpty())
            errors.rejectValue("orderId", "Please provide valid orderId");
    }
}
