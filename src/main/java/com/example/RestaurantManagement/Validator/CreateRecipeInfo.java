package com.example.RestaurantManagement.Validator;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CreateRecipeInfo {

    private Integer recipe_id;
    private String recipe_name;
    private String cuisine;


}


