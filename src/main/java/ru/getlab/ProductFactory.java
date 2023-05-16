package ru.getlab;

import java.util.ArrayList;
import java.util.List;

public class ProductFactory { // класс для инициализации продукт и работы
    private static final List<Product> products = new ArrayList<>(); // Структура для хранения продуктов. Был вариант сделать на мапе,
    // но мапа не кладет по порядку.


    static { // статический блок инициализации листа продуктов
        products.add(new Product("Яблоко", 100.0)); // добавляем продукт
        products.add(new Product("Банан", 150.6)); // добавляем продукт
        products.add(new Product("Апельсин", 50.5)); // добавляем продукт
        products.add(new Product("Груша", 99.1)); // добавляем продукт
        products.add(new Product("Ананас", 250.5)); // добавляем продукт
    }

    public Product getProduct(int productIndex) { // поиск продукта по индексу
        return products.get(productIndex); // берем лист и получаем продукт по индексу
    }

    public void getProductList() { // вывод всех продуктов
        int i = 0; // цифра для имитации ID
        for (Product product : products) { // цикл фор ич
            System.out.println(++i + " " + product.getName()); // вывод в консоль id(который потом мы используем для выбора продукта
        }
    }
}
