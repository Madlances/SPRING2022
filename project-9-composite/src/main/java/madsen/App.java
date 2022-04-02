package madsen;

/**
 * @author Kassandra Madsen
 * CS 3450 Section X01
 * Project 9 - Composite Pattern
 */

 /**
  * This class will read in the directoryTree.dat file to traverse the tree within it
  */
public class App 
{
    public static final Integer INDENT_WIDTH = 3;
    public static void main(String[] args) {
        // using the Parser and Terminal files
        Composite root = Parser.parseFile("./src/resources/directoryTree.dat");
        Terminal.run(root);
    }
}
