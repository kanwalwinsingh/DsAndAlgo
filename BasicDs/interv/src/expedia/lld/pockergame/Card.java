package expedia.lld.pockergame;

import java.util.List;

public class Card {
    private Suit suit;
    private Rank rank;
}

class Suit {

}

class Rank {

}

//Deck.java
class Deck{
    private List<Card> cards;
    public void shuffle(){
        //shuffle cards
    }

    public Card draw(){
        //Draw a card from the deck
        return null;
    }
}

class Player{
    private String id;
    private List<Card> hand;
    private int chips;


    public void bet(int amount){
        // Player places a bet
    }

    public void fold(){
        // Player folds
    }
}

class GameEngine {
    private Deck deck;
    private List<Player> players;
    private Pot pot;

    public void startGame(){
        //Initalize game state and deal cards
    }

    public void handlePlayerAction(Player player, Action action){
        // Process player action
    }

    public Player determineWinner(){
        //Evaluate hands and determine the winner
        return null;
    }
}

class Pot {

}