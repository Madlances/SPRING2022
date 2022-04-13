package madsen;

/**
 * This class is our Database given from the project description
 * any class that implements this class will have to implement
 * the methods below
 */
public interface Database {
    
    public String getId();

    public boolean exists(String key);

    public String get(String key);
}
