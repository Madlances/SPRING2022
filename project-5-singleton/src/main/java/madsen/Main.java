package madsen;

import java.util.Scanner;

public class Main 
{
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
