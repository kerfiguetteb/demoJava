package fr.Outmanspring.entity.Repositrory;

import fr.Outmanspring.entity.Entity.IngredientQuanttite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientQuantiteRepository extends JpaRepository<IngredientQuanttite, Long> {
}
