package se.ecutb.cheng.JPA_inlamningsuppgift.service;

import org.springframework.transaction.annotation.Transactional;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.Recipe;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.RecipeInstruction;

public interface RecipeCreation {
    @Transactional(rollbackFor = RuntimeException.class)
    Recipe createAndSave(String recipeName);
}
