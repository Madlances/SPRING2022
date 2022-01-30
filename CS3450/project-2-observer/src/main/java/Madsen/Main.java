/**
 * @author Kassandra Madsen
 * CS 3450
 * Project 2 - Observer Pattern
 */
package Madsen;

import java.io.File;

/**
 * This is our Main/Driver program. It will use the Local Stocks, Average, Change10, and Selections classes
 * to get the specified data we want in Average.dat, Change.dat, and Selections.dat files.
 */
public class Main 
{
    /**
     * This is our main function that will attach Average.dat, Change10.dat, and Selections.dat files to
     * localStocks to be able to run through the main file Ticker.dat, to get the information they each need.
     * @param args
     */
    public static void main( String[] args ) {
        // all the files we need
        File tickerFile = new File(".\\src\\main\\java\\Madsen\\Ticker.dat");
        LocalStocks localStocks = new LocalStocks(tickerFile); // reads through Ticker.dat
        Average average = new Average(new File(".\\src\\main\\java\\Madsen\\Average.dat"), localStocks);
        Change10 change10 = new Change10(new File(".\\src\\main\\java\\Madsen\\Change10.dat"), localStocks);
        Selections selections = new Selections(new File(".\\src\\main\\java\\Madsen\\Selections.dat"), localStocks);

        // attaches each file to localStocks for each observer
        localStocks.Attach(average);
        localStocks.Attach(change10);
        localStocks.Attach(selections);

        // this returns the snapshot of Ticker.dat that each file can get specific information out of
        while (localStocks.hasMoreSnapshots()) {
            localStocks.getSnapShot();
        }

        // we will close the scanner and bufferedReader here
        localStocks.close();
        average.close();
        change10.close();
        selections.close();
    }
}
