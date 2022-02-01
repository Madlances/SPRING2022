package madsen;

/**
 * This class is our main Component class that each subclass will inherit from.
 */
public abstract class Pizza {
    String description = ""; // set description to anything since we will be overriding this in other classes
    
    /**
     * Thsi function returns the description of various ingredients and crust
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Thsi function will return the cost in other classes
     * @return
     */
    public abstract double cost();
}
