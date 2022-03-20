package madsen;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
