package fr.Outmanspring.entity.Service;
import fr.Outmanspring.entity.Entity.Categorie;
import fr.Outmanspring.entity.Repositrory.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategorieService {
    private final CategorieRepository categorieRepository;
    private final JdbcTemplate jdbcTemplate;

    public List<Categorie> findAll(){
        return categorieRepository.findAll();
    }
    public Categorie findById(Long id){
        return categorieRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found"));
    }
    public Categorie save(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    public Categorie update(Categorie categorie){
        if (categorie.getId() == null){
            save(categorie);
        }
        else {
            jdbcTemplate.update("UPDATE categorie SET nom=? WHERE id=?",
                    categorie.getNom(), categorie.getId());
        }
        return categorie;
    }
    public void deleteById(Long id){categorieRepository.deleteById(id); }
    public void deleteAll(){
        categorieRepository.deleteAll();
    }
}


