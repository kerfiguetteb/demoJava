package fr.Outmanspring.entity.Controller;
import fr.Outmanspring.entity.Entity.Recette;
import fr.Outmanspring.entity.Service.RecetteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recettes")
@RequiredArgsConstructor
public class RecetteController {
    private final RecetteService recetteService;

    @GetMapping("/all")
    public List<Recette> findall(){ return recetteService.findAll();}
    @GetMapping("/{id}")
    public Recette findById(@PathVariable Long id){ return recetteService.findById(id);}
    @PostMapping("/save")
    public Recette save(@RequestBody Recette recette){ return recetteService.save(recette);}
    @PatchMapping("/update")
    public Recette update(@RequestBody Recette recette)
    { return recetteService.update(recette); }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){recetteService.deleteById(id);}
    @DeleteMapping("/delete/all")
    public void delete(){recetteService.deleteAll();}
}