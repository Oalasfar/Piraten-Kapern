package pk;

import java.util.Arrays;

public class Deck {
    private Cards[] deck;

    public Deck() {
        deck = new Cards[35];
        int index = 0;
        for (int i = 0; i < 6; i++) {
            deck[index++] = Cards.Sea_Battle;
        }
        for (int i = 0; i < 25; i++) {
            deck[index++] = Cards.NOP;
        }
        for (int i = 0; i < 4; i++) {
            deck[index++] = Cards.Monkey_Bus;
        }
    }

    public Cards draw() {
        int remainingCards = deck.length - 1;
        if (remainingCards == 0) {
            return null;
        }
        int randomIndex = (int) (Math.random() * deck.length);
        Cards card = deck[randomIndex];
        deck[randomIndex] = deck[deck.length - 1];
        deck[deck.length - 1] = null;
        deck = Arrays.copyOf(deck, deck.length - 1);
        return card;
    }
}