package madsen;

import java.io.FileNotFoundException;

/**
 * @author Kassandra Madsen
 * CS 3450 Section X01
 * Project 11 - Proxy Pattern
 */

public class App 
/**
 * Given from the project description for testing.
 * This will actually retrieve values from a file as key value pairs and test them against the database
 */
{

    static void test(Database db) {
        System.out.println(db.get("one"));
        System.out.println(db.get("two"));
        System.out.println(db.exists("two")); // Call to exists
        System.out.println(db.get("three"));
        System.out.println(db.get("four"));
        System.out.println(db.get("four"));
        System.out.println(db.get("five"));
        System.out.println(db.get("six"));
        System.out.println(db.get("one"));
        try {
            System.out.println(db.get("seven"));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    static final String dbFileName = "db.dat";
    static final String userDbFileName = "userdb.dat";
    static final String noNameUserDbFileName = "noname.dat";

    public static void main( String[] args ) throws FileNotFoundException {
        Database db = new DatabaseImpl(dbFileName);
        test(db);
        
        Database userdb = new DatabaseImpl(userDbFileName);     // Hard code this exact name
        SecureDatabase sdb = new SecureDatabase(db, userdb);
        test(sdb);
        CacheDatabase cdb = new CacheDatabase(sdb);
        test(cdb);
        System.out.println("Cache contents: " + String.join(", ", cdb.inspect()));
        try {
            Database db2 = new DatabaseImpl(noNameUserDbFileName);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
