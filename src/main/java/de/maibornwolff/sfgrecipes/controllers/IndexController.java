package de.maibornwolff.sfgrecipes.controllers;

import de.maibornwolff.sfgrecipes.domain.Category;
import de.maibornwolff.sfgrecipes.domain.UnitOfMeasure;
import de.maibornwolff.sfgrecipes.repository.CategoryRepository;
import de.maibornwolff.sfgrecipes.repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> american = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is: " + american.get().getId());
        System.out.println("UOM Id is: " + teaspoon.get().getId());

        return "index";
    }
}
