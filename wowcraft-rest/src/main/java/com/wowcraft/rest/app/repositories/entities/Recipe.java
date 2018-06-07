package com.wowcraft.rest.app.repositories.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeReagent> reagents;
    @Column(name = "current_price")
    private BigDecimal currentPrice;

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

    public List<RecipeReagent> getReagents() {
        return reagents;
    }

    public void setReagents(List<RecipeReagent> reagents) {
        this.reagents = reagents;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }
}
