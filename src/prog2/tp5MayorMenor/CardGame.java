package prog2.tp5MayorMenor;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 03/11/11
 * Time: 14:55
 * To change this template use File | Settings | File Templates.
 */
public class CardGame {
    public int score, lastValue, value;
    public boolean b;

    public void start() {
        Deck deck = DeckFactory.createSpanishDeck();
        deck.shuffleDeck();
        int firstCard = deck.drawFromDeck().getNumber();
        System.out.println("El valor de la primera carta es: " + firstCard);
        while (deck.cards.size() > 0) {
            lastValue = value;
            System.out.println("El valor de la última carta es: " + lastValue);
            System.out.println("mayor, menor o igual?");
            Scanner scanner = new Scanner(System.in);
            value = (deck.drawFromDeck().getNumber());
            String s = scanner.next();
            if (s.equals("menor")) {
                b = winnerMenor(value, lastValue);
            }
            if (s.equals("mayor")) {
                b = winnerMayor(value, lastValue);
            }
            if (s.equals("igual")) {
                b = winnerIgual(value, lastValue);
            }
            if (b) {
                System.out.println("El valor de la carta extraida es: " + value);
                score++;
                System.out.println("Bien! Tu score es de: " + score);
            } else {
                System.out.println("El valor de la carta extraida es: " + value);
                score--;
                System.out.println("No pete! Tu score es de: " + score);
            }
        }

    }

    public boolean winnerMenor(int value, int lastValue) {
        return value < lastValue;
    }

    public boolean winnerIgual(int value, int lastValue) {
        return value == lastValue;
    }

    public boolean winnerMayor(int value, int lastValue) {
        return value > lastValue;
    }
}