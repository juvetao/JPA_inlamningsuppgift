package se.ecutb.cheng.JPA_inlamningsuppgift.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
            orphanRemoval = true,
            mappedBy = "recipe"
    )
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();
    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST}
    )
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;
    @ManyToMany(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id")
    )
    private List<RecipeCategory> categories = new ArrayList<>();

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Recipe(int recipeId, String recipeName, RecipeInstruction instruction) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.instruction = instruction;
    }

    public Recipe(String recipeName, RecipeInstruction instruction) {
        this(0,recipeName, instruction);
    }

    public Recipe(String recipeName) {
        this(0,recipeName,null);
    }

    Recipe(){}

    public boolean addCategory(RecipeCategory recipeCategory){
        if (categories.contains(recipeCategory)) return false;
        if (recipeCategory == null) return false;
        return categories.add(recipeCategory);
    }

    public boolean removeCategory(RecipeCategory recipeCategory){
        if (!categories.contains(recipeCategory)) return false;
        if (recipeCategory == null) return false;
        return categories.remove(recipeCategory);
    }

    public boolean addRecipeIngredient(RecipeIngredient recipeIngredient){
        if (recipeIngredient == null) return false;
        if (recipeIngredient.getRecipe() != null) return false;
        if (recipeIngredients.contains(recipeIngredient)) return false;
        recipeIngredient.setRecipe(this);
        return recipeIngredients.add(recipeIngredient);
    }

    public boolean removeRecipeIngredient(RecipeIngredient recipeIngredient){
        if (recipeIngredient == null) return false;
        if (recipeIngredient.getRecipe() != this) return false;
        recipeIngredient.setRecipe(null);
        return recipeIngredients.remove(recipeIngredient);
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId &&
                Objects.equals(recipeName, recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName, instruction);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Recipe{");
        sb.append("recipeId=").append(recipeId);
        sb.append(", recipeName='").append(recipeName).append('\'');
        sb.append(", recipeIngredientList=").append(recipeIngredients);
        sb.append(", recipeInstruction=").append(instruction);
        sb.append(", recipeCategoryList=").append(categories);
        sb.append('}');
        return sb.toString();
    }
}