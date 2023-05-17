package ru.getlab.model;

import java.math.BigDecimal;

/**
 * Parent-class for every fruit.
 */
public class Fruit {
    String name;
    BigDecimal price;

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
}
