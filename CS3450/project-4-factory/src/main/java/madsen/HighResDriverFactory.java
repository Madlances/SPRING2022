package madsen;

/**
 * This class implements from the Driver factory.
 * It will create a display driver and a print driver.
 */
public class HighResDriverFactory implements DriverFactory{
    /**
     * This function will return a new display driver that
     * will then return the string "HighResDisplayDriver"
     */
    public DisplayDriver createDisplayDriver() {
        return new HighResDisplayDriver();
    }

    /**
     * This function will return a new print driver that
     * will then return the string "HighResDisplayDriver"
     */
    public PrintDriver createPrintDriver() {
        return new HighResPrintDriver();
    }
}
