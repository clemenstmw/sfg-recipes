package de.maibornwolff.sfgrecipes.sevice;

import de.maibornwolff.sfgrecipes.domain.Recipe;
import de.maibornwolff.sfgrecipes.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Getting recipes...");
        HashSet<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Recipe getRecipe(Long id) {
        log.debug("Getting recipe {}", id);
        return recipeRepository.findById(id).get();
    }
}
