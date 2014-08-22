package prog2.tp5HorseRace;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 21/10/11
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
public abstract class TurnGame {

    public void playGame() {
        while (!isWinner()) {
            Player p = getNextPlayer();
            p.play();
        }
    }

    public abstract boolean isWinner();

    public abstract Player getNextPlayer();
}