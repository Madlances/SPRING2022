package Madsen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class will implement the Observer class, as well as write to Change10.dat file,
 * and show all companies that have had a price change of 10% or more.
 */
public class Change10 implements Observer<StockInfo> {
    File file;
    LocalStocks subject;
    BufferedWriter writer;
    
    /**
     * This function will crete our buffered writer to write to the Selections.dat file
     * @param file
     * @param subject
     */
    public Change10(File file, LocalStocks subject) {
        this.file = file;
        this.subject = subject;
        try {
            this.writer = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function will close the writer for us
     */
    public void close() {
        try {
            this.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function will append the update and the percent change of 10% or greate of each company to the Change10.dat file
     */
    public void update() {
        try {
            this.writer.append(subject.getDate().replace("Last updated ", "") + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < subject.getData().size(); i++) {
            if (subject.getData().get(i).percentChange >= 10.00 || subject.getData().get(i).percentChange <= -10.00) {
                String change10 = subject.getData().get(i).tickerSymbol + " " + subject.getData().get(i).currentPrice + " " + subject.getData().get(i).percentChange;
                try {
                    this.writer.append(change10 + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
