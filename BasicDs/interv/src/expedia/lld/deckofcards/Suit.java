package expedia.lld.deckofcards;

public enum Suit {
    CLUB,
    DIAMOND,
    HEART,
    SPADE
}

class Card{
    private int value;
    private Suit suit;
    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }
}

class Deck {
    private int numOfCards;
    private Card cards;
}
