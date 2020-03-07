package se.ecutb.cheng.JPA_inlamningsuppgift.service;

import org.springframework.transaction.annotation.Transactional;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.RecipeCategory;

public interface RecipeCategoryCreation {
    @Transactional
    RecipeCategory create(String category);
}
