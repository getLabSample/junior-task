package ru.getlab.model;

public class Pear extends Fruit {
    private final String name = "Pear";
    private final double price = 129;
    private final double quantity;
    private final double cost;

    public Pear(double newQuantity) {
        quantity = newQuantity;
        cost = price * quantity;
    }

    @Override
    public String toString() {
        return  "Наименование='" + name + '\'' +
                ", Цена=" + price +
                ", Количество=" + quantity +
                ", Общая стоимость=" + cost;
    }
}
