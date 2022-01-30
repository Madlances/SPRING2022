package Madsen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class will implement the Observer class, as well as write to Average.dat file,
 * and show the average of all local stock prices of each snapshot, along with the time the snapshot was taken.
 */
public class Average implements Observer<StockInfo> {
    File file;
    LocalStocks subject;
    BufferedWriter writer;

    /**
     * This function will crete our buffered writer to write to the Selections.dat file
     * @param file
     * @param subject
     */
    public Average(File file, LocalStocks subject) {
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
     * This function will append the averages of each updatedd time to the Average.dat file
     */
    public void update() {
        Double sum = 0.0;
        for (int i = 0; i < subject.getData().size(); i++) {
            sum += subject.getData().get(i).currentPrice;
        }
        Double average = (sum / subject.getData().size());
        try {
            this.writer.append(subject.getDate().replace("Last updated ", "") + ", Average Price: " + average + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
