package ru.getlab.model;

public class Banana extends Fruit {
    private final String name = "Banana";
    private final double price = 79;
    private final double quantity;
    private final double cost;

    public Banana(double newQuantity) {
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
