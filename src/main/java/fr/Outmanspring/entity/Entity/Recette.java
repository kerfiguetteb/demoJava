package fr.Outmanspring.entity.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    private String description;

    @OneToMany
    private List<IngredientQuanttite> ingredientQuanttites;

    @ManyToMany
    @JoinTable( name = "recette_categorie",
            joinColumns = @JoinColumn(name = "recette_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id") )
    private List<Categorie> categories;
}
