package ru.getlab.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HistoryPrint {
    // Вывод истории всех покупок
    public static void historyPrint() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Save.csv"));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        reader.close();
    }
}
