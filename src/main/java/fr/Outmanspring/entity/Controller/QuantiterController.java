package fr.Outmanspring.entity.Controller;

import fr.Outmanspring.entity.Entity.Ingredient;
import fr.Outmanspring.entity.Entity.IngredientQuanttite;
import fr.Outmanspring.entity.Service.IngredientQuantiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class QuantiterController {

    @RestController
    @RequestMapping("/quantites")
    @RequiredArgsConstructor
    public class QuanntiterController {
        private final IngredientQuantiteService ingredientQuantiteService;

        @GetMapping("/all")
        public List<IngredientQuanttite> findall(){ return ingredientQuantiteService.findAll();}
        @GetMapping("/{id}")
        public IngredientQuanttite findById(@PathVariable Long id){ return ingredientQuantiteService.findById(id);}
        @PostMapping("/save")
        public IngredientQuanttite save(@RequestBody IngredientQuanttite ingredientQuanttite){ return ingredientQuantiteService.save(ingredientQuanttite);}
        @PatchMapping("/update")
        public IngredientQuanttite update(@RequestBody IngredientQuanttite ingredientQuanttite)
        { return ingredientQuantiteService.update(ingredientQuanttite); }
        @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable Long id){ingredientQuantiteService.deleteById(id);}
        @DeleteMapping("/delete/all")
        public void delete(){ingredientQuantiteService.deleteAll();}
    }
}
