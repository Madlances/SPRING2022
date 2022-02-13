package madsen;

public class Policy {
    private static Policy uniqueInstance;

    private Policy() {
        // this is unecessary, since this method is private, but it's a good sanity check against accidentally creating more
        if (Policy.uniqueInstance != null) {
            throw new Error("Cannot create more than one instance of the Policy class");
        }
    };

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

    public String getDescription() {
        return "Our Policy covers Health, Dental, and Medical.";
    }

    public String getPolicyHolderName(String name) {
        return name;
    }

    public String getPolicyID(String id) {
        return id;
    }

    public String setPolicyHolderName(String name) {
        return getPolicyHolderName(name);
    }

    public String setPolicyID(String id) {
        return getPolicyID(id);
    }
}
