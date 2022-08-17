package com.example.RestaurantManagement.Validator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderInfo {
    @JsonIgnore
    private Integer order_id;
    private String food_name;
    private String quantity;
    private Integer price;
}
