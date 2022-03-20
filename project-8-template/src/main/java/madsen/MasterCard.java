package madsen;

public class MasterCard extends CreditCard{
    public MasterCard(CustMaster customer) {
        cardNum = customer.number;
        expMM = customer.month;
        expYY = customer.year;
    }

    @Override
    public boolean isNumOfDigitsValid() {
        return cardNum.length() == 16;
    }

    @Override
    public boolean isValidPrefix() {
        String prefix = cardNum.substring(0, 1);
        String nextChar = cardNum.substring(1, 2);
        String validChars = "12345";

        //51-55
        return (prefix.equals("5")) && (validChars.contains(nextChar));
    }
}
