package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static List<Product> products = new ArrayList<Product>();
    static String filename = "purchases.txt";

    static {
        products.add(new Product("Яблоки", 10));
        products.add(new Product("Бананы", 20));
        products.add(new Product("Апелсины", 30));
        products.add(new Product("Груши", 40));
        products.add(new Product("Ананасы", 50));
    }

    public static void savePurchase(Purchase purchase) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            fw.write(purchase.toString() + "\n");
            fw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void printPurchaseHistory() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchPurchases(String patternString) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1. Сделать покупу");
            System.out.println("2. Вывести историю покупок");
            System.out.println("3. Поиск покупок");
            System.out.println("4. Закончить покупки");
            int choice = scanner.nextInt();
            if(choice == 1) {
                for(int i=0; i<products.size(); i++) {
                    System.out.println((i+1) + ". " + products.get(i).name + " - " + products.get(i).price);
                }
                int productChoice = scanner.nextInt();
                System.out.println("Введите количество:");
                int quantity = scanner.nextInt();
                Purchase purchase = new Purchase(products.get(productChoice-1), quantity);
                savePurchase(purchase);
                System.out.println("Покупка сохранена!");
            } else if(choice == 2) {
                printPurchaseHistory();
            } else if(choice == 3) {
                System.out.println("Введите шаблон поиска:");
                scanner.nextLine(); // consume newline
                String pattern = scanner.nextLine();
                searchPurchases(pattern);
            } else if(choice == 4) {
                break;
            }
        }
        scanner.close();
    }

}