package ru.getlab;

public class Product { // класс-сущность продукт
    private String name; // поле имя продукта
    private double price; // поле цена продукта

    public Product(String name, double price) { // конструктор продукта
        this.name = name;
        this.price = price;
    }

    public Product() { // конструктор без параметров (можно убрать YAGNI)
    }

// геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    // переопределение метода toString для корректного отображения в консоли
    @Override
    public String toString() {
        return "Продукт " + name  + ", цена= " + price;
    }
}
