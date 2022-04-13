package madsen;

import java.util.Scanner;

/**
 * This class will automatically requires users to login before allowing them to call 
 * the IDatabase methods. Have a special Database of users and passwords that authenticates on the first 
 * access attempt. Throw an exception if authentication fails.
 */

public class SecureDatabase implements Database {

    private Database db;
    private Database userDb;
    public SecureDatabase(Database db, Database userDb) {
        this.db = db;
        this.userDb = userDb;
    }

    /**
     * This makes sure the users and passwords are authenticated beforehand
     */
    private boolean isAuthenticated = false;
    private void Authenticate() throws RuntimeException {
        if (!this.isAuthenticated) {
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = reader.nextLine();
            System.out.print("Enter password: ");
            String password = reader.nextLine();
            reader.close();
            if (userDb.exists(username) && userDb.get(username).equals(password)) {
                isAuthenticated = true;
            } else {
                throw new RuntimeException("No user found with that username and password");
            }
        }
    }

    /**
     * This function authenticates beforehand and returns
     * the databases id
     */
    @Override
    public String getId() {
        this.Authenticate();
        return this.db.getId();
    }

    /**
     * This function authenticates beforehand and returns
     * the databases key making sure that exists
     */
    @Override
    public boolean exists(String key) {
        this.Authenticate();
        return this.db.exists(key);
    }

    /**
     * This function authenticates beforehand and returns
     * the databases key
     */
    @Override
    public String get(String key) {
        this.Authenticate();
        return this.db.get(key);
    }
    
}
