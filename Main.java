public class Main {
    public static void main(String[] args) {

        Deck deck = new Deck(); //creates deck
        Game game = new Game(); //creates game
        deck.shuffleDeck(); //shuffles deck before game starts
        game.setupPlayers(); //sets up players
        while(game.getPlayers().size()>0) { //loop for rounds
            deck = new Deck(); //makes new deck
            deck.shuffleDeck(); //shuffles the deck
            game.setupDealer(deck); //sets up dealer
            game.getDealer().setBets(); //gets bets in game using dealer
            game.playerHand(deck); //makes players hand
            game.getDealer().Choice(); //gets the dealer to get choices
            game.dealersTurn(deck); //dealers turn to draw until 17
            game.winner(); //finds winner
            game.resetGame(); //resets game by resetting hand and removing players if needed
        }
            System.out.println("All players are out."); //prints when games over

    }

}