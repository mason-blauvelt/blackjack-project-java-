import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck; //arraylist for deck
    static String[] values = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"}; //card values as strings
    static String[] suits = {"Clubs","Spades","Hearts","Diamonds"}; //card suits

    /**
     * constructor for deck
     */
    public Deck(){
        deck = new ArrayList<>(); //makes new arraylist for the deck
        createDeck(); //creates the deck
    }

    /**
     * creates the deck of cards using the suits and values
     */
    public void createDeck(){

        for(String suit : suits){ //nested for loop to create cards in deck
            for(String value: values){
                deck.add(new Card(value,suit)); //adds card into deck with suit and value
            }
        }
    }

    /**
     * shuffles deck for now
     */
    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    /**
     * draws card from first index of deck
     * @return
     */
    public Card drawCard(){
        if(deck.isEmpty()){
            createDeck();
            shuffleDeck();
        }
        return deck.remove(0);
    }


}
