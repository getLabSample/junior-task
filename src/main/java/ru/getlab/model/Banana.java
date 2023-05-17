package ru.getlab.model;

import java.math.BigDecimal;

public class Banana extends Fruit {
    @Override
    public String getName() {
        return "Banana";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(20);
    }
}
