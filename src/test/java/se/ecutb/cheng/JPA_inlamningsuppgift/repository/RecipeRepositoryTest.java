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

    private List<Recipe> recipeData(){
        return Arrays.asList(
                new Recipe("Grilled Chicken", null), //0
                new Recipe("Stir-fried Chicken", null) //1
        );
    }

//    private List<RecipeInstruction> recipeInstructionData() {
//        return Arrays.asList(
//                new RecipeInstruction("Cut ginger and garlic into slice"), //0 - Recipe 0 & 1
//                new RecipeInstruction("Cut Chicken into pieces"), //1 - Recipe 1
//                new RecipeInstruction("Mix with soy sauce, sesame oil and oyster sauce"), //2 - Recipe 0
//                new RecipeInstruction("brush the mix on the surface of chicken, put into oven for 30 mins at 200°C"), //3 - Recipe - 0
//                new RecipeInstruction("Stir-fry ginger and garlic slice until become gold"), //4 - Recipe 1
//                new RecipeInstruction("Stir-fry chicken pieces"), //5 - Recipe 1
//                new RecipeInstruction("Put soy sauce, sesame oil and oyster sauce") //6 - Recipe 1
//        );
//    }

    private RecipeInstruction recipeInstruction1 = new RecipeInstruction("Cut ginger and garlic into slice" +
            "Mix with cumin, soy sauce, sesame oil and oyster sauce" +
            "brush the mix on the surface of chicken, put into oven for 30 mins at 200°C" +
            "Put soy sauce, sesame oil and oyster sauce");

    private RecipeInstruction recipeInstruction2  = new RecipeInstruction("Cut ginger and garlic into slice" +
            "Cut Chicken into pieces" +
            "Stir-fry ginger and garlic slice until become gold" +
            "Stir-fry chicken pieces");

    private List<Ingredient> ingredientData(){
        return Arrays.asList(
                new Ingredient("Ginger"), //0
                new Ingredient("Garlic"), //1
                new Ingredient("Chicken"), //2
                new Ingredient("Soy sauce"), //3
                new Ingredient("Sesame Oil"), //4
                new Ingredient("Oyster sauce"), //5
                new Ingredient("Cumin") //6
        );
    }

    private List<RecipeIngredient> recipeIngredientData(){
        return Arrays.asList(
                new RecipeIngredient(5.00, Measurement.G), //GINGER
                new RecipeIngredient(5.00, Measurement.G), //GARLIC
                new RecipeIngredient(1.00, Measurement.KG), //CHICKEN
                new RecipeIngredient(5, Measurement.TSK), //SOY SAUCE
                new RecipeIngredient(3, Measurement.TSK), //SESAME OIL
                new RecipeIngredient(4, Measurement.TSK), //OYSTER SAUCE
                new RecipeIngredient(2, Measurement.TSK) //Cumin
        );
    }

    private List<RecipeCategory> categorieData(){
        return Arrays.asList(
                new RecipeCategory("Asian"), //Grilled Chicken & Stir-fried Chicken
                new RecipeCategory("Meat"), //Grilled Chicken & Stir-fried Chicken
                new RecipeCategory("Grilled"), //Grilled Chicken
                new RecipeCategory("Chinese") //Grilled Chicken & Stir-fried Chicken
        );
    }

    private List<Recipe> testRecipes;
    private List<RecipeInstruction> instructions;
    private List<RecipeIngredient> recipeIngredients;
    private List<RecipeCategory> categories;

    @BeforeEach
    public void setUp(){
        testRecipes = recipeData().stream()
                .map(testObject::save)
                .collect(Collectors.toList());
        recipeIngredients = recipeIngredientData().stream()
                .map(em::persist)
                .collect(Collectors.toList());
        categories = categorieData().stream()
                .map(em::persist)
                .collect(Collectors.toList());

        //Update instructions in recipe entity
        testRecipes.get(0).setInstruction(recipeInstruction1);
        testRecipes.get(1).setInstruction(recipeInstruction2);

        //Add ingredients into RecipeIngredients first
        recipeIngredients.get(0).setIngredient(ingredientData().get(0));//GINGER
        recipeIngredients.get(1).setIngredient(ingredientData().get(1));//GARLIC
        recipeIngredients.get(2).setIngredient(ingredientData().get(2));//CHICKEN
        recipeIngredients.get(3).setIngredient(ingredientData().get(3));//SOY SAUCE
        recipeIngredients.get(4).setIngredient(ingredientData().get(4));//SESAME OIL
        recipeIngredients.get(5).setIngredient(ingredientData().get(5));//OYSTER SAUCE
        recipeIngredients.get(6).setIngredient(ingredientData().get(6));//Cumin

        //Add recipeIngredients into recipe entity
        testRecipes.get(0).addRecipeIngredient(recipeIngredients.get(0));
        testRecipes.get(0).addRecipeIngredient(recipeIngredients.get(1));
        testRecipes.get(0).addRecipeIngredient(recipeIngredients.get(2));
        testRecipes.get(0).addRecipeIngredient(recipeIngredients.get(3));
        testRecipes.get(0).addRecipeIngredient(recipeIngredients.get(4));
        testRecipes.get(0).addRecipeIngredient(recipeIngredients.get(5));
        testRecipes.get(0).addRecipeIngredient(recipeIngredients.get(6));

        testRecipes.get(1).addRecipeIngredient(recipeIngredients.get(0));
        testRecipes.get(1).addRecipeIngredient(recipeIngredients.get(1));
        testRecipes.get(1).addRecipeIngredient(recipeIngredients.get(2));
        testRecipes.get(1).addRecipeIngredient(recipeIngredients.get(3));
        testRecipes.get(1).addRecipeIngredient(recipeIngredients.get(4));
        testRecipes.get(1).addRecipeIngredient(recipeIngredients.get(5));

        //Add instructions into Recipe Entities
        testRecipes.get(0).setInstruction(recipeInstruction1);
        testRecipes.get(1).setInstruction(recipeInstruction2);

        //Add categories into Recipe Entities
        testRecipes.get(0).addCategory(categorieData().get(0));
        testRecipes.get(0).addCategory(categorieData().get(1));
        testRecipes.get(0).addCategory(categorieData().get(2));
        testRecipes.get(0).addCategory(categorieData().get(3));
        testRecipes.get(1).addCategory(categorieData().get(0));
        testRecipes.get(1).addCategory(categorieData().get(1));
        testRecipes.get(1).addCategory(categorieData().get(3));

        em.flush();
    }

    @Test
    public void given_recipeName_findByRecipeNameContainsIgnoreCase_return_list(){
        String name = "chicken";
        List<Recipe> result = testObject.findByRecipeNameContainsIgnoreCase(name);
        int expectedSize = 2;
        int resultSize = result.size();
        assertEquals(expectedSize, resultSize);
    }

    //???
    @Test
    public void given_ingredientName_findByRecipeIngredientIngredientIngredientNameContainsIgnoreCase_return_list(){
        String name = "cumin";
        List<Recipe> result = testObject.findByRecipeIngredientsIngredientIngredientNameIgnoreCase(name);
        int expectedSize = 1;
        int resultSize = result.size();
        assertEquals(expectedSize, resultSize);
    }

    @Test
    public void given_category_findByCategoriesCategoryIgnoreCase_return_list(){
        String category = "asian";
        List<Recipe> result = testObject.findByCategoriesCategoryIgnoreCase(category);
        int expectedSize = 1;
        int resultSize = result.size();
        assertEquals(expectedSize, resultSize);
    }

    @Test
    public void given_categoryList_findByCategoriesCategoryIn_return_list(){
        List<String> category = Arrays.asList("Asian", "Grilled", "Chicken");
        List<Recipe> result = testObject.findDistinctRecipeByCategoriesCategoryIn(category);
        int expectedSize = 2;
        int resultSize = result.size();
        assertEquals(expectedSize, resultSize);
    }
}
