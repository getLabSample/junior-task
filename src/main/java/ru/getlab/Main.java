package ru.getlab;

import ru.getlab.model.*;

import java.io.IOException;
import java.util.Scanner;

import static ru.getlab.service.Find.find;
import static ru.getlab.service.HistoryPrint.historyPrint;
import static ru.getlab.service.PrintFruit.printFruit;
import static ru.getlab.service.PrintMenu.printMenu;
import static ru.getlab.service.SaveAndPrint.saveAndPrint;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello Teamlead!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();                                                             // Вызов меню
            int command = scanner.nextInt();

            if (command == 1) {                                                      // Выбор продукта
                while (true) {
                    printFruit();
                    int fruit = scanner.nextInt();

                    if (fruit == 1) {
                        System.out.println("Введите количество");
                        Apple apple = new Apple(scanner.nextDouble());
                        saveAndPrint(apple);

                    } else if (fruit == 2) {
                        System.out.println("Введите количество");
                        Banana banana = new Banana(scanner.nextDouble());
                        saveAndPrint(banana);

                    } else if (fruit == 3) {
                        System.out.println("Введите количество");
                        Orange orange = new Orange(scanner.nextDouble());
                        saveAndPrint(orange);

                    } else if (fruit == 4) {
                        System.out.println("Введите количество");
                        Pear pear = new Pear(scanner.nextDouble());
                        saveAndPrint(pear);

                    } else if (fruit == 5) {
                        System.out.println("Введите количество");
                        Pineapple pineapple = new Pineapple(scanner.nextDouble());
                        saveAndPrint(pineapple);

                    } else if (fruit == 0) {
                        break;

                    } else {
                        System.out.println("Такой команды нет!");
                    }
                }

            } else if (command == 2) {                                                 // Вывод истории всех покупок
                historyPrint();

            } else if (command == 3) {                                                 // Поиск покупок
                System.out.println("Введите критерий поиска");
                String text = scanner.next();
                find(text);

            } else if (command == 0) {                                                 // Выход из программы
                System.out.println("Выход...");
                return;

            } else {
                System.out.println("Такой команды нет!");
            }
        }
    }
}

