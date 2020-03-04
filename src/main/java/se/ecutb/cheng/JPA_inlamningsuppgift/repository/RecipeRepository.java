package se.ecutb.cheng.JPA_inlamningsuppgift.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.Recipe;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.RecipeCategory;

import java.util.Collection;
import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    //Hitta flera recept vars receptnamn innehåller en viss String.
    List<Recipe> findByRecipeNameContainsIgnoreCase (String recipeName);

    //Hitta alla recept som innehåller ett visst ingrediensnamn (String Ingredient.ingredientName)
    List<Recipe> findByRecipeIngredientsIngredientIngredientNameIgnoreCase (String ingredientName);

    //Hitta alla recept som tillhör en viss receptkategori
    List<Recipe> findByCategoriesCategoryIgnoreCase (String category);

    //Hitta alla recept som har en eller flera träffar från en samling kategorier
    //@Query("SELECT DISTINCT recipe FROM Recipe recipe JOIN FETCH recipe.categories categories WHERE categories.category IN category")
    List<Recipe> findDistinctRecipeByCategoriesCategoryIn (List<String> category);
}
