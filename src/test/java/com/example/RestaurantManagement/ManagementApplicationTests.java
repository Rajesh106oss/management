package com.example.RestaurantManagement;

import com.example.RestaurantManagement.Validator.CreateRecipeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ManagementApplicationTests {

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private MockMvc mockMvc;

    @Test
    @DisplayName("Create Recipe")
	void createRecipe() throws Exception{
		var recipe = new CreateRecipeInfo();
		createRecipe(recipe, status().isOk());
		recipe.setRecipe_name("Noodles");
		createRecipe(recipe, status().isBadRequest());
		}

	public void createRecipe(CreateRecipeInfo recipe, ResultMatcher status)
			throws Exception {
		mockMvc.perform(post("/v1/recipes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(recipe)))
				.andExpect(status)
				.andDo(print());

	}
}
