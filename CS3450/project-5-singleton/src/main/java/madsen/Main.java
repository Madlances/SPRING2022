package madsen;

/**
 * This is our main driver class.
 * This class will let the user input a Policy Holder Name and ID.
 * Then we will use the singleton class Policy to print out the users
 * Holder name and id and the description of the insurances policy.
 */

import java.util.Scanner;

public class Main 
{
    /**
     * This function will get user input and print out
     * what the user has put in and the policy description.
     * @param args
     */
    public static void main( String[] args ) {
        Policy policy = Policy.getInstance();
        System.out.println("Welcome to our Insurance Program!");
        Scanner nameHolderAndId = new Scanner(System.in);
        System.out.println("Enter Your Policy Holder Name and Policy ID: ");
        String name = nameHolderAndId.nextLine();
        String id = nameHolderAndId.nextLine();
        policy.setPolicyHolderName(name);
        policy.setPolicyID(id);
        System.out.println("Your Policy Holder Name is: " + policy.getPolicyHolderName(name));
        System.out.println("Your Policy ID is: " + policy.getPolicyID(id));
        System.out.println("Our Policy is: " + policy.getDescription());

        nameHolderAndId.close();
    }
}
