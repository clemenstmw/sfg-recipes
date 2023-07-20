package de.maibornwolff.sfgrecipes.repository;

import de.maibornwolff.sfgrecipes.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
