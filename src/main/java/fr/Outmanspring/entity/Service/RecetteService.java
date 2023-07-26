package fr.Outmanspring.entity.Service;

import fr.Outmanspring.entity.Entity.Recette;
import fr.Outmanspring.entity.Repositrory.RecetteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecetteService {

    private final RecetteRepository recetteRepository;
    private final JdbcTemplate jdbcTemplate;

    public List<Recette> findAll(){
        return recetteRepository.findAll();
    }
    public Recette findById(Long id){
        return recetteRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Recette not found"));
    }
    public Recette save(Recette recette){
        return recetteRepository.save(recette);
    }
    public Recette update(Recette recette){
        if (recette.getId() == null){
            save(recette);
        }
        else {
            jdbcTemplate.update("UPDATE recette SET nom=? description=? WHERE id=?",
                    recette.getNom(), recette.getDescription() ,recette.getId());
        }
        return recette;
    }
    public void deleteById(Long id){recetteRepository.deleteById(id); }
    public void deleteAll(){
        recetteRepository.deleteAll();
    }
}
