package com.wowcraft.rest.app.service;

import com.wowcraft.rest.app.endpoints.RecipeData;
import com.wowcraft.rest.app.endpoints.RecipeReagentData;
import com.wowcraft.rest.app.repositories.ReagentRepo;
import com.wowcraft.rest.app.repositories.RecipeRepo;
import com.wowcraft.rest.app.repositories.entities.Recipe;
import com.wowcraft.rest.app.repositories.entities.RecipeReagent;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;

@Component
public class RecipeService {
    private final ReagentRepo reagentRepo;
    private final RecipeRepo recipeRepo;

    public RecipeService(ReagentRepo reagentRepo, RecipeRepo recipeRepo) {
        this.reagentRepo = reagentRepo;
        this.recipeRepo = recipeRepo;
    }


    public void add(RecipeData recipeData) {
        checkArgument(recipeData.getId() == null,
                      "Possibly attempt to add existing recipe. Recipe ID should not be set");

        Recipe recipe = recipeFromData(recipeData);
        recipeRepo.save(recipe);
    }

    private Recipe recipeFromData(RecipeData recipeData) {
        Recipe recipe = new Recipe();
        List<RecipeReagent> recipeReagents = StreamEx.of(recipeData.getReagents())
                                                     .mapToEntry(RecipeReagentData::getId, Function.identity())
                                                     .mapKeys(reagentRepo::findById)
                                                     .mapKeys(Optional::get)
                                                     .mapValues(RecipeReagentData::getCount)
                                                     .mapKeyValue((reagent, count) -> RecipeReagent.create(recipe, reagent, count))
                                                     .toList();
        recipe.setName(recipeData.getName());
        recipe.setReagents(recipeReagents);
        return recipe;
    }

    public List<RecipeData> findAll() {
        return recipeRepo.findAll()
                         .stream()
                         .map(RecipeData::new)
                         .collect(Collectors.toList());

    }
}
