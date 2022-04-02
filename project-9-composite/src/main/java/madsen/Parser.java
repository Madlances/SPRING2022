package madsen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * This class will be used as a way to get the lines from the file as well as
 * check to see if its a directory, get the depth of the file, and can set
 * the file to be a leaf or directory. Also get the root of the file.
 * We will call this in App.java
 */
public class Parser {

    /**
     * This function will put the lines into the array
     * @param filePath
     * @return
     */
    private static ArrayList<String> getLinesFromFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(line -> lines.add(line));
        } catch (IOException e) {
            System.out.println("Error while reading file");
            e.printStackTrace();
        }

        return lines;
    }

    /**
     * This will check if a line is a directory, by if it ends with a ":"
     * @param line
     * @return
     */
    private static Boolean isDirectory(String line) {
        return line.endsWith(":");
    }

    /**
     * This will get the depth of a file or directory
     * @param line
     * @return
     */
    private static Integer fileDepth(String line) {
        return (line.length() - line.replace(" ", "").length()) / App.INDENT_WIDTH;
    }

    /**
     * This will create a new Composite
     * @param line
     * @param parent
     * @return
     */
    private static Composite parseComposite(String line, Composite parent) {
        return new Composite(line.substring(0, line.length() - 1).trim(), parent);
    }

    /**
     * This will create a new leaf
     * @param line
     * @param parent
     * @return
     */
    private static Leaf parseLeaf(String line, Composite parent) {
        return new Leaf(line.trim(), parent);
    }

    /**
     * This will make sure the current line is a directory or a file and set them accordingly,
     * as well as get the root of the file.
     * @return the root of the parsed filetree
     */
    static Composite parseFile(String filePath) {
        final ArrayList<String> lines = getLinesFromFile(filePath);
        final Composite root = parseComposite(lines.remove(0), null);
        Composite currentDirectory = root;
        Integer currentDepth = 0;

        for (String line : lines) {
            Integer depth = fileDepth(line);
            while (depth <= currentDepth) {
                currentDepth -= 1;
                currentDirectory = currentDirectory.getParent();
            }
            if (isDirectory(line)) {
                Composite newDirectory = parseComposite(line, currentDirectory);
                currentDirectory.addChild(newDirectory);
                currentDirectory = newDirectory;
                currentDepth = depth;
            } else {
                Leaf newLeaf = parseLeaf(line.trim(), currentDirectory);
                currentDirectory.addChild(newLeaf);
            }
        }

        return root;
    }
}
