package madsen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

/**
 * This class will, whenever a user calls get(key), the value for 
 * that key is returned (throw an exception if it’s not in the file). The database id is the file name. Use it to 
 * open the file, and keep the file open for the life of the object.
 * Each time you try to access the data via get() or exists(), go to the file (don’t read in all the data at first 
 * and store it in the object).
 * It will also implement from Database
 */

public class DatabaseImpl implements Database {

    private String filePath;
    private RandomAccessFile fileReader;

    /**
     * Our constructor to read in the file
     * @param filePath
     * @throws FileNotFoundException
     */
    public DatabaseImpl(String filePath) throws FileNotFoundException {
            this.filePath = filePath;
            File file = new File(this.filePath);
            this.fileReader = new RandomAccessFile(file, "r");
    }
    
    /**
     * THis function is to put the file into a hash map
     * as well as keep the file open for the life of the object
     * @return
     */
    private HashMap<String, String> getData() {
        HashMap<String, String> data = new HashMap<>();

        StringBuilder content = new StringBuilder();
        int nextChar;
        try {
            this.fileReader.seek(0);
            while ((nextChar = this.fileReader.read()) != -1) {
                content.append((char) nextChar);
            }
        } catch (IOException e) {
            System.out.println("Failed to read from file");
        }
        String[] lines = String.valueOf(content).trim().split(System.lineSeparator());

        for (String line : lines) {
            String[] splitLine = line.split(" ", 2);
            String key = splitLine[0];
            String value = splitLine[1];
            data.put(key, value);
        }
        return data;
    }   

    /**
     * This function closes the file and is given from implementing Database
     */
    @Override
    protected void finalize() throws Throwable {
        fileReader.close();
    }

    /**
     * This function returns the file name as the id and is given from implementing the Database
     */
    @Override
    public String getId() {
        return this.filePath;
    }

    /**
     * This function returns the key from the data
     */
    @Override
    public boolean exists(String key) {
        HashMap<String, String> data = this.getData();
        return data.containsKey(key);
    }

    /**
     * This function makes sure the key is actually in the data
     */
    @Override
    public String get(String key) throws RuntimeException {
        HashMap<String, String> data = this.getData();
        if (data.containsKey(key)) {
            return data.get(key);
        } else {
            throw new RuntimeException("No such record: " + key);
        }
    }
    
}
