package se.ecutb.cheng.JPA_inlamningsuppgift.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.ecutb.cheng.JPA_inlamningsuppgift.entity.Ingredient;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class IngredientRepositoryTest {
    @Autowired IngredientRepository testObject;
    @Autowired TestEntityManager em;

    private List<Ingredient> data(){
        return Arrays.asList(
                new Ingredient("Ginger"),
                new Ingredient("Garlic"),
                new Ingredient("Chicken"),
                new Ingredient("Soy sauce"),
                new Ingredient("Sesame Oil"),
                new Ingredient("Oyster sauce")
        );
    }

    @BeforeEach
    void setUp(){
        List<Ingredient> persisted = data().stream()
                .map(testObject::save)
                .collect(Collectors.toList());
        em.flush();
    }

    @Test
    public void given_ingredientNameIgnoreCase_return_optional_isPresent(){
        String name = "garlic";
        Optional<Ingredient> result = testObject.findByIngredientNameIgnoreCase(name);

        assertTrue(result.isPresent());
    }

    @Test
    public void given_ingredientNameContainsIgnoreCase_return_list(){
        String name = "Sauce";
        int expectedSize = 2;
        List<Ingredient> actual = testObject.findByIngredientNameContainsIgnoreCase(name);
        int actualSize = actual.size();

        assertEquals(expectedSize, actualSize);
    }
}
