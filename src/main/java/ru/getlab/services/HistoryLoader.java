package ru.getlab.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HistoryLoader {
    private final String pathToHistoryFile = "purchaseHistory.txt";

    public String getPathToHistoryFile() {
        return pathToHistoryFile;
    }

    public String readFromInputStream() {
        StringBuilder sb = new StringBuilder();
        sb.append("************ Purchase History ************\n");
        try (BufferedReader br = new BufferedReader(new FileReader(getPathToHistoryFile()))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
