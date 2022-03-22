package madsen;

public class DinersCard extends CreditCard{
    /**
     * From original code
     * @param customer
     */
    public DinersCard(CustDiner customer) {
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
        return cardNum.length() == 14;
    }

    /**
     * This function overrides isValidPrefix since this code was different between the 3 subclasses
     * in the original code
     */
    @Override
    public boolean isValidPrefix() {
        String prefix = cardNum.substring(0, 1);
        String nextChar = cardNum.substring(1, 2);
        String validChars = "068";  //2nd char must be a 0 or 6, or 8

        //51-55
        return (prefix.equals("3")) && (validChars.contains(nextChar));
    }
}
