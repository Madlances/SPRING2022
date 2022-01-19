/**
 * @author Kassandra Madsen
 * CS 3450 Section X01
 * Program 1: Strategy Pattern
 */

package StrategyPattern;

import java.util.Scanner;

/**
 * This is our main aka Driver program that will let the teacher create a student list, add and delete students from the list,
 * set the sort strategy, and sort the list
 */
public class Main {
    /**
     * main function that will do as stated above
     * @param args
     */
    public static void main(String[] args) {

        SortedList sortedList = new SortedList(); // creates a new Sorted List
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create Your Student List (Type: Quit, after the last name when you are done): ");
        while(true) {
            String line = scanner.nextLine().toLowerCase();
            if (!line.equals("quit")) {
                sortedList.add(line); // add to list
            } else {
                break;
            }
        }

        System.out.println();
        System.out.println("Type In The Student(s) You Would Like to Be Added to the List (Type: No, if you don't want to add any and Type: Done, when you are done):");
        while(true) {
            String line1 = scanner.nextLine().toLowerCase();
            if (!line1.equals("no") && !line1.equals("done")) {
                sortedList.add(line1); // add to list
            } else {
                break;
            }
        }

        System.out.println();
        System.out.println("Type In The Student(s) You Would Like to Be Deleted From the List (Type: No, if you don't want to delete any and Type: Done, when you are done):");
        while(true) {
            String line2 = scanner.nextLine().toLowerCase();
            if (!line2.equals("no") && !line2.equals("done")) {
                sortedList.delete(line2); // delete from list
            } else {
                break;
            }
        }

        System.out.println();
        System.out.println("What Type of Sort Would You Like the List to Be Sorted as? (Options: Merge Sort, Shell Sort, or Quick Sort):");
        String line3 = scanner.nextLine().toLowerCase();
        System.out.println();
        if (line3.equals("merge sort")) {
            sortedList.setSort(new MergeSort()); // merge sort
        } else if (line3.equals("shell sort")) {
            sortedList.setSort(new ShellSort()); // shell sort
        } else if (line3.equals("quick sort")) {
            sortedList.setSort(new QuickSort()); // quick sort
        }
        sortedList.performSort();
        sortedList.display();

        scanner.close(); // close scanner
    }
}
