package com.example.RestaurantManagement.Repository;


import com.example.RestaurantManagement.Validator.CreateRecipeInfo;
import com.example.RestaurantManagement.Validator.UpdateRecipeInfo;
import com.example.RestaurantManagement.model.tables.pojos.RecipeManagement;
import com.example.RestaurantManagement.model.tables.records.RecipeManagementRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.RestaurantManagement.model.tables.RecipeManagement.RECIPE_MANAGEMENT;

@Repository
@RequiredArgsConstructor
public class RecipeRepository {

    public static DSLContext db;

    public RecipeManagement CreateRecipe(CreateRecipeInfo recipeInfo) {
        var record = db.newRecord(RECIPE_MANAGEMENT, new RecipeManagementRecord(null,
                recipeInfo.getRecipe_name(), recipeInfo.getCuisine(), OffsetDateTime.now()));
        record.store();
        return record.into(RecipeManagement.class);
    }


    public RecipeManagement UpdateRecipe(UpdateRecipeInfo recipeInfo) {
        return db.update(RECIPE_MANAGEMENT)
                .set(RECIPE_MANAGEMENT.RECIPE_NAME, recipeInfo.getRecipe_name())
                .set(RECIPE_MANAGEMENT.CUISINE, recipeInfo.getCuisine())
                .where(RECIPE_MANAGEMENT.RECIPE_ID.eq(recipeInfo.getRecipe_id()))
                .returning()
                .fetchOne()
                .map(r -> r.into(RecipeManagement.class));
    }

    public Optional<RecipeManagement> getRecipeById(Integer recipeId) {
        return db.selectFrom(RECIPE_MANAGEMENT)
                .where(RECIPE_MANAGEMENT.RECIPE_ID.eq(recipeId))
                .fetchOptionalInto(RecipeManagement.class);
    }


    public List<RecipeManagement> listRecipes() {
        return db.selectFrom(RECIPE_MANAGEMENT)
                .fetchInto(RecipeManagement.class);
    }

    public Optional<RecipeManagement> deleteRecipe(Integer recipeId) {
        var isValidRecipeManagement = getRecipeById(recipeId);
        if (isValidRecipeManagement.isPresent()) {
            db.deleteFrom(RECIPE_MANAGEMENT)
                    .where(RECIPE_MANAGEMENT.RECIPE_ID.eq(recipeId))
                    .execute();
            return isValidRecipeManagement;
        } else
            return Optional.empty();
    }

}
