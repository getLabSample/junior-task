package ru.getlab.model;

import java.math.BigDecimal;

public class Orange extends Fruit {
    @Override
    public String getName() {
        return "Orange";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(30);
    }
}
