package fr.Outmanspring.entity.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quantiter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class IngredientQuanttite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantiter;

    @ManyToOne
    private Ingredient ingredient;
}
