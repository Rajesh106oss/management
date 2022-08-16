/*
 * This file is generated by jOOQ.
 */
package com.example.RestaurantManagement.model.tables.daos;


import com.example.RestaurantManagement.model.tables.RecipeManagement;
import com.example.RestaurantManagement.model.tables.records.RecipeManagementRecord;

import java.time.OffsetDateTime;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class RecipeManagementDao extends DAOImpl<RecipeManagementRecord, com.example.RestaurantManagement.model.tables.pojos.RecipeManagement, Integer> {

    /**
     * Create a new RecipeManagementDao without any configuration
     */
    public RecipeManagementDao() {
        super(RecipeManagement.RECIPE_MANAGEMENT, com.example.RestaurantManagement.model.tables.pojos.RecipeManagement.class);
    }

    /**
     * Create a new RecipeManagementDao with an attached configuration
     */
    public RecipeManagementDao(Configuration configuration) {
        super(RecipeManagement.RECIPE_MANAGEMENT, com.example.RestaurantManagement.model.tables.pojos.RecipeManagement.class, configuration);
    }

    @Override
    public Integer getId(com.example.RestaurantManagement.model.tables.pojos.RecipeManagement object) {
        return object.getRecipeId();
    }

    /**
     * Fetch records that have <code>recipe_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.RecipeManagement> fetchRangeOfRecipeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(RecipeManagement.RECIPE_MANAGEMENT.RECIPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>recipe_id IN (values)</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.RecipeManagement> fetchByRecipeId(Integer... values) {
        return fetch(RecipeManagement.RECIPE_MANAGEMENT.RECIPE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>recipe_id = value</code>
     */
    public com.example.RestaurantManagement.model.tables.pojos.RecipeManagement fetchOneByRecipeId(Integer value) {
        return fetchOne(RecipeManagement.RECIPE_MANAGEMENT.RECIPE_ID, value);
    }

    /**
     * Fetch records that have <code>recipe_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.RecipeManagement> fetchRangeOfRecipeName(String lowerInclusive, String upperInclusive) {
        return fetchRange(RecipeManagement.RECIPE_MANAGEMENT.RECIPE_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>recipe_name IN (values)</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.RecipeManagement> fetchByRecipeName(String... values) {
        return fetch(RecipeManagement.RECIPE_MANAGEMENT.RECIPE_NAME, values);
    }

    /**
     * Fetch records that have <code>cuisine BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.RecipeManagement> fetchRangeOfCuisine(String lowerInclusive, String upperInclusive) {
        return fetchRange(RecipeManagement.RECIPE_MANAGEMENT.CUISINE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>cuisine IN (values)</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.RecipeManagement> fetchByCuisine(String... values) {
        return fetch(RecipeManagement.RECIPE_MANAGEMENT.CUISINE, values);
    }

    /**
     * Fetch records that have <code>cook_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.RecipeManagement> fetchRangeOfCookTime(OffsetDateTime lowerInclusive, OffsetDateTime upperInclusive) {
        return fetchRange(RecipeManagement.RECIPE_MANAGEMENT.COOK_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>cook_time IN (values)</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.RecipeManagement> fetchByCookTime(OffsetDateTime... values) {
        return fetch(RecipeManagement.RECIPE_MANAGEMENT.COOK_TIME, values);
    }
}
