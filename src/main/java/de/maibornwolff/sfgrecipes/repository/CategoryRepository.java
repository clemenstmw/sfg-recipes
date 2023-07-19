package de.maibornwolff.sfgrecipes.repository;

import de.maibornwolff.sfgrecipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
