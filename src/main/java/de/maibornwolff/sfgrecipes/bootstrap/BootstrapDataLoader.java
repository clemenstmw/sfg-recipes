package de.maibornwolff.sfgrecipes.bootstrap;

import de.maibornwolff.sfgrecipes.domain.Difficulty;
import de.maibornwolff.sfgrecipes.domain.Ingredient;
import de.maibornwolff.sfgrecipes.domain.Recipe;
import de.maibornwolff.sfgrecipes.domain.UnitOfMeasure;
import de.maibornwolff.sfgrecipes.repository.IngredientRepository;
import de.maibornwolff.sfgrecipes.repository.RecipeRepository;
import de.maibornwolff.sfgrecipes.repository.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class BootstrapDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository repository;
    private final UnitOfMeasureRepository uomRepository;
    private final IngredientRepository ingredientRepository;

    public BootstrapDataLoader(RecipeRepository repository, UnitOfMeasureRepository uomRepository, IngredientRepository ingredientRepository) {
        this.repository = repository;
        this.uomRepository = uomRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Recipe guacamoleRecipe = createGuacamoleRecipe();
        repository.save(guacamoleRecipe);

        Recipe chickenTacosRecipe = createChickenTacosRecipe();
        repository.save(chickenTacosRecipe);
    }

    private Recipe createGuacamoleRecipe() {
        Recipe recipe = new Recipe();
        recipe.setDescription("""
                Copycat Chipotle Guacamole<br>
                                
                If you love the lime- and cilantro-spiked guacamole from Chipotle Mexican Grill, then this recipe is for you. It will make all of your tortilla chip dipping dreams come true.
                """);
        recipe.setDirections("""
                1. Make the garlic paste:<br>
                                
                Roughly chop the garlic cloves. Once the garlic has been chopped, sprinkle 1/2 teaspoon of salt over it and crush the salt and garlic together by dragging the flat side of your knife over the mixture. This step should take no more than 1-2 minutes.<br>
                                
                2. Mince the vegetables:<br>
                                
                Mince the red onion and jalapeño pepper. Cut the pieces of both into cubes smaller than 1/4 inch (for the onion) and 1/8 inch (for the pepper). You should have about 1/4 cup of red onions and 1 tablespoon jalapeños. Discard the jalapeño seeds for a milder dip.<br>
                                
                3. Mix the guacamole:<br>
                                
                Slice and scoop out the avocado, then add it to a large bowl. Mash the avocado lightly with a fork, but leave it a little chunky for now. The avocado will become smoother once you mix everything together.<br>
                                
                Add the garlic paste, red onion, jalapeño pepper, and cilantro to a large bowl.<br>
                                
                Pour the lime juice into the bowl and fold the ingredients together, gently, until everything is mixed. Taste the guacamole and add more salt, to taste.<br>
                
                4. Cover and store:<br>
                
                If you don’t intend to eat the guacamole right away, press a piece of plastic wrap directly onto its surface, and cover the bowl with a lid. Keep the guacamole refrigerated for up to 3 days. The surface of the guacamole might still brown, but just scrape the top off to reveal the bright green guac below!<br>
                """);

        recipe.setDifficulty(Difficulty.EASY);
        recipe.setPrepTime(0);
        recipe.setCookTime(15);

        recipe.addIngredient(createIngredient(recipe, "ripe Hass avocados", BigDecimal.valueOf(4L), getUom("Piece")));
        recipe.addIngredient(createIngredient(recipe, "garlic", BigDecimal.valueOf(3L), getUom("Clove")));
        recipe.addIngredient(createIngredient(recipe, "kosher salt, plus more to taste", BigDecimal.valueOf(.5), getUom("Teaspoon")));
        recipe.addIngredient(createIngredient(recipe, "red onion", BigDecimal.valueOf(.5), getUom("Medium")));
        recipe.addIngredient(createIngredient(recipe, "jalapeño", BigDecimal.valueOf(.5), getUom("Large")));
        recipe.addIngredient(createIngredient(recipe, "chopped cilantro", BigDecimal.valueOf(.25), getUom("Cup")));
        recipe.addIngredient(createIngredient(recipe, "fresh lime juice (squeezed from 1 large lime)", BigDecimal.valueOf(2L), getUom("Tablespoon")));

        recipe.setServings(8);
        recipe.setSource("Simply Recipes");
        recipe.setUrl("https://www.simplyrecipes.com/recipes/copy_cat_chipotle_guacamole/");
        return recipe;
    }

    private Recipe createChickenTacosRecipe() {
        Recipe recipe = new Recipe();
        recipe.setDescription("""                
                Spicy Grilled Chicken Tacos<br>
                
                Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.<br>
                """);
        recipe.setDirections("""
                1.  Prepare the grill:<br>
                
                Prepare either a gas or charcoal grill for medium-high, direct heat.<br>
                
                2. Make the marinade and coat the chicken:<br>
                
                In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.<br>
                
                Set aside to marinate while the grill heats and you prepare the rest of the toppings.<br>
                
                3. Grill the chicken:<br>
                
                Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165°F. Transfer to a plate and rest for 5 minutes.<br>
                
                4. Thin the sour cream with milk:<br>
                
                Stir together the sour cream and milk to thin out the sour cream to make it easy to drizzle.<br>
                
                5. Assemble the tacos:<br>
                
                Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.<br>
                
                6. Warm the tortillas:<br>
                
                Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.<br>
                
                Wrap warmed tortillas in a tea towel to keep them warm until serving.<br>
                """);
        recipe.setDifficulty(Difficulty.MODERATE);
        recipe.setPrepTime(20);
        recipe.setCookTime(15);

        recipe.addIngredient(createIngredient(recipe, "ancho chili powder", BigDecimal.valueOf(2), getUom("Tablespoon")));
        recipe.addIngredient(createIngredient(recipe, "dried oregano", BigDecimal.valueOf(1), getUom("Teaspoon")));
        recipe.addIngredient(createIngredient(recipe, "dried cumin", BigDecimal.valueOf(1), getUom("Teaspoon")));
        recipe.addIngredient(createIngredient(recipe, "sugar", BigDecimal.valueOf(1), getUom("Teaspoon")));
        recipe.addIngredient(createIngredient(recipe, "kosher salt", BigDecimal.valueOf(.5), getUom("Teaspoon")));
        recipe.addIngredient(createIngredient(recipe, "garlic, finely chopped", BigDecimal.ONE, getUom("Clove")));
        recipe.addIngredient(createIngredient(recipe, "finely grated orange zest", BigDecimal.valueOf(1), getUom("Tablespoon")));
        recipe.addIngredient(createIngredient(recipe, "fresh-squeezed orange juice", BigDecimal.valueOf(3), getUom("Tablespoon")));
        recipe.addIngredient(createIngredient(recipe, "olive oil", BigDecimal.valueOf(2), getUom("Tablespoon")));
        recipe.addIngredient(createIngredient(recipe, "skinless, boneless chicken thighs", BigDecimal.valueOf(1.25), getUom("Pound")));

        recipe.setServings(5);
        recipe.setSource("Simple Recipes");
        recipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        return recipe;
    }

    private UnitOfMeasure getUom(String description) {
        Optional<UnitOfMeasure> uomOptional = uomRepository.findByDescription(description);

        return uomOptional.orElseThrow();
    }

    private Ingredient createIngredient(Recipe recipe, String description, BigDecimal amount, UnitOfMeasure uom) {
        Ingredient ingredient = new Ingredient();
        ingredient.setDescription(description);
        ingredient.setAmount(amount);
        ingredient.setUom(uom);
        ingredient.setRecipe(recipe);
        return ingredient;
    }
}
