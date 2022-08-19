package com.example.RestaurantManagement;

import com.example.RestaurantManagement.Validator.CreateRecipeInfo;
import com.example.RestaurantManagement.Validator.UpdateRecipeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class RecipeManagementTests {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @Order(1)
    @Test
    @DisplayName("Create Recipe")
    void createRecipe() throws Exception {
        var recipe = new CreateRecipeInfo(2, "rice", "indian", null);
        createRecipe(recipe, status().isOk());
        recipe.setRecipe_name("rice");
        createRecipe(recipe, status().isOk());
    }

    public void createRecipe(CreateRecipeInfo recipe, ResultMatcher status)
            throws Exception {
        mockMvc.perform(post("/v1/recipes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(recipe)))
                .andExpect(status)
                .andDo(print());
    }

    @Order(2)
    @Test
    @DisplayName("Update Order")
    void UpdateRecipe() throws Exception {
        var createRecipeInfo = new CreateRecipeInfo(2, "rice", "Indian", null);
        var recipeId = storeAndGetRecipeId(createRecipeInfo);
        var updateRecipeInfo = new UpdateRecipeInfo(5, "maggie", "chinese");
        UpdateRecipe(updateRecipeInfo, recipeId, status().isOk());
        updateRecipeInfo.setRecipe_name("rice");
        UpdateRecipe(updateRecipeInfo, recipeId, status().isOk());
        updateRecipeInfo.setRecipe_name(null);
        UpdateRecipe(updateRecipeInfo, recipeId, status().isBadRequest());
        updateRecipeInfo.setRecipe_name("idly");
        UpdateRecipe(updateRecipeInfo, 0, status().isOk());
    }

    public void UpdateRecipe(UpdateRecipeInfo order, Integer recipeId, ResultMatcher status)
            throws Exception {
        mockMvc.perform(put("/v1/recipes/" + recipeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(order)))
                .andExpect(status)
                .andDo(print());
    }

    private Integer storeAndGetRecipeId(CreateRecipeInfo createRecipeInfo)
            throws Exception {
        return JsonPath.parse(mockMvc.perform(post("/v1/recipes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(createRecipeInfo)))
                .andReturn().getResponse().getContentAsString()).read("id", Integer.class);
    }

    @Order(3)
    @Test
    @DisplayName("Get Recipe")
    void GetRecipeInfo() throws Exception {
        var createRecipeInfo = new CreateRecipeInfo(2, "rice", "Indian", null);
        var recipeId = storeAndGetRecipeId(createRecipeInfo);
        getRecipeInfo(recipeId, status().isOk());
        getRecipeInfo(0, status().isNotFound());
    }

    private void getRecipeInfo(Integer recipeId, ResultMatcher status) throws Exception {
        mockMvc.perform(get("/v1/recipes/" + recipeId))
                .andExpect(status)
                .andDo(print());
    }

    @Order(4)
    @Test
    @DisplayName("Delete Recipe")
    void deleteRecipe() throws Exception {
        var createRecipeInfo = new CreateRecipeInfo(2, "rice", "Indian", null);
        var customerId = storeAndGetRecipeId(createRecipeInfo);
        deleteOrder(customerId, status().isOk());
        deleteOrder(customerId, status().isNotFound());
    }

    private void deleteOrder(Integer customerId, ResultMatcher status) throws Exception {
        mockMvc.perform(delete("/v1/customers/" + customerId))
                .andExpect(status)
                .andDo(print());
    }
}
