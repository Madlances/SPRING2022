package madsen;

/**
 * This is our Policy class that implements the Singleton pattern.
 */

public class Policy {
    private static Policy uniqueInstance;

    private Policy() {
        // this is unecessary, since this method is private, but it's a good sanity check against accidentally creating more
        if (Policy.uniqueInstance != null) {
            throw new Error("Cannot create more than one instance of the Policy class");
        }
    };

    /**
     * this function will instantiate the Policy,
     * if uniqueInstance is null.
     * We are also using lazy loading and thread safety in this function.
     * @return
     */
    public static Policy getInstance() {
        if (uniqueInstance == null) {
            synchronized (Policy.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Policy();
                }
            }
        }
        return uniqueInstance;
    }

    /**
     * This function will return the description of the Policy
     * @return
     */
    public String getDescription() {
        return "Our Policy covers Health, Dental, and Medical.";
    }

    /**
     * This function will return the Policy Holder name
     * @param name
     * @return
     */
    public String getPolicyHolderName(String name) {
        return name;
    }

    /**
     * This function will return the ID
     * @param id
     * @return
     */
    public String getPolicyID(String id) {
        return id;
    }

    /**
     * This function will set the Policy Holder Name so that
     * we will be able to return it when we call getPolicyHolderName
     * @param name
     * @return
     */
    public String setPolicyHolderName(String name) {
        return getPolicyHolderName(name);
    }

    /**
     * This function will set the Policy ID so that
     * we will be able to return it in getPolicyID 
     * @param id
     * @return
     */
    public String setPolicyID(String id) {
        return getPolicyID(id);
    }
}
