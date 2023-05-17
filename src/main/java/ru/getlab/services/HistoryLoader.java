package ru.getlab.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class allows us to read purchase history.
 */
public class HistoryLoader {
    private static final String PATH_TO_HISTORY_FILE = "purchaseHistory.txt";

    public String getPathToHistoryFile() {
        return PATH_TO_HISTORY_FILE;
    }

    public String readFromInputStream() {
        StringBuilder sb = new StringBuilder();
        sb.append("************ Purchase History ************\n");
        try (BufferedReader br = new BufferedReader(new FileReader(getPathToHistoryFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
