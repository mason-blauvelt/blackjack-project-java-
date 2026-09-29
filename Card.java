public class Card {
    private String value; //gets value
    private String suit; //ges suit

    /**
     * constructor for card
     * @param value
     * @param suit
     */
    public Card(String value,String suit){
        this.value = value;
        this.suit = suit;
    }

    /**
     * gets card value
     * @return
     */
    public String getValue(){
        return value;
    }

    /**
     * gets suit
     * @return
     */
    public String getSuit(){
        return suit;
    }

    /**
     * setter for value
     * @param value
     */
    public void setValue(String value){
        this.value=value;
    }

    /**
     * setter for suit
     * @param suit
     */
    public void setSuit(String suit){
        this.suit=suit;
    }

    /**
     * prints the card
     */
    public void printCard(){
        System.out.println(value+" of "+suit);//string not numbers values
    }

}
