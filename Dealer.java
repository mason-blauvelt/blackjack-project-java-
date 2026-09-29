import java.util.ArrayList;
import java.util.Scanner;
public class Dealer {
    private Hand hand; //hand
    private ArrayList<Player> players; //players
    private Deck deck; //deck
    static Scanner input = new Scanner(System.in); //scanner

    /**
     * constructor for dealer
     */
    public Dealer(){
        hand = new Hand(); //gives hand
        players = new ArrayList<Player>(); //gives players
    }

    /**
     * sets players
     * @param players
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * gets hand
     * @return
     */
    public Hand getHand(){
        return hand;
    }

    /**
     * sets deck
     * @param deck
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * resets hand
     */
    public void resetHand(){
        hand.clear();
    }

    /**
     * prints hand
     */
    public void printHand(){
        for(Card c : hand.getHand()){
            c.printCard();
        }
    }

    /**
     * gets bets from players
     */
    public void setBets(){
        for (Player player : players) {
            System.out.println("Enter your bet " + player.getPlayerName()+": ");
            double bets = input.nextDouble(); //gets bet
            while(bets > player.getBalance()|| bets < 0){ //makes sure legal bet
                System.out.println("Insufficient Funds! Enter again: ");
                bets = input.nextDouble(); //gets input
            }
            player.placeBet(bets); //places bet
            System.out.println(player.getPlayerName()+"'s new balance: $"+player.getBalance()); //prints players balance
        }

    }

    /**
     * gets choice of hit stand double and validates
     */
    public void Choice(){
        for(Player player: players) {
            player.printHand(); //prints hand
            System.out.println(player.getPlayerName() + "s total: " + player.getHand().getTotal());
            System.out.println(player.getPlayerName() + " hit, stand, or double: ");
            String answer = input.next(); //gets input

            if (answer.equals("double")) {//for double and makes sure legal
                if (player.getCurrentBet() <= player.getBalance()) {
                    player.doubleDown(); //doubles bet
                    player.getHand().addCard(deck.drawCard()); //draws card
                    player.printHand(); //prints hand
                    System.out.println(player.getPlayerName() + "'s new balance: $" + player.getBalance());

                if (player.getHand().getTotal() > 21) { //check if you bust
                    System.out.println(player.getPlayerName() + " Busts!");
                }
                System.out.println(player.getPlayerName() + "s card total: " + player.getHand().getTotal());
                continue;
            }
            System.out.println("Insufficient Funds! hit or stand: ");
            answer = input.next(); //gets input again if you cant double
        }

            while (answer.equals("hit")) {//for hitting
                player.getHand().addCard(deck.drawCard()); //adds card
                player.printHand();
                System.out.println(player.getPlayerName()+"s card total: " + player.getHand().getTotal());
                if(player.getHand().getTotal()>21){ //checks if busts
                    System.out.println(player.getPlayerName()+" Busts!");
                    break;
                }
                System.out.println(player.getPlayerName() + " hit or stand: ");
                answer = input.next(); //sees if you want to hit or stand again for loop

            }

        }
    }


}
