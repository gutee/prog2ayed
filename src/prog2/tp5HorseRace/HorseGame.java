package prog2.tp5HorseRace;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 02/11/11
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
public class HorseGame extends TurnGame {
    private ArrayList<Player> players = new ArrayList();
    private int track;
    private int numberOfPlayers;
    private int turnPlayer;
    private final static int FIRSTPLAYER = 0;

    public void start() {
        System.out.println("Ingrese el número de jugadores: ");
        Scanner scanner = new Scanner(System.in);
        numberOfPlayers = scanner.nextInt();
        players(numberOfPlayers);
        System.out.println("Ingrese el tamaño de la pista: ");
        Scanner scanner2 = new Scanner(System.in);
        track = scanner2.nextInt();
    }

    public void playGame() {
        Player p = players.get(FIRSTPLAYER);
        p.play();
        while (!isWinner()) {
            p = getNextPlayer();
            p.play();
        }
        System.out.println("El ganador es: " + p.getName());
    }

    public ArrayList players(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("ingrese el nombre del jugador" + (i + 1));
            Scanner scanner = new Scanner(System.in);
            players.add(new Player(scanner.next()));
        }
        return players;
    }

    @Override
    public boolean isWinner() {
        Player p = players.get(turnPlayer);
        if (p.getPosition() >= track) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Player getNextPlayer() {
        if (turnPlayer == (players.size() - 1)) {
            turnPlayer = 0;
            getNextPlayer();
        } else {
            turnPlayer++;
        }
        return players.get(turnPlayer);
    }
}
