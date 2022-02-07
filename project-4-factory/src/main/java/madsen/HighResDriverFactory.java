package madsen;

public class HighResDriverFactory implements DriverFactory{
    public DisplayDriver createDisplayDriver() {
        return new HighResDisplayDriver();
    }

    public PrintDriver createPrintDriver() {
        return new HighResPrintDriver();
    }
}
