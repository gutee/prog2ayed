package prog2.tp5MayorMenor;

import prog2.tp5HorseRace.Dice;
import prog2.tp5MayorMenor.Card;
import prog2.tp5MayorMenor.Deck;

import java.util.ArrayList;

public class DeckFactory {

    public static Deck createPokerDeck() {
        ArrayList cards = new ArrayList();
        for (int suit = 1; suit <= 4; suit++) {
            for (int number = 1; number <= 13; number++) {
                cards.add(new Card(suit, number));
            }
        }
        return new Deck(cards);
    }

    public static Deck createSpanishDeck() {
        ArrayList cards = new ArrayList();
        for (int suit = 1; suit <= 4; suit++) {
            for (int number = 1; number <= 12; number++) {
                cards.add(new Card(suit, number));
            }
        }
        return new Deck(cards);
    }

    public static Deck createTrucoDeck() {
        ArrayList cards = new ArrayList();
        for (int suit = 1; suit <= 4; suit++) {
            for (int number = 1; number <= 12; number++) {
                if ((number == 8) ^ (number == 9)) {
                    continue;
                }
                cards.add(new Card(suit, number));
            }
        }
        return new Deck(cards);
    }
}