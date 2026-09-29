public class Player {

    private String playerName; //players name
    private Hand hand; //players hand
    private double currentBet; //players current bet
    private double balance; //players balance

    /**
     * constructor for player
     * @param playerName
     */
    public Player(String playerName){
        hand = new Hand(); //gives them a hand
        this.playerName=playerName; //gets their name
        this.balance = 100; //gives everyone default starting value of 100
    }

    /**
     * gets hand
     * @return
     */
    public Hand getHand(){
        return hand;
    }

    /**
     * gets playername
     * @return
     */
    public String getPlayerName(){
        return playerName;
    }

    /**
     * gets current bet
     * @return
     */
    public double getCurrentBet(){
        return currentBet;
    }

    /**
     * places bet and removes it from balance
     * @param amount
     */
    public void placeBet(double amount){
        currentBet = amount;
        balance -= amount;
    }

    /**
     * adds bet*2 to your balance if you win
     */
    public void winBet(){
        balance += currentBet*2;
    }

    /**
     * if loses bet then you dont get monety added back to balance
     */
    public void loseBet(){
        currentBet=0;
    }

    /**
     * gets balance for player
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     * makes you double your bet and take it away from balance
     */
    public void doubleDown(){
        balance -= currentBet;
        currentBet *= 2;
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
     * resets hand
     */
    public void resetHand(){
        hand.clear();
        currentBet = 0;
    }

    /**
     * are broke if they have 0(or negative balance which shouldnt be possible)
     * @return
     */
    public boolean isBroke() {
        if(balance <=0){ //checks balance
            return true; //true means broke
        }
        else{
            return false;
        }
    }






}
