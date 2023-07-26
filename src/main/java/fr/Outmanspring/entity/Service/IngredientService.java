package fr.Outmanspring.entity.Service;

import fr.Outmanspring.entity.Entity.Ingredient;
import fr.Outmanspring.entity.Repositrory.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final JdbcTemplate jdbcTemplate;

    public List<Ingredient> findAll(){
       return ingredientRepository.findAll();
    }
    public Ingredient findById(Long id){
        return ingredientRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found"));
    }
    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }
    public Ingredient update(Ingredient ingredient){
            if (ingredient.getId() == null){
                save(ingredient);
            }else {
                jdbcTemplate.update("UPDATE ingredient SET nom=? WHERE id=?",
                        ingredient.getNom(), ingredient.getId());
            }
        return ingredient;
    }
    public void deleteById(Long id){ingredientRepository.deleteById(id); }
    public void deleteAll(){
        ingredientRepository.deleteAll();
    }
}
