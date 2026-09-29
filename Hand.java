import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand; //makes arraylist which is the hand

    /**
     * creates empty hand
     */
    public Hand(){
        hand = new ArrayList<>(); //arraylist for hand
    }

    /**
     * adds card to hand
     * @param card
     */
    public void addCard(Card card){
        hand.add(card);
    }

    /**
     * getter for hand
     * @return
     */
    public ArrayList<Card> getHand(){
        return hand;
    }

    /**
     * clears the hand
     */
    public void clear(){
        hand.clear();
    }

    /**
     * gets numeric value for the card string value using switch case
     * @param card
     * @return
     */
    public int getCardValue(Card card){
        String value = card.getValue();
        switch (value) {
            case "Ace":
                return 11;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            default:
                return 10; //for face and 10
        }
    }

    /**
     * gets number of aces in hand and if over 21 it changes ace from 11 to 1
     * @return
     */
    public int getTotal() {
        int total = 0;
        int aces = 0;
        for (Card c : hand) {
            int val = getCardValue(c);
            if (getCardValue(c)==11) {
                aces++;
            }
                total += val; //gets total of hand
        }
            while (total > 21 && aces > 0) { //check to see if ace needs changed
                total -= 10;
                aces--; //decrements ace
            }
        return total; //returns hand total
    }
}
