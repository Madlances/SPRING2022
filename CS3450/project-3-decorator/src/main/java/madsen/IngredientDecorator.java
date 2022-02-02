package madsen;

/**
 * This is our main Decorator class, which is essential to the Decorator pattern.
 * It will inherit from Pizza and will be an abstract class.
 * It will only include a description function.
 * Each class that inherits this class will also need da description function
 */
public abstract class IngredientDecorator extends Pizza {
    @Override // override the pizza class to return each description
    public abstract String getDescription();
}
