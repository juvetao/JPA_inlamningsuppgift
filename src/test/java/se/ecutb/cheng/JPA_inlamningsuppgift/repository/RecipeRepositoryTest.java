package se.ecutb.cheng.JPA_inlamningsuppgift.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class RecipeRepositoryTest {
    @Autowired RecipeRepository testObject;
    @Autowired TestEntityManager em;

    @BeforeEach
    public void mySetup(){
        Recipe recipe = new Recipe("Test");
        Ingredient egg = em.persist(new Ingredient("egg"));
        RecipeIngredient recipeIngredient = new RecipeIngredient(egg,10,Measurement.ST);
        recipe.addRecipeIngredient(recipeIngredient);
        RecipeCategory recipeCategory1= new RecipeCategory(0, "Simple", new ArrayList<>());
        recipe.addCategory(recipeCategory1);
        recipe.setInstruction(new RecipeInstruction(null, "Test instruction"));
        testObject.save(recipe);
    }

    @Test
    public void given_recipeName_findByRecipeNameContainsIgnoreCase_return_list(){
        String name = "test";
        List<Recipe> result = testObject.findByRecipeNameContainsIgnoreCase(name);
        int expectedSize = 1;
        int resultSize = result.size();
        assertEquals(expectedSize, resultSize);
    }

    @Test
    public void given_ingredientName_findByRecipeIngredientsIngredientIngredientNameIgnoreCase_return_list(){
        String name = "Egg";
        List<Recipe> result = testObject.findByRecipeIngredientsIngredientIngredientNameIgnoreCase(name);
        int expectedSize = 1;
        int resultSize = result.size();
        assertEquals(expectedSize, resultSize);
    }

    @Test
    public void given_category_findByCategoriesCategoryIgnoreCase_return_list(){
        String category = "simple";
        List<Recipe> result = testObject.findByCategoriesCategoryIgnoreCase(category);
        int expectedSize = 1;
        int resultSize = result.size();
        assertEquals(expectedSize, resultSize);
    }

    @Test
    public void given_categoryList_findByCategoriesCategoryIn_return_list(){
        List<String> category = Arrays.asList("Simple", "Complicated");
        List<Recipe> result = testObject.findRecipeByCategoriesCategoryIn(category);
        int expectedSize = 1;
        int resultSize = result.size();
        assertEquals(expectedSize, resultSize);
    }
}
