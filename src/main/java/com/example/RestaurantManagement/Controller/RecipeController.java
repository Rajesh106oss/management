package com.example.RestaurantManagement.Controller;

import com.example.RestaurantManagement.Repository.RecipeRepository;
import com.example.RestaurantManagement.Validator.CreateRecipeInfo;
import com.example.RestaurantManagement.Validator.UpdateRecipeInfo;
import com.example.RestaurantManagement.model.tables.pojos.RecipeManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeRepository recipeRepository;

    @PostMapping("/recipes")
    public ResponseEntity<?> createRecipe(@RequestBody CreateRecipeInfo recipeInfo) {
        return new ResponseEntity<>(RecipeRepository.CreateRecipe(recipeInfo),
                HttpStatus.OK);
    }

    @PutMapping("/recipes/recipeId")
    public ResponseEntity<?> updateRecipe(@RequestBody UpdateRecipeInfo recipeInfo){
        return new ResponseEntity<>(RecipeRepository.UpdateRecipe(recipeInfo), HttpStatus.OK);
    }


}
