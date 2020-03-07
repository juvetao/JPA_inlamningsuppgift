package se.ecutb.cheng.JPA_inlamningsuppgift.service;

import org.springframework.transaction.annotation.Transactional;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.Ingredient;

public interface IngredientCreation {
    @Transactional
    Ingredient createAndSave(String ingredientName);
}
