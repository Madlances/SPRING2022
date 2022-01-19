package StrategyPattern;

/**
 * This is our QuickSort class. This inherits the super class Sort
 */
public class QuickSort implements Sort {
    /**
     * Needs a sort function just like the class Sort since we are using composition here.
     * We only need to display a message of the sort, not actually code the algorithm.
     */
    public void sort() {
        System.out.println("Quick Sort List:");
    }
}
