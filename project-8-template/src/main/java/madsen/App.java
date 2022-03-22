package madsen;

/**
 * @author Kassandra Madsen
 * CS 3450 section X01
 * Project 8 - Template Pattern
 */
public class App 
{
    /**
     * This is our main class that will see if a credit card is valid or invalid
     * @param args
     */
    public static void main( String[] args )
    {
        /**
         * From original code
         */
        System.out.println("\nDiner Card Info:");
        CustDiner custDiner = new CustDiner(); // customer information
        DinersCard myDiner =  new DinersCard(custDiner);
        if (myDiner.isValid()) {
            System.out.println("Valid Credit Card Information");
        }


        System.out.println("\nMaster Card Info:");
        CustMaster custMaster = new CustMaster(); // customer information
        MasterCard myMaster = new MasterCard(custMaster);
        if (myMaster.isValid()) {
            System.out.println("Valid Credit Card Information");
        }

        System.out.println("\nVisa Card Info:");
        CustVisa custVisa = new CustVisa(); //

        VisaCard myVisa = new VisaCard(custVisa);     //make sure dates are valid
        if (myVisa.isValid()) {
            System.out.println("Valid Credit Card Information");
        }
    }
}
