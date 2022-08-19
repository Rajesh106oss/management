package com.example.RestaurantManagement.Validator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRecipeInfo {
    @JsonIgnore
    private Integer recipe_id;
    private String recipe_name;
    private String cuisine;

}
