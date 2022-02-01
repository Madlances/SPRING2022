package madsen;

/**
 * This class inherits from Ingredient Decorator.
 * It's purpose is to return a cost and have a description
 */
public class Ricotta extends IngredientDecorator{
    Pizza pizza;
    
    /**
     * This function will set the current pizza with the contents of this topping
     * @param pizza
     */
    public Ricotta(Pizza pizza) {
        this.pizza = pizza;
    }

    /**
     * This function will return a description of this topping
     */
    public String getDescription() {
        return pizza.getDescription() + ", Ricotta";
    }

    /**
     * This function will return the cost of this topping
     */
    public double cost() {
        return 0.12 + pizza.cost();
    }
}
