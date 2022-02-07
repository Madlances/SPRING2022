package madsen;

public class LowResDriverFactory implements DriverFactory {
    public DisplayDriver createDisplayDriver() {
        return new LowResDisplayDriver();
    }

    public PrintDriver createPrintDriver() {
        return new LowResPrintDriver();
    }
}
