package StrategyPattern;

/**
 * This is our MergeSort class. This inherits the super class Sort
 */
public class MergeSort implements Sort {
    /**
     * Needs a sort function just like the class Sort since we are using composition here.
     * We only need to display a message of the sort, not actually code the algorithm.
     */
    public void sort() {
        System.out.println("Merge Sort List:");
    }
}
