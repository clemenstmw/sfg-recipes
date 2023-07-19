package de.maibornwolff.sfgrecipes.repository;

import de.maibornwolff.sfgrecipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
