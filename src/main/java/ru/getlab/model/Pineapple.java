package ru.getlab.model;

import java.math.BigDecimal;

public class Pineapple extends Fruit {
    @Override
    public String getName() {
        return "Pineapple";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(60);
    }
}
