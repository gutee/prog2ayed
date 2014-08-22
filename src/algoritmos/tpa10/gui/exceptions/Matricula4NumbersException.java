package algoritmos.tpa10.gui.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/24/12
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Matricula4NumbersException extends Exception{
    private static final String message = "La matricula debe ser de 4 numeros";

    public Matricula4NumbersException() {
        super(message);
    }
}
