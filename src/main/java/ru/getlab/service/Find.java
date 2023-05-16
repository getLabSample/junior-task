package ru.getlab.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class Find {
    // Поиск покупок
    public static void find(String text) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Save.csv"));
        String line = reader.readLine();
        while (line != null) {
            Pattern pattern = Pattern.compile(text, CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                System.out.println(line);
            }
            line = reader.readLine();
        }
        reader.close();
    }
}
