package Madsen;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * This class wil take in the Ticker.dat file, and split each part of the line to the specified fields:
 * Company, Ticker Symbol, Current Price, $ Change, % Change, YTD % Change, 52-Week High, 52-Week Low. P/E Ratio
 */
public class StockInfo {
    public String company;
    public String tickerSymbol;
    public Double currentPrice;
    public Double dollarChange;
    public Double percentChange;
    public Double ytdPercentChange;
    public Double weeks52High;
    public Double weeks52Low;
    public Double peRatio;

    public StockInfo(String line) {
        LinkedList<String> splitLine = new LinkedList<>(Arrays.asList(line.split("\s+"))); // put each part into a list
        if (splitLine.peekLast().equals("-")) { // ignore dashes
            splitLine.pollLast();
            this.peRatio = null;
        } else { // if p/e ratio is not a dash
            System.out.println(line);
            this.peRatio = Double.parseDouble(splitLine.pollLast());
        } // then we set each to the right field
        this.weeks52Low = Double.parseDouble(splitLine.pollLast());
        this.weeks52High = Double.parseDouble(splitLine.pollLast());
        this.ytdPercentChange = Double.parseDouble(splitLine.pollLast());
        this.percentChange = Double.parseDouble(splitLine.pollLast());
        this.dollarChange = Double.parseDouble(splitLine.pollLast());
        this.currentPrice = Double.parseDouble(splitLine.pollLast());
        this.tickerSymbol = splitLine.pollLast();
        this.company = String.join(" ", splitLine);
    }
}
