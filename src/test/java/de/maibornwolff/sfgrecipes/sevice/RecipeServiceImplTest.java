package de.maibornwolff.sfgrecipes.sevice;

import de.maibornwolff.sfgrecipes.domain.Recipe;
import de.maibornwolff.sfgrecipes.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        // GIVEN
        Recipe recipe = new Recipe();
        when(recipeRepository.findAll()).thenReturn(Set.of(recipe));

        // WHEN
        Set<Recipe> recipes = recipeService.getRecipes();

        // THEN
        assertEquals(1, recipes.size());
        verify(recipeRepository).findAll();
    }

    @Test
    void getRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));

        Recipe result = recipeService.getRecipe(1L);

        assertNotNull(result);
        verify(recipeRepository).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
}