package algoritmos.tpa10.gui.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/24/12
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComisionException extends Exception {
    private static final String message = "La comision debe ser una letra";

    public ComisionException() {
        super(message);
    }
}
