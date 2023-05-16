package ru.getlab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataService { // сервис для работы с данными
    public void savePurchaseData(String productName, double productPrice, int quantity, double totalPrice) { // метод для сохранения данных в файл
        LocalDateTime now = LocalDateTime.now(); // время записи
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // паттерн формата даты
        String timestamp = now.format(formatter);

        String purchaseData = "Дата/время: " + timestamp + " "  // формируем строку, которая будет сохраняться в файле
                + "Продукт: " + productName + ". "
                + "Цена: " + productPrice + "руб. "
                + "Количество: " + quantity + ". "
                + "Сумма: " + totalPrice + " руб.\n\n";

        try (FileWriter fileWriter = new FileWriter("purchase_data.txt", true)) { // открываем try с ресурсами для записи и создания файла
            fileWriter.write(purchaseData); // записываем в файл наши данные
            System.out.println("Данные о покупке сохранены в файл."); // делаем лог
        } catch (IOException e) { // в случае ошибки - ловим ее и ...
            System.out.println("Ошибка при сохранении данных о покупке."); //... и делам лог
        }
    }

    public void displayPurchaseHistory() { // метод для показа данных
        try (BufferedReader reader = new BufferedReader(new FileReader("purchase_data.txt"))) { // открываем try с ресурсом для чтения из файла
            String line; // обозначаем строчку
            while ((line = reader.readLine()) != null) { // цикл для чтения из файла, пока там есть данные (в обозначенную строчку записываем строку из файла)
                System.out.println(line); // построчно выводим обозначенную строку, если она не пустая
            }
        } catch (IOException e) { // если возникает ошибка отлавливаем ее
            System.out.println("Ошибка при чтении файла."); // лог
        }
        /**
         * Для правильной работы кода необходимо наличие файла и содержимого.
         * При первом обращении к меню продукта и нажатии записи файл создается
         * и записывает данные, следовательно, метод будет работать корректно
         */
    }

    public void searchPurchases() {
        Scanner scanner = new Scanner(System.in); // открываем сканнер и передаем его в try с ресурсами для автоматического закрытия
        System.out.print("Введите критерий поиска: "); // уведомление
        String searchCriteria = scanner.nextLine(); //запись в переменную входных данных от юзера

        try (BufferedReader reader = new BufferedReader(new FileReader("purchase_data.txt"))) { // открываем ридер для чтения из файла
            String line; // обозначаем строку в которую будем записывать данные из файла
            Pattern pattern = Pattern.compile(searchCriteria, Pattern.CASE_INSENSITIVE);
            // FIXME: почему то чувствителен к регистру, возможно из-за кодировки,
            //  так как по умолчанию нечувствительное к регистру соответствие предполагает,
            //  что только символы в наборе символов US-ASCII являются соответствующими.

            System.out.println("Результаты поиска:"); // уведомление о конце поиска

            while ((line = reader.readLine()) != null) { // цикл для чтения из файла, пока там есть данные (в обозначенную строчку записываем строку из файла)
                Matcher matcher = pattern.matcher(line); // создаем мэтчер с использованием паттерна для поиска совпадений
                if (matcher.find()) { // если мэтчер находит совпадение то ...
                    System.out.println(line); // ... выводим строку в консоль
                }
            }
        } catch (IOException e) { // если возникает ошибка ввода\вывода данных обрабатываем
            System.out.println("Ошибка при чтении файла."); // лог
        }

    }
}