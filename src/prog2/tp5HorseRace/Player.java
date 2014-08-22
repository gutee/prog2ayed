package prog2.tp5HorseRace;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 28/10/11
 * Time: 10:35
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private int position;
    String name;

    Player(int position, String name) {
        this.position = position;
        this.name = name;
    }

    Player(String name) {
        this.name = name;
        this.position = 1;
    }

    public void play() {
        Dice dice = new Dice();
        dice.roll();
        setPosition(position + dice.getValue());
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }
}