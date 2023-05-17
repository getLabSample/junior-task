package ru.getlab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderManager {

    private List<Order> orders;
    private static final String FILE_NAME = "Orders.txt";

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public List<Product> productList (){
        List<Product> listOfProducts = new ArrayList<>();

        listOfProducts.add(new Product("Яблоки", 10));
        listOfProducts.add(new Product("Бананы", 15));
        listOfProducts.add(new Product("Апельсины", 30));
        listOfProducts.add(new Product("Груши", 20));
        listOfProducts.add(new Product("Ананасы", 50));
        return listOfProducts;
    }

    public void getOrders(Product product, int quantity) {
        Order order = new Order(product, quantity);
        orders.add(order);
        saveOrdersHistory();
    }

    private void saveOrdersHistory() {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(orders);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {

        }
    }

    private void loadOrdersHistory() {
        try {
            FileInputStream fileIn = new FileInputStream(FILE_NAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            orders = (List<Order>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {

        }
    }

    public void printOrdersHistory() {
        System.out.println("История заказов:");
        if (orders.isEmpty()) {
            System.out.println("Заказы не найдены.");
        } else {
            for (Order order : orders) {
                System.out.println("Товар: " + order.getProduct().getName());
                System.out.println("Количество: " + order.getQuantity());
                System.out.println("Итого: " + order.getTotal());
                System.out.println("=============================");
            }
        }
    }

    public void searchOrdersByCriteria(String cr) {

        System.out.println("Результаты поиска по заданному критерию '" + cr + "':");
        Pattern pattern = Pattern.compile(cr, Pattern.CASE_INSENSITIVE);
        int count = 0;
        for (Order order : orders) {
            String product = order.getProduct().getName();
            Matcher matcher = pattern.matcher(product);
            if (matcher.find()) {
                System.out.println("Товар: " + order.getProduct().getName());
                System.out.println("Количество: " + order.getQuantity());
                System.out.println("Итого: " + order.getTotal());
                System.out.println("=============================");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Заказы по указанному критерию не обнаружены.");
        }
    }
}
