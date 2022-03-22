package madsen;

public class MasterCard extends CreditCard{
    /**
     * from orignal code
     * @param customer
     */
    public MasterCard(CustMaster customer) {
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
        return cardNum.length() == 16;
    }

    /**
     * This function overrides isValidPrefix since this code was different between the 3 subclasses
     * in the original code
     */
    @Override
    public boolean isValidPrefix() {
        String prefix = cardNum.substring(0, 1);
        String nextChar = cardNum.substring(1, 2);
        String validChars = "12345";

        //51-55
        return (prefix.equals("5")) && (validChars.contains(nextChar));
    }
}
