package com.wowcraft.rest.app.endpoints;

import com.wowcraft.rest.app.repositories.entities.Recipe;
import one.util.streamex.StreamEx;

import java.math.BigDecimal;
import java.util.List;

public class RecipeData {
    private Integer id;
    private String name;
    private List<RecipeReagentData> reagents;
    private BigDecimal currentPrice;

    public RecipeData() {
    }

    public RecipeData(Recipe recipe) {
        this.id = recipe.getId();
        this.name = recipe.getName();
        this.reagents = StreamEx.of(recipe.getReagents())
                                .map(reagent -> new RecipeReagentData(reagent.getId(),
                                                                      reagent.getReagent().getName(),
                                                                      reagent.getReagent().getPrice(),
                                                                      reagent.getCount()))
                                .toList();
        this.currentPrice = recipe.getCurrentPrice();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeReagentData> getReagents() {
        return reagents;
    }

    public void setReagents(List<RecipeReagentData> reagents) {
        this.reagents = reagents;
    }
}
