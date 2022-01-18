package StrategyPattern;

import java.util.ArrayList;

public class SortedList {
    Sort sort;
    ArrayList<String> sortedStudents = new ArrayList<>();

    public void add(String student) {
        sortedStudents.add(student);
    }

    public void delete(String student) {
        sortedStudents.remove(student);
    }

    public void display() {
        for (String s: sortedStudents) {
            System.out.println(s);
        }
        System.out.println();
    }

    public void setSort(Sort s) {
        sort = s;
    }

    public void performSort() {
        sort.sort();
    }
}
