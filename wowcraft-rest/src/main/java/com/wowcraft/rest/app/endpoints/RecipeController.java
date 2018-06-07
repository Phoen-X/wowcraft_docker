package com.wowcraft.rest.app.endpoints;

import com.wowcraft.rest.app.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public void create(@RequestBody RecipeData recipeData) {
        recipeService.add(recipeData);
    }

    @GetMapping
    public List<RecipeData> findAll() {
        return recipeService.findAll();
    }
}
