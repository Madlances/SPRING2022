package CS3450.StrategyPattern;

/**
 * This is our Super Class Sort. I decided to make it an interface instead of a abstract class.
 */
public interface Sort {
    /**
     * This is our sort function. Every class that inherits Sort needs a void sort function.
     */
    public void sort();
}
