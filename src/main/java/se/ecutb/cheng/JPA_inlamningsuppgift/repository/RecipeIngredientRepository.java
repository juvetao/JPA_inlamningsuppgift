package se.ecutb.cheng.JPA_inlamningsuppgift.repository;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.Recipe;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.RecipeIngredient;

import java.util.List;
import java.util.Optional;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, String> {
}
