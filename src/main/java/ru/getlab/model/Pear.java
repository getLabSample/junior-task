package ru.getlab.model;

import java.math.BigDecimal;

public class Pear extends Fruit {
    @Override
    public String getName() {
        return "Pear";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(5);
    }
}
