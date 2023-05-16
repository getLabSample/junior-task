package ru.getlab.model;

public class Orange extends Fruit {
    private final String name = "Orange";
    private final double price = 99;
    private final double quantity;
    private final double cost;

    public Orange(double newQuantity) {
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
