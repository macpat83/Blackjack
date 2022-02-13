import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();
        int card1 = drawRandomCard();
        int card2 = drawRandomCard();
        System.out.println("\n You get a \n" + cardString(card1) + "\n and a \n" + cardString(card2));
        int handValue = Math.min(card1, 10) + Math.min(card2, 10);
        System.out.println("Your total is: " + handValue);

        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        System.out.println("\n" + cardString(dealerCard1) + "\nand has a card facing down \n" + faceDown());
        int dealerTotal = Math.min(dealerCard1, 10) + Math.min(dealerCard2, 10);
        System.out.println("\nThe dealer's total is hidden.");
        
        while (true) {
            String option = hitorStay();
            if (option.equalsIgnoreCase("stay")){
                break;
            }
            int newCard = drawRandomCard();
            handValue += Math.min(newCard, 10);
            System.out.println("\n You get a \n" + cardString(newCard));
            System.out.println("Your new total is: " + handValue);

            if (handValue > 21) {
                System.out.println("Bust! Player loses");
                System.exit(0);
            }
            }
             System.out.println("\nDealer's turn");
            System.out.println("\n The dealer's cards are \n" + cardString(dealerCard1) + "\n" + cardString(dealerCard2));
            System.out.println("\nDealer's total: "+dealerTotal);
            while (dealerTotal < 17) {
                int dealerHit = drawRandomCard();
                System.out.println("\nDealer get's a \n" + cardString(dealerHit));
                dealerTotal += Math.min(dealerHit, 10);
                System.out.println("Dealer's total: "+dealerTotal);
            }
            if (dealerTotal > 21) {
                System.out.println("Bust! Dealer loses");
                System.exit(0);
            }

            if (handValue > dealerTotal) {
                System.out.println("Player wins");
            } else {
                System.out.println("Dealer wins");
            

            }

            scan.close();
        }
        

    
        

       
     

        
        //For tasks 9 to 13, see the article: Blackjack Part II. 
         

    

    public static int drawRandomCard() {
        double randomNumber = Math.random() * 13;
        randomNumber += 1;
        return (int)randomNumber;

        }
                
        


    public static String cardString(int cardNumber) {
        switch(cardNumber){
            case 1:   
            return "   _____\n"+
                   "  |A _  |\n"+ 
                   "  | ( ) |\n"+
                   "  |(_'_)|\n"+
                   "  |  |  |\n"+
                   "  |____V|\n";
            case 2:
            return  "   _____\n"+              
                    "  |2    |\n"+ 
                    "  |  o  |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____Z|\n";
                  
            case 3:
            return"   _____\n" +
                  "  |3    |\n"+
                  "  | o o |\n"+
                  "  |     |\n"+
                  "  |  o  |\n"+
                  "  |____E|\n";

            case 4:
            return "   _____\n" +
                   "  |4    |\n"+
                   "  | o o |\n"+
                   "  |     |\n"+
                   "  | o o |\n"+
                   "  |____h|\n";

            case 5:
            return  "   _____ \n" +
                    "  |5    |\n" +
                    "  | o o |\n" +
                    "  |  o  |\n" +
                    "  | o o |\n" +
                    "  |____S|\n";

            case 6:
            return  "   _____ \n" +
                    "  |6    |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  |____6|\n";

            case 7:
            return  
                    "   _____ \n" +
                    "  |7    |\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |____7|\n";
          

            case 8:
            return  "   _____ \n" +
                    "  |8    |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  |____8|\n";
            case 9:
            return  "   _____ \n" +
                    "  |9    |\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |____9|\n";

            case 10:
            return  "   _____ \n" +
                    "  |10  o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |___10|\n";
            case 11:
            return  "   _____\n" +
                    "  |J  ww|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o% |\n"+ 
                    "  | | % |\n"+ 
                    "  |__%%[|\n";
            case 12:
            return  "   _____\n" +
                    "  |Q  ww|\n"+ 
                    "  | o {(|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%O|\n";
            case 13:
            return  "   _____\n" +
                    "  |K  WW|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%>|\n";
            default: 
            return "This shouldn't get called.";
                }

        
               
    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";

    }

    public static String hitorStay() {
        System.out.println("Do you want to hit or stay");
        String option = scan.nextLine();
        
        
        while (!(option.equalsIgnoreCase("hit") || option.equalsIgnoreCase("stay"))) {
            System.out.println("Please write hit or stay");
            option = scan.nextLine();

        }
        
        
        return option;


    }
    
    /** Task 7 – make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     * @return (String)
     *
     * Inside the function:
     *   1. Asks the user to hit or stay.
     *   2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     *      Please write 'hit' or 'stay'
     *   3. Returns the user's option 
     */
    }

