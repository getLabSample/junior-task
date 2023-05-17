package ru.getlab.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class allows us to collect purchase history.
 */
public class HistoryWriter {
    private static final String PATH_TO_HISTORY_FILE = "purchaseHistory.txt";

    public void writePurchaseToFile(String text) {
        BufferedWriter bw = null;
       try {
           File file =  new File(getPathToHistoryFile());
           if (!file.exists()) {
               file.createNewFile();
           }
           FileWriter fw =  new FileWriter(file, true);
           bw =  new BufferedWriter(fw);
           bw.write(text + "\n");

       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               if(bw != null){
                   bw.close();
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }

    public String getPathToHistoryFile() {
        return PATH_TO_HISTORY_FILE;
    }
}
