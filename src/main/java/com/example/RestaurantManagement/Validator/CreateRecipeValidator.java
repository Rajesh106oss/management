package com.example.RestaurantManagement.Validator;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class CreateRecipeValidator implements Validator {
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
            errors.rejectValue(FieldName, "Invalid Recipe Name");
    }
}
