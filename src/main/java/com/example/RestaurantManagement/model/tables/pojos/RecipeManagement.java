/*
 * This file is generated by jOOQ.
 */
package com.example.RestaurantManagement.model.tables.pojos;


import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.annotation.processing.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RecipeManagement implements Serializable {

    private static final long serialVersionUID = 802092892;

    private Integer        recipeId;
    private String         recipeName;
    private String         cuisine;
    private OffsetDateTime cookTime;

    public RecipeManagement() {}

    public RecipeManagement(RecipeManagement value) {
        this.recipeId = value.recipeId;
        this.recipeName = value.recipeName;
        this.cuisine = value.cuisine;
        this.cookTime = value.cookTime;
    }

    public RecipeManagement(
        Integer        recipeId,
        String         recipeName,
        String         cuisine,
        OffsetDateTime cookTime
    ) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.cuisine = cuisine;
        this.cookTime = cookTime;
    }

    public Integer getRecipeId() {
        return this.recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getCuisine() {
        return this.cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public OffsetDateTime getCookTime() {
        return this.cookTime;
    }

    public void setCookTime(OffsetDateTime cookTime) {
        this.cookTime = cookTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RecipeManagement (");

        sb.append(recipeId);
        sb.append(", ").append(recipeName);
        sb.append(", ").append(cuisine);
        sb.append(", ").append(cookTime);

        sb.append(")");
        return sb.toString();
    }
}
