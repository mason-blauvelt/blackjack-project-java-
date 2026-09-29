import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players; //arraylist of players
    private Dealer dealer; //dealer
    static Scanner input = new Scanner(System.in); //scanner for input

    /**
     * constructor for game that gets players and dealer
     */
    public Game(){
        players = new ArrayList<Player>();
        dealer = new Dealer();
    }

    /**
     * gets dealer
     * @return
     */
    public Dealer getDealer() {
        return dealer;
    }

    /**
     * gets players
     * @return
     */
    public ArrayList<Player> getPlayers(){
        return players;
    }


    /**
     * gets number of players and creates them and gives them starting balance
     */
    public void setupPlayers(){
        int numOfPlayers;
        System.out.println("Enter number of players(1-20): ");
        numOfPlayers = input.nextInt(); //gets num of players

        while (numOfPlayers < 1 || numOfPlayers > 20){ //makes sure valid player amount
            System.out.println("Invalid number. Enter again: ");
            numOfPlayers = input.nextInt();
        }

        String[] name = new String[numOfPlayers]; //string array to hold player names
        System.out.println("Enter their names: ");

        for(int i = 0; i < numOfPlayers ; i++) { //gets their name from user
            name[i] = input.next();
        }
        for(int i = 0 ; i < numOfPlayers ; i++){
            Player player = new Player(name[i]); //creates the number of players needed and gives them the name
            players.add(player);
        }
        dealer.setPlayers(players); //sets the players

        for (Player player : players){
            System.out.print(player.getPlayerName());//prints player name and balance
            System.out.println(" has $"+player.getBalance());
        }

    }

    /**
     * sets up the dealer
     * @param deck
     */
    public void setupDealer(Deck deck){
        dealer.setDeck(deck); //gives dealer the deck
        dealer.getHand().addCard(deck.drawCard()); //gives the dealer first card
        System.out.println("The Dealers Card up is: "); //prints dealers first card
        dealer.printHand();
        dealer.getHand().addCard(deck.drawCard()); //gives dealer second card that we cant see yet
    }

    /**
     * gets the players hand
     * @param deck
     */
    public void playerHand(Deck deck){
        for(Player player: players){
            player.getHand().addCard(deck.drawCard()); //draws first card
            player.getHand().addCard(deck.drawCard()); //draws second card
        }
    }

    /**
     * makes dealer draw until 17
     * @param deck
     */
    public void dealersTurn(Deck deck){

        while(dealer.getHand().getTotal()<17){ //adds card until total is 17 or more
            dealer.getHand().addCard(deck.drawCard());
        }
        System.out.println("Dealers full hand: ");
        dealer.printHand(); //prints dealers hand
        System.out.println("Dealers card total: "+dealer.getHand().getTotal());
        if(dealer.getHand().getTotal()>21){ //if dealer is over 21 then they bust
            System.out.println("Dealer Busts!");
        }
    }

    /**
     * determines if the player or dealer wins the round
     */
    public void winner(){
       for(Player player : players){
           if(checkWin(player)){ //checks the dealer if his hand is larger or equal to the players and its legal
               System.out.println("Dealer wins!");
               player.loseBet();
           }
           else { //for the player if they win
               System.out.println(player.getPlayerName()+" wins!");
               player.winBet();
           }
           System.out.println(player.getPlayerName()+"s new balance: $"+player.getBalance());
       }
    }

    /**
     * checks the dealer if his hand is larger or equal to the players and its legal
     * @return
     */
    public boolean checkWin(Player player){
        int dealerTotal = dealer.getHand().getTotal();
        int playerTotal = player.getHand().getTotal();

        if(dealerTotal > 21){ //dealer busts
            return false;
        }
        if(playerTotal > 21){ //player busts
            return true;
        }
        if(dealerTotal >= playerTotal && playerTotal <= 21){ //dealer wins and wins ties also makes sure player isnt busted
            return true;
        }
        return false; //player wins
    }

    /**
     * resets the players hand and dealers hand then removes player by getting remaining players
     */
    public void resetGame(){

        dealer.resetHand();//resets dealer hand

        ArrayList<Player> remaining = new ArrayList<>(); //new player arraylist to hold remaining players

        for(Player player: players){
            player.resetHand(); //resets players hand
            System.out.println(player.getPlayerName()+" do you want to leave(y/n)?");
            String answer = input.next();
            if (player.isBroke()||answer.equals("y")){ //means they are out or leaving
                System.out.println(player.getPlayerName()+" has been removed.");
            }
            else {
                remaining.add(player);//keeps player
            }
            players = remaining; //adds remaining back
            dealer.setPlayers(players); //sets new players

        }

    }

}



