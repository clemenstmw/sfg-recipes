package de.maibornwolff.sfgrecipes.repository;

import de.maibornwolff.sfgrecipes.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"Teaspoon", "Tablespoon", "Cup", "Pinch", "Ounce", "Piece", "Clove", "Pound", "Medium", "Large"})
    void findByDescription(String description) {

        Optional<UnitOfMeasure> byDescription = unitOfMeasureRepository.findByDescription(description);

        assertEquals(description, byDescription.get().getDescription());
    }
}