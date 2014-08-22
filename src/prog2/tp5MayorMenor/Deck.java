package prog2.tp5MayorMenor;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Martin Gutierrez.
 * User: Martin
 * Date: 19/08/11
 * Time: 11:28
 */
public class Deck {
    public ArrayList<Card> cards;

    Deck(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public void cutDeck() {
        for (int i = 0; i < (cards.size()) / 2; i++) {
            for (int j = (cards.size()) / 2; j < cards.size(); j++) {
                Collections.swap(cards, i, j);
            }
        }
    }

    public Card drawFromDeck() {
        return cards.remove(0);
    }
}