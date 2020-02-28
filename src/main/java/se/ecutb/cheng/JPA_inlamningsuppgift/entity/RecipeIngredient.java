package se.ecutb.cheng.JPA_inlamningsuppgift.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String recipeIngredientId;
    //private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    //private Recipe recipe;
}
