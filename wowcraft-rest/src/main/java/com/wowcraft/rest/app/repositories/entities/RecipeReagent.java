package com.wowcraft.rest.app.repositories.entities;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "recipe_reagent")
public class RecipeReagent {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
    @ManyToOne
    @JoinColumn(name = "reagent_id")
    private Reagent reagent;
    @Column(name = "count")
    private int count;

    public static RecipeReagent create(Recipe recipe, Reagent reagent, int count) {
        RecipeReagent recipeReagent = new RecipeReagent();
        recipeReagent.setRecipe(recipe);
        recipeReagent.setReagent(reagent);
        recipeReagent.setCount(count);
        return recipeReagent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reagent getReagent() {
        return reagent;
    }

    public void setReagent(Reagent reagent) {
        this.reagent = reagent;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeReagent that = (RecipeReagent) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(recipe, that.recipe) &&
                Objects.equals(reagent, that.reagent) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
