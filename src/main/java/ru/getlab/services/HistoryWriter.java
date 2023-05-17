package ru.getlab.services;

import ru.getlab.model.Purchase;

import java.io.*;

public class HistoryWriter {
    private final String pathToHistoryFile = "purchaseHistory.txt";

    public HistoryWriter() {
    }

    public void writePurchaseToFile(String text) {
       try {
           File file =  new File(getPathToHistoryFile());
           if (!file.exists()) {
               file.createNewFile();
           }
           FileWriter fw =  new FileWriter(file, true);
           BufferedWriter bw =  new BufferedWriter(fw);
           bw.write(text + "\n");
           bw.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public String getPathToHistoryFile() {
        return pathToHistoryFile;
    }
}
