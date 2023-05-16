package ru.getlab.model;

public class Apple extends Fruit {
    private final String name = "Apple";
    private final double price = 89;
    private final double quantity;
    private final double cost;

    public Apple(double newQuantity) {
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
