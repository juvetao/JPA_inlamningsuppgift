package se.ecutb.cheng.JPA_inlamningsuppgift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.Recipe;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.RecipeInstruction;
import se.ecutb.cheng.JPA_inlamningsuppgift.repository.RecipeRepository;

import java.util.Arrays;
import java.util.Objects;

@Service
public class RecipeCreationImpl implements RecipeCreation {
    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeCreationImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Recipe createAndSave(String recipeName) {
        if(hasHulls(recipeName)){
            throw new RuntimeException("One or several parameters is null");
        }

        Recipe recipe = new Recipe(recipeName);
        return recipeRepository.save(recipe);
    }

    public static boolean hasHulls(Object...objects){
        return Arrays.stream(objects)
                .anyMatch(Objects::isNull);
    }
}
