package com.example.RestaurantManagement.Validator;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRecipeInfo {
    @JsonIgnore
    private Integer recipe_id;
    private String recipe_name;
    private String cuisine;
    private OffsetDateTime cook_time;

}


