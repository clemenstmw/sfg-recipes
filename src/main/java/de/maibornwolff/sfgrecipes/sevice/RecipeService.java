package de.maibornwolff.sfgrecipes.sevice;

import de.maibornwolff.sfgrecipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe getRecipe(Long id);
}
