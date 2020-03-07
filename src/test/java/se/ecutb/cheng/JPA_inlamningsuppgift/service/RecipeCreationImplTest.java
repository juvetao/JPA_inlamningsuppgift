package se.ecutb.cheng.JPA_inlamningsuppgift.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.Recipe;
import se.ecutb.cheng.JPA_inlamningsuppgift.repository.RecipeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase
public class RecipeCreationImplTest {
    @Autowired
    private RecipeCreation recipeCreation;
    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void createAndSave_Recipe_test_recipeName(){
        String recipeName = "Test";
        Recipe actualRecipe = recipeCreation.createAndSave(recipeName);
        String actual = actualRecipe.getRecipeName();
        String expect = recipeRepository.findByRecipeNameContainsIgnoreCase(recipeName).get(0).getRecipeName();
        assertEquals(expect, actual);
    }

}
