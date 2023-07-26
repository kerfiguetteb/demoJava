package fr.Outmanspring.entity.Service;
import fr.Outmanspring.entity.Entity.IngredientQuanttite;
import fr.Outmanspring.entity.Repositrory.IngredientQuantiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientQuantiteService {
    private final IngredientQuantiteRepository quantiteRepository;
    private final JdbcTemplate jdbcTemplate;

    public List<IngredientQuanttite> findAll(){
        return quantiteRepository.findAll();
    }
    public IngredientQuanttite findById(Long id){
        return quantiteRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found"));
    }
    public IngredientQuanttite save(IngredientQuanttite ingredientQuanttite){
        return quantiteRepository.save(ingredientQuanttite);
    }
    public IngredientQuanttite update(IngredientQuanttite ingredientQuanttite){
        if (ingredientQuanttite.getId() == null){
            save(ingredientQuanttite);
        }else {
            jdbcTemplate.update("UPDATE quantiter SET quantiter=? WHERE id=?",
                    ingredientQuanttite.getQuantiter());
        }
        return ingredientQuanttite;
    }
    public void deleteById(Long id){quantiteRepository.deleteById(id); }
    public void deleteAll(){
        quantiteRepository.deleteAll();
    }
}


