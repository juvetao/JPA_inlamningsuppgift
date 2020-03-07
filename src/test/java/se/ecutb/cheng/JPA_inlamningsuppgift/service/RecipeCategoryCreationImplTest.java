package se.ecutb.cheng.JPA_inlamningsuppgift.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.RecipeCategory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
public class RecipeCategoryCreationImplTest {
    @Autowired
    private RecipeCategoryCreation recipeCategoryCreation;

    @Test
    public void create_RecipeCategory_test_category(){
        String category = "Test";
        RecipeCategory actual = recipeCategoryCreation.create(category);
        assertNotNull(actual);
    }
}
