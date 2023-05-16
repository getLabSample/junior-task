package ru.getlab.service;

import ru.getlab.model.Fruit;

import java.io.FileWriter;
import java.io.IOException;

public class SaveAndPrint {
    // Сохранение в файл и вывод в консоль
    public static void saveAndPrint(Fruit fruit) throws IOException {
        System.out.println(fruit);
        FileWriter writer = new FileWriter("Save.csv", true);
        writer.write(String.valueOf(fruit)+ '\n');
        writer.flush();
    }
}
