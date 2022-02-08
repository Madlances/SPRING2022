package madsen;

/**
 * This class implements the DisplayDriver class, and
 * override it with what is returned below.
 */
public class HighResDisplayDriver implements DisplayDriver{
    /**
     * This will return "LowResDisplayDriver"
     */
    @Override
    public String display() {
        return "HighResDisplayDriver";
    };
}
