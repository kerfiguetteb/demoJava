package fr.Outmanspring.entity.Controller;

import fr.Outmanspring.entity.Entity.Ingredient;
import fr.Outmanspring.entity.Service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping("/all")
    public List<Ingredient> findall(){ return ingredientService.findAll();}
    @GetMapping("/{id}")
    public Ingredient findById(@PathVariable Long id){ return ingredientService.findById(id);}
    @PostMapping("/save")
    public Ingredient save(@RequestBody Ingredient ingredient){ return ingredientService.save(ingredient);}
    @PatchMapping("/update")
    public Ingredient update(@RequestBody Ingredient ingredient)
    { return ingredientService.update(ingredient); }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){ingredientService.deleteById(id);}
    @DeleteMapping("/delete/all")
    public void delete(){ingredientService.deleteAll();}
}
