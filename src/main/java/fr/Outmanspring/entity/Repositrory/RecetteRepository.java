package fr.Outmanspring.entity.Repositrory;
import fr.Outmanspring.entity.Entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long> {}
