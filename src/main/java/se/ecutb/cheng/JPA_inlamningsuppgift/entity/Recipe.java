package se.ecutb.cheng.JPA_inlamningsuppgift.entity;



import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;
    //private List<RecipeIngredient> recipeIngredients;
    //private RecipeInstruction instruction;
    //private List<RecipeCategory> categories;
}
