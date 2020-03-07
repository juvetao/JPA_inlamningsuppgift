package se.ecutb.cheng.JPA_inlamningsuppgift.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.Ingredient;
import se.ecutb.cheng.JPA_inlamningsuppgift.repository.IngredientRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase
public class IngredientCreationImplTest {
    @Autowired
    private IngredientCreation ingredientCreation;
    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    public void createAndSave_ingredient_test_ingredientName(){
        String ingredientName = "Test";
        Ingredient actualIngredient = ingredientCreation.createAndSave(ingredientName);
        String actual = actualIngredient.getIngredientName();
        String expect = ingredientRepository.findByIngredientNameIgnoreCase(ingredientName).get().getIngredientName();
        assertEquals(expect, actual);
    }

}
