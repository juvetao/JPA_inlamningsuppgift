package se.ecutb.cheng.JPA_inlamningsuppgift.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

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

    public RecipeInstruction(String instructionId, String instructions) {
        this.instructionId = instructionId;
        this.instructions = instructions;
    }

    public RecipeInstruction(String instructions) {
        this(null, instructions);
    }

    public String getInstructionId() {
        return instructionId;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(instructionId, that.instructionId) &&
                Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructionId, instructions);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RecipeInstruction{");
        sb.append("instructionId='").append(instructionId).append('\'');
        sb.append(", instructions='").append(instructions).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
