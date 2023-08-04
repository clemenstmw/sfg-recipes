package de.maibornwolff.sfgrecipes.controllers;

import de.maibornwolff.sfgrecipes.domain.Recipe;
import de.maibornwolff.sfgrecipes.sevice.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

    RecipeController recipeController;

    @Mock
    RecipeService recipeService;
//    @Mock
//    Model model;

    @BeforeEach
    void setUp() {
        recipeController = new RecipeController(recipeService);
    }

    @Test
    void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        mockMvc.perform(get("/recipes/"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipes/index"));
    }

    @Test
    void getRecipes(@Mock Model model) {
        // GIVEN

        // WHEN
        String result = recipeController.getRecipes(model);

        // THEN
        assertEquals("recipes/index", result);
        verify(recipeService).getRecipes();
        verify(model).addAttribute(eq("recipes"), any());
        verifyNoMoreInteractions(recipeService, model);
    }
    @Test
    void getRecipe(@Mock Model model) {
        // GIVEN
        long requestedId = 5L;
        Recipe expectedRecipe = new Recipe();
        when(recipeService.getRecipe(anyLong())).thenReturn(expectedRecipe);

        // WHEN
        String result = recipeController.getRecipe(model, requestedId);

        // THEN
        assertEquals("recipes/from-id", result);
        verify(recipeService).getRecipe(requestedId);
        verify(model).addAttribute(eq("recipe"), eq(expectedRecipe));
        verifyNoMoreInteractions(recipeService, model);
    }
}