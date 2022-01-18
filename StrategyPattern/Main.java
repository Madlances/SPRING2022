package StrategyPattern;

public class Main {
    public static void main(String[] args) {

        SortedList sortedList = new SortedList();
        sortedList.add("Anna");
        sortedList.add("Jimmy");
        sortedList.add("Samual");
        sortedList.add("Sandra");
        sortedList.add("Vivek");

        sortedList.setSort(new MergeSort());
        sortedList.performSort();
        sortedList.display();

        sortedList.setSort(new ShellSort());
        sortedList.performSort();
        sortedList.display();

        sortedList.setSort(new QuickSort());
        sortedList.performSort();
        sortedList.display();
    }
}
