package madsen;

/**
 * This class inherits from Pizza class.
 * It's purpose is to return a cost and have a description.
 * It also is a Concrete Component of the Pizza class
 */
public class TraditionalCrust extends Pizza {
    
    /**
     * This function will set the description of the type of crust
     */
    public TraditionalCrust() {
        description = "Traditional Crust";
    }

    @Override // override the Pizza classes cost function with what is returned here
    /**
     * This functin returns the cost of this crust
     */
    public double cost() {
        return 2.00;
    }
}
