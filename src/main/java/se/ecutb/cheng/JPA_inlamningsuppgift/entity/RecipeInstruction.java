package se.ecutb.cheng.JPA_inlamningsuppgift.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "instruction_id")
    private String instructionId;
    private String instructions;
}
