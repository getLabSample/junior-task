package ru.getlab;

import java.util.List;
import java.util.Scanner;

public class PurchaseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PurchaseManager purchaseManager = new PurchaseManager();

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Просмотреть доступные продукты");
            System.out.println("2. Добавить покупку");
            System.out.println("3. Просмотреть историю покупок");
            System.out.println("4. Поиск покупок по критерию");
            System.out.println("5. Выйти из программы");
            System.out.print("Выберите пункт меню (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Чтение символа новой строки после ввода числа

            switch (choice) {
                case 1:
                    List<Product> products = purchaseManager.getAvailableProducts();
                    System.out.println("Доступные продукты:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i).getName());
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Введите номер продукта: ");
                    int productNumber = scanner.nextInt();
                    scanner.nextLine(); // Чтение символа новой строки после ввода числа

                    if (productNumber < 1 || productNumber > 5) {
                        System.out.println("Неверный номер продукта.");
                        break;
                    }

                    Product selectedProduct = purchaseManager.getAvailableProducts().get(productNumber - 1);

                    System.out.println("Введите количество: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Чтение символа новой строки после ввода числа

                    purchaseManager.addPurchase(selectedProduct, quantity);
                    System.out.println("Покупка успешно добавлена.");
                    System.out.println();
                    break;
                case 3:
                    purchaseManager.printPurchaseHistory();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Введите критерий поиска: ");
                    String searchCriteria = scanner.nextLine();
                    purchaseManager.searchPurchasesByCriteria(searchCriteria);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте ещё раз.");
                    System.out.println();
                    break;
            }
        }
    }
}
