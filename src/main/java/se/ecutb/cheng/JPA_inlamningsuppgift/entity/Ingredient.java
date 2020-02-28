package se.ecutb.cheng.JPA_inlamningsuppgift.entity;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private int ingredientId;
    @Column(unique = true)
    private String ingredientName;
}
