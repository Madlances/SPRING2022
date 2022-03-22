package madsen;

import java.util.Calendar;
import java.util.Date;

/**
 * This is our main CreditCard class that is an abstract class that has all the functions that
 * are the same throughout the original code, as well as have a couple of functions that will be
 * overwritten by the other subclasses.
 * Note: the classes without abstract in front are from the original code
 */
public abstract class CreditCard {
    protected String cardNum;
    protected int expMM, expYY;

    /**
     * This function is very important to the template pattern, and this is where we 
     * call all the functions we need
     */
    final void card() {
        isExpDtValid();
        hasValidChars();
        isValidCheckSum();
        isNumOfDigitsValid();
        isValidPrefix();
        isAccountInGoodStand();
        isValid();
    }

    // Check for valid date
    final boolean isExpDtValid() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int mm = cal.get(Calendar.MONTH) + 1;
        int yy = cal.get(Calendar.YEAR);
        boolean result = (yy > expYY) || ((yy == expYY) && (mm > expMM));
        return (!result);
    }

    // Check for valid chars
    final boolean hasValidChars() {
        String validChars = "0123456789";
        boolean result = true;
        for (int i = 0; i < cardNum.length(); i++) {
            if (!validChars.contains(cardNum.substring(i, i + 1))) {
                result = false;
                break;
            }
        }
        return result;
    }

    // Calc checksum
    final boolean isValidCheckSum() {
        boolean result = true;
        int sum = 0;
        int multiplier = 1;
        int strLen = cardNum.length();
        for (int i = 0; i < strLen; i++) {
            String digit = cardNum.substring(strLen - i - 1, strLen - i);
            int currProduct = Integer.parseInt(digit) * multiplier;
            if (currProduct >= 10)
                sum += (currProduct% 10) + 1;
            else
                sum += currProduct;
            if (multiplier == 1)
                multiplier++;
            else
                multiplier -- ;
        }
        if ((sum% 10) != 0)
            result = false;
        return result;
    }

    //check number of digits
    abstract boolean isNumOfDigitsValid();

    //check prefix
    abstract boolean isValidPrefix();

    /*
      Make necessary card API calls to
      perform other checks.
      (set return to true if card is to be valid
    */
    final boolean isAccountInGoodStand() {
        return true;
    }

    final boolean isValid() {
        if (!isExpDtValid()) {
            System.out.println(" Invalid Exp Dt. ");
            return false;
        }
        if (!isNumOfDigitsValid()) {
            System.out.println(" Invalid Number of Digits ");
            return false;
        }
        if (!isValidPrefix()) {
            System.out.println(" Invalid Prefix ");
            return false;
        }
        if (!hasValidChars()) {
            System.out.println(" Invalid Characters ");
            return false;
        }
        if (!isValidCheckSum()) {
            System.out.println(" Invalid Check Sum ");
            return false;
        }
        if (!isAccountInGoodStand()) {
            System.out.println(" Account is Inactive/Revoked/Over the Limit ");
            return false;
        }

        return true;
    }
}
