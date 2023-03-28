package testingClasses;
import ExtendingTheCreditCardClass1.CreditCard;
import ExtendingTheCreditCardClass1.PredatoryCreditCard;

public class TestCreditCard {
    public static void main(String[] args) {
        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("John Bowman", "California Savings",
                "5391 0375 9387 5309", 5000);
        wallet[1] = new CreditCard("John Bowman", "California Federal",
                "3485 0399 3395 1954", 3500);
        wallet[2] = new CreditCard("John Bowman", "California Finance",
                "5391 0375 9387 5309", 2500, 300);

        for(int val = 1;val <= 16; val++){
            wallet[0].charge(val * 3);
            wallet[1].charge(val * 2);
            wallet[2].charge(val);
        }

        for(CreditCard card : wallet) {
            CreditCard.printSummary(card);         // calling static method
            while(card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.println("New balance : " + card.getBalance());
            }
        }
        System.out.println();

        // example to make object of subclass PredatoryCreditCard and call the new methods
        PredatoryCreditCard p1 = new PredatoryCreditCard("John Bowman", "California Savings",
                "5391 0375 9387 5309", 5000,4967.07, 0.0825);
        PredatoryCreditCard p2 = new PredatoryCreditCard("John Bowman", "California Finance",
                "5391 0375 9387 5309", 2500, 4968, 0.0825);


        p1.processMonth();
        System.out.println("New balance : " + p1.getBalance());
        System.out.println(p1.charge(0));
        System.out.println("New balance : " + p1.getBalance() + "\n");


        p2.processMonth();
        System.out.println("New balance : " + p2.getBalance());
        System.out.println(p2.charge(0));
        System.out.println("New balance : " + p2.getBalance() + "\n");

        // Declaration and initialization types are different.
        CreditCard card = new PredatoryCreditCard("John Bowman", "California Savings",
                "5391 0375 9387 5309", 5000,4967.07, 0.0825);
        PredatoryCreditCard.printSummary(card);
        System.out.println(card.charge(0.01));  //  Dynamic dispatch
        System.out.println();


        System.out.println(card instanceof PredatoryCreditCard);
        System.out.println(card instanceof CreditCard);
        System.out.println(wallet instanceof CreditCard[]);
        System.out.println(wallet[0] instanceof PredatoryCreditCard);
    }
}
