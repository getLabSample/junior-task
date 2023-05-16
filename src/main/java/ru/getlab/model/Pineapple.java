package ru.getlab.model;

public class Pineapple extends Fruit {
    private final String name = "Pineapple";
    private final double price = 239;
    private final double quantity;
    private final double cost;

    public Pineapple(double newQuantity) {
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
