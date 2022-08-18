package com.example.RestaurantManagement.Validator;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerInfo {

    private Integer customer_id;
    private String customer_name;
    private String email;
    private Integer ph_no;
}
