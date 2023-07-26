package fr.Outmanspring.entity.Controller;

import fr.Outmanspring.entity.Entity.Categorie;
import fr.Outmanspring.entity.Service.CategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategorieController {
    private final CategorieService categorieService;

    @GetMapping("/all")
    public List<Categorie> findall(){ return categorieService.findAll();}
    @GetMapping("/{id}")
    public Categorie findById(@PathVariable Long id){ return categorieService.findById(id);}
    @PostMapping("/save")
    public Categorie save(@RequestBody Categorie ingredient){ return categorieService.save(ingredient);}
    @PatchMapping("/update")
    public Categorie update(@RequestBody Categorie ingredient)
    { return categorieService.update(ingredient); }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){categorieService.deleteById(id);}
    @DeleteMapping("/delete/all")
    public void delete(){categorieService.deleteAll();}
}