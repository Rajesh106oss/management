package com.example.RestaurantManagement.Validator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UpdateRecipeInfo {

    private Integer recipe_id;
    private String recipe_name;
    private String cuisine;

}
