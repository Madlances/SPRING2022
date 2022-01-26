package Madsen;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

/**
 * This is our LocalStocks class. We will be able to add, remove and notify each observer.
 * It is also implementing from the Subject class, so we have it's functions in this class as well.
 * It is also reading through the Ticker.dat file and printing out the Snapshots.
 */
public class LocalStocks implements Subject<StockInfo> {
    private String date;
    private Vector<StockInfo> data;
    private Vector<Observer<StockInfo>> observers = new Vector<>();
    private Scanner scanner;

    /**
     * In the LocalStocks function we want to use scanner to read in the file.
     * @param file
     */
    public LocalStocks(File file) {
        try {
            this.scanner = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * In the Attach function we add any observer we need
     * @param o
     */
    public void Attach(Observer<StockInfo> o) {
        this.observers.add(o);
    }

    /**
     * In the Detach function, we remove any observer we don't want
     * @param o
     */
    public void Detach(Observer<StockInfo> o) {
        this.observers.remove(o);
    }

    /**
     * In the Notify function, we update the observers for any new observer we want to add
     */
    public void Notify() {
        this.observers.forEach((o) -> o.update());
    }

    /**
     * getDate function returns the date
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * getData function returns the data of Stock Info (a vector of stock info)
     * @return
     */
    public Vector<StockInfo> getData() {
        return data;
    }

    /**
     * close function will close the scanner for us
     */
    public void close() {
        this.scanner.close();
    }

    /**
     * hasMorSnapshots function will return if the scanner has a line in it
     * @return
     */
    public Boolean hasMoreSnapshots() {
        return scanner.hasNextLine();
    }

    /**
     * getSnapShot function will read through Ticker.dat, add each line it has into stockInfo so we can use it for our observers,
     * will set the date and data, notify the observers that it has been updated, and will print out each line.
     */
    public void getSnapShot() {
        Vector<StockInfo> stockInfos = new Vector<>();
        String currentDate = scanner.nextLine();

        if (!currentDate.isEmpty()) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.equals("")) {
                    StockInfo stockInfo = new StockInfo(line);
                    stockInfos.add(stockInfo);
                } else {
                    break;
                }
            }
            this.date = currentDate;
            this.data = stockInfos;
            this.Notify();
        }
    }
}
