package madsen;

/**
 * This class implements from the Driver factory.
 * It will create a display driver and a print driver.
 */
public class LowResDriverFactory implements DriverFactory {
    /**
     * This function will return a new display driver that
     * will then return the string "LowResDisplayDriver"
     */
    public DisplayDriver createDisplayDriver() {
        return new LowResDisplayDriver();
    }

    /**
     * This function will return a new print driver that
     * will then return the string "LowResPrintDriver"
     */
    public PrintDriver createPrintDriver() {
        return new LowResPrintDriver();
    }
}
