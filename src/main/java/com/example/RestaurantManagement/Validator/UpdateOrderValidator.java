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
public class UpdateOrderValidator implements Validator {

    private final OrderRepository orderRepository;
    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return UpdateOrderInfo.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        UpdateOrderInfo orders = (UpdateOrderInfo) target;
        var FieldName = "name";
        ValidationUtils.rejectIfEmpty(errors, FieldName, "Order name is empty");
        if (errors.hasErrors()) return;
        if (!(orders.getFood_name().length() > 4 && orders.getFood_name().length() < 20))
            errors.rejectValue("name", "Invalid Order Name");
        if (errors.hasErrors()) return;
        var validOrderId = orderRepository.getOrderById(orders.getOrder_id());
        if (validOrderId.isEmpty()) {
            errors.rejectValue("id", "Please provide valid orderId");
        }

    }
}
