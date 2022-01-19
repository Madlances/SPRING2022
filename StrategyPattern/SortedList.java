package StrategyPattern;

import java.util.ArrayList;

/**
 * This is our Sorted List. This will do the add, delete, and sorting of the student list they give us
 */
public class SortedList {
    Sort sort; // implement the Sort Class
    ArrayList<String> sortedStudents = new ArrayList<>(); // create a new list to add or delete

    /**
     * This is our add function. This will add to the sortedStudent list
     * @param student
     */
    public void add(String student) {
        sortedStudents.add(student);
    }

    /**
     * This is our delete function. This will delete from the sortedStudent list
     * @param student
     */
    public void delete(String student) {
        sortedStudents.remove(student);
    }

    /**
     * This is our display function. This is displaying the sortedStudent list
     */
    public void display() {
        for (String s: sortedStudents) {
            System.out.println(s);
        }
        System.out.println();
    }

    /**
     * This is our setSort function. This will set what sort we want. (Using our Sort Strategy)
     * @param s
     */
    public void setSort(Sort s) {
        sort = s;
    }

    /**
     * This is our performSort function. This will actually do the specified sort. (Using our Sort Strategy)
     */
    public void performSort() {
        sort.sort();
    }
}
