package com.example.RestaurantManagement.Validator;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerInfo {
    @JsonIgnore
    private Integer customer_id;
    private String customer_name;
    private String email;
    private Integer ph_no;
}
