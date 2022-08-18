package com.example.RestaurantManagement.Validator;

import com.example.RestaurantManagement.Repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class CreateRecipeValidator implements Validator {

    private final RecipeRepository recipeRepository;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return CreateRecipeInfo.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        CreateRecipeInfo recipes = (CreateRecipeInfo) target;
        final var FieldName = "name";
        ValidationUtils.rejectIfEmpty(errors, FieldName, "Recipe.name.notBlank");
        if (!(recipes.getRecipe_name().length() > 3 && recipes.getRecipe_name().length() < 30))
            errors.rejectValue("name", "Invalid Recipe Name");
        if (errors.hasErrors()) return;
        var optionalRecipeManagement = recipeRepository.getRecipeById(recipes.getRecipe_id());
        if (optionalRecipeManagement.isEmpty())
            errors.rejectValue("recipeId", "Please provide valid recipeId");
    }
}

