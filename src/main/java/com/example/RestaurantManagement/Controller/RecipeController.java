package com.example.RestaurantManagement.Controller;

import com.example.RestaurantManagement.Repository.RecipeRepository;
import com.example.RestaurantManagement.Validator.CreateRecipeInfo;
import com.example.RestaurantManagement.Validator.CreateRecipeValidator;
import com.example.RestaurantManagement.Validator.UpdateRecipeInfo;
import com.example.RestaurantManagement.Validator.UpdateRecipeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/v1")
@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeRepository recipeRepository;
    private final CreateRecipeValidator createRecipeValidator;
    private final UpdateRecipeValidator updateRecipeValidator;

    @PostMapping("/recipes")
    public ResponseEntity<?> createRecipe(@RequestBody CreateRecipeInfo recipeInfo) {
        final var binder = new DataBinder(recipeInfo);
        binder.setValidator(createRecipeValidator);
        binder.validate();
        if (binder.getBindingResult().hasErrors())
            return new ResponseEntity<>(binder.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
        var recipe =recipeRepository.createRecipe(recipeInfo);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PutMapping("/recipes/{recipeId}")
    public ResponseEntity<?> updateRecipe(@RequestBody UpdateRecipeInfo recipeInfo,
                                          @PathVariable Integer recipeId) {
        recipeInfo.setRecipe_id(recipeId);
        final var binder = new DataBinder(recipeInfo);
        binder.setValidator(updateRecipeValidator);
        binder.validate();
        if (binder.getBindingResult().hasErrors())
            return new ResponseEntity<>(binder.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(recipeRepository.updateRecipe(recipeInfo), HttpStatus.OK);
    }

    @GetMapping("/recipes/{recipeId}")
    public ResponseEntity<?> findRecipe(@PathVariable Integer recipeId) {
        return recipeRepository.getRecipeById(recipeId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/recipes")
    public ResponseEntity<?> ListRecipes() {
        return new ResponseEntity<>(recipeRepository.listRecipes(), HttpStatus.OK);
    }

    @DeleteMapping("/recipes/{recipeId}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Integer recipeId) {
        return recipeRepository.deleteRecipe(recipeId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}


