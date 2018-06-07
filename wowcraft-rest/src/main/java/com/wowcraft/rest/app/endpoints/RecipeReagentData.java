package com.wowcraft.rest.app.endpoints;

import java.math.BigDecimal;

public class RecipeReagentData {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer count;

    public RecipeReagentData() {
    }

    public RecipeReagentData(Integer id, String name, BigDecimal price, Integer count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
