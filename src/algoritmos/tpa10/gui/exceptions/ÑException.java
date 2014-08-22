package algoritmos.tpa10.gui.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/24/12
 * Time: 6:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class ÑException extends Exception {
    private static final String message = "Este programa no soporta nombres con Ñ";

    public ÑException() {
        super(message);
    }
}
