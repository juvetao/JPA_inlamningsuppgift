package se.ecutb.cheng.JPA_inlamningsuppgift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.Ingredient;
import se.ecutb.cheng.JPA_inlamningsuppgift.repository.IngredientRepository;

import java.util.Arrays;
import java.util.Objects;

@Service
public class IngredientCreationImpl implements IngredientCreation {
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientCreationImpl(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Ingredient createAndSave(String ingredientName){
        if(hasHulls(ingredientName)){
            throw new RuntimeException("One or several parameters is null");
        }
        if(ingredientRepository.findByIngredientNameIgnoreCase(ingredientName).isPresent()){
            throw new RuntimeException("Ingredient Name exists already ");
        }
        Ingredient ingredient = new Ingredient(ingredientName);
        return ingredientRepository.save(ingredient);
    }

    public static boolean hasHulls(Object...objects){
        return Arrays.stream(objects)
               .anyMatch(Objects::isNull);
    }
}
