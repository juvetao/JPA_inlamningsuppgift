package se.ecutb.cheng.JPA_inlamningsuppgift.repository;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.RecipeInstruction;

import java.util.List;
import java.util.Optional;

public interface RecipeInstructionRepository extends CrudRepository <RecipeInstruction, String> {

}
