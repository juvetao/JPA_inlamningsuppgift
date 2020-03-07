package se.ecutb.cheng.JPA_inlamningsuppgift.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.RecipeCategory;

import java.util.Arrays;
import java.util.Objects;

@Service
public class RecipeCategoryCreationImpl implements RecipeCategoryCreation {

    @Override
    @Transactional
    public RecipeCategory create(String category) {
        RecipeCategory recipeCategory = new RecipeCategory(category);
        return recipeCategory;
    }

}
