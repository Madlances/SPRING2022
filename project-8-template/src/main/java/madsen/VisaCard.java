package madsen;

public class VisaCard extends CreditCard{

    public VisaCard(CustVisa customer) {
        cardNum = customer.number;
        expMM = customer.month;
        expYY = customer.year;
    }

    @Override
    public boolean isNumOfDigitsValid() {
        return (cardNum.length() == 13) || (cardNum.length() == 16);
    }

    @Override
    public boolean isValidPrefix() {
        String prefix = cardNum.substring(0, 1);
        return prefix.equals("4");
    }
}
