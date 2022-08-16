package com.example.RestaurantManagement.Validator;

import com.example.RestaurantManagement.Repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.example.RestaurantManagement.Validator.UpdateRecipeInfo.*;

@Component
@RequiredArgsConstructor
public class UpdateRecipeValidator implements Validator {

    private final RecipeRepository recipeRepository;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return UpdateRecipeInfo.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        UpdateRecipeInfo recipes = (UpdateRecipeInfo) target;
        var FieldId = "id";
        var FieldName = "name";
        ValidationUtils.rejectIfEmpty(errors, FieldId, "Recipe Id is empty");
        if (errors.hasErrors()) return;
        ValidationUtils.rejectIfEmpty(errors, FieldName, "Recipe name is empty");
        if (errors.hasErrors()) return;
        if (!(recipes.getRecipe_name().length() > 5 && recipes.getRecipe_name().length() < 30))
            errors.rejectValue("name", "Invalid Recipe Name");
        if (errors.hasErrors()) return;
        var validRecipeId = RecipeRepository.getRecipeById(recipes.getRecipe_id());
        if (validRecipeId.isEmpty())
            errors.rejectValue("id", "Please provide valid recipeId");
    }
    }

