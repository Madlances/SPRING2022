package madsen;

/**
 * This class is our main Driver factory.
 * It will create a display driver and a print driver, for 
 * the Low Res and High Res sub factories.
 */
public interface DriverFactory {
    public DisplayDriver createDisplayDriver();
    public PrintDriver createPrintDriver();
}
