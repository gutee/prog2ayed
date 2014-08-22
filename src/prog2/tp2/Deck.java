package prog2.tp2;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.*;

/**
 * Created by Martin Gutierrez.
 * User: Martin
 * Date: 19/08/11
 * Time: 11:28
 */
public class Deck {
    private ArrayList<Card> cards;

    public Deck(ArrayList<Card> cards) {
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

    public void createPlayer(int players, int cardsQuantity) {
        for (int i = 0; i < players; i++) {
            createPlayer(cardsQuantity);
        }
    }

    private Player createPlayer(int cardsQuantity) {
        Player player = new Player();
        for (int j = 0; j < cardsQuantity; j++) {
            player.add(drawFromDeck());
        }
        return player;
    }

    public Card drawFromDeck() {
        return cards.remove(0);
    }
}