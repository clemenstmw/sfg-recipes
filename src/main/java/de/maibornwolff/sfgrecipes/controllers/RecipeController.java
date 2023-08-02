package de.maibornwolff.sfgrecipes.controllers;

import de.maibornwolff.sfgrecipes.domain.Recipe;
import de.maibornwolff.sfgrecipes.sevice.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipes")
    public String getRecipes(Model model) {
        log.debug("Requesting all recipes");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "recipes/index";
    }

    @RequestMapping("/recipes/{id}")
    public String getRecipe(Model model, @PathVariable("id") Long id) {
        log.debug("Requesting recipe with id {}", id);
        Recipe recipe = recipeService.getRecipe(id);
        model.addAttribute("recipe", recipe);
        return "recipes/from-id";
    }
}
