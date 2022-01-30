package Madsen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class will implement the Observer class, as well as write to Selections.dat file,
 * and only return the following companies: ALL, BA, BC, GBEL, KFT, MCD, TR, WAG
 */
public class Selections implements Observer<StockInfo> {
    File file;
    LocalStocks subject;
    BufferedWriter writer;
    
    /**
     * This function will crete our buffered writer to write to the Selections.dat file
     * @param file
     * @param subject
     */
    public Selections(File file, LocalStocks subject) {
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
     * This function will append the update and the specific companies we want to the Selections.dat file
     */
    public void update() {
        try {
            this.writer.append(subject.getDate() + ":\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < subject.getData().size(); i++) {
            if (subject.getData().get(i).tickerSymbol.equals("ALL") || subject.getData().get(i).tickerSymbol.equals("BA")
                || subject.getData().get(i).tickerSymbol.equals("BC") || subject.getData().get(i).tickerSymbol.equals("GBEL")
                || subject.getData().get(i).tickerSymbol.equals("KFT") || subject.getData().get(i).tickerSymbol.equals("MCD")
                || subject.getData().get(i).tickerSymbol.equals("TR") || subject.getData().get(i).tickerSymbol.equals("WAG")) {
                String selections = subject.getData().get(i).company + " " + subject.getData().get(i).tickerSymbol + " " +
                    subject.getData().get(i).currentPrice + " " + subject.getData().get(i).dollarChange + " " +
                    subject.getData().get(i).percentChange + " " + subject.getData().get(i).ytdPercentChange + " " +
                    subject.getData().get(i).weeks52High + " " + subject.getData().get(i).weeks52Low + " " + subject.getData().get(i).peRatio;
                try {
                    this.writer.append(selections + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } 
        try {
            this.writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
