package ru.getlab;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        Scanner sc = new Scanner(System.in);

        while(true){



            System.out.println("Меню");
            System.out.println("Выберете необходимый пункт меню из списка:");
            System.out.println("1. Сделать заказ");
            System.out.println("2. История заказов");
            System.out.println("3. Поиск по критерию");
            System.out.println("4. Выход");

            int c = sc.nextInt();

            switch (c) {
                case 1:
                    System.out.println("Выберете необходимый номер товара из списка.");
                    List<Product> productList = orderManager.productList();
                    System.out.println("Список продуктов:");
                    for (int i = 0; i < productList.size(); i++) {
                        System.out.println((i + 1) + ". " + productList.get(i).getName());
                    }
                    int choise = sc.nextInt();
                    sc.nextLine();
                    if (choise < 1|| choise > 5){
                        System.out.println("Вы выбрали неправильный номер товара.");
                    }else {
                        Product sProduct = orderManager.productList().get(choise-1);
                        System.out.println("Укажите необходимое колличество товара.");
                        int quantity = sc.nextInt();
                        sc.nextLine();
                        orderManager.getOrders(sProduct, quantity);
                        System.out.println("Заказ создан.");}
                    break;
                case 2:
                    orderManager.printOrdersHistory();
                    break;
                case 3:
                    System.out.println("Введите критерий поиска: ");
                    sc.nextLine();
                    String cr = sc.nextLine();
                    orderManager.searchOrdersByCriteria(cr);
                    System.out.println();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default: System.out.println("Вы ввели неправильный пункт меню. Попробуйте еще раз.");
                    break;
            }
        }



    }

}
