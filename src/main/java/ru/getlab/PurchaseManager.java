package ru.getlab;

import java.io.*;
import java.util.*;
import java.util.regex.*;


class PurchaseManager {
    private List<Purchase> purchases;
    private static final String FILE_NAME = "purchase_history.txt";

    public PurchaseManager() {
        purchases = new ArrayList<>();
        loadPurchaseHistory();
    }

    public List<Product> getAvailableProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Яблоки", 2.5));
        products.add(new Product("Бананы", 3.0));
        products.add(new Product("Апельсины", 2.0));
        products.add(new Product("Груши", 2.8));
        products.add(new Product("Ананасы", 5.0));
        return products;
    }

    public void addPurchase(Product product, int quantity) {
        Purchase purchase = new Purchase(product, quantity);
        purchases.add(purchase);
        savePurchaseHistory();
    }

    private void savePurchaseHistory() {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(purchases);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении истории покупок: " + e.getMessage());
        }
    }

    private void loadPurchaseHistory() {
        try {
            FileInputStream fileIn = new FileInputStream(FILE_NAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            purchases = (List<Purchase>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке истории покупок: " + e.getMessage());
        }
    }

    public void printPurchaseHistory() {
        System.out.println("История покупок:");
        if (purchases.isEmpty()) {
            System.out.println("Покупок не найдено.");
        } else {
            for (Purchase purchase : purchases) {
                System.out.println("Продукт: " + purchase.getProduct().getName());
                System.out.println("Количество: " + purchase.getQuantity());
                System.out.println("Сумма: " + purchase.getTotalPrice());
                System.out.println("--------------------");
            }
        }
    }

    public void searchPurchasesByCriteria(String criteria) {
        System.out.println("Результаты поиска по критерию '" + criteria + "':");
        Pattern pattern = Pattern.compile(criteria, Pattern.CASE_INSENSITIVE);
        int count = 0;
        for (Purchase purchase : purchases) {
            String productName = purchase.getProduct().getName();
            Matcher matcher = pattern.matcher(productName);
            if (matcher.find()) {
                System.out.println("Продукт: " + productName);
                System.out.println("Количество: " + purchase.getQuantity());
                System.out.println("Сумма: " + purchase.getTotalPrice());
                System.out.println("--------------------");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Покупки по указанному критерию не найдены.");
        }
    }
}