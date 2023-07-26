package fr.Outmanspring.entity.Repositrory;

import fr.Outmanspring.entity.Entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository <Categorie, Long > {
}
