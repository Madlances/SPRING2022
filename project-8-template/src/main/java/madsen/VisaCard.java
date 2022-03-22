package madsen;

public class VisaCard extends CreditCard{
    /**
     * From orignal code
     * @param customer
     */
    public VisaCard(CustVisa customer) {
        cardNum = customer.number;
        expMM = customer.month;
        expYY = customer.year;
    }

    /**
     * This function overrides isNumOfDigitsValid since this code was different between the 3 subclasses
     * in the original code
     */
    @Override
    public boolean isNumOfDigitsValid() {
        return (cardNum.length() == 13) || (cardNum.length() == 16);
    }

    /**
     * This function overrides isValidPrefix since this code was different between the 3 subclasses
     * in the original code
     */
    @Override
    public boolean isValidPrefix() {
        String prefix = cardNum.substring(0, 1);
        return prefix.equals("4");
    }
}
