package ru.getlab.model;

import java.math.BigDecimal;

public class Apple extends Fruit {
    @Override
    public String getName() {
        return "Apple";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(10);
    }
}
