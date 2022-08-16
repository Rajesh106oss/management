package com.example.RestaurantManagement.Repository;


import com.example.RestaurantManagement.Validator.CreateRecipeInfo;
import com.example.RestaurantManagement.Validator.UpdateRecipeInfo;
import com.example.RestaurantManagement.model.tables.pojos.RecipeManagement;
import com.example.RestaurantManagement.model.tables.records.RecipeManagementRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

import static com.example.RestaurantManagement.model.tables.RecipeManagement.RECIPE_MANAGEMENT;

@Repository
@RequiredArgsConstructor
public class RecipeRepository {

    public static DSLContext db;

    public static RecipeManagement CreateRecipe(CreateRecipeInfo recipeInfo) {
        var record = db.newRecord(RECIPE_MANAGEMENT, new RecipeManagementRecord(null,
                recipeInfo.getRecipe_name(), recipeInfo.getCuisine(), OffsetDateTime.now()));
        record.store();
        return record.into(RecipeManagement.class);
    }


    public static RecipeManagement UpdateRecipe(UpdateRecipeInfo recipeInfo) {
        return db.update(RECIPE_MANAGEMENT)
                .set(RECIPE_MANAGEMENT.RECIPE_NAME,recipeInfo.getRecipe_name())
                .set(RECIPE_MANAGEMENT.CUISINE,recipeInfo.getCuisine())
                .where(RECIPE_MANAGEMENT.RECIPE_ID.eq(recipeInfo.getRecipe_id()))
                .returning()
                .fetchOne()
                .map(r -> r.into(RecipeManagement.class));
    }
}
