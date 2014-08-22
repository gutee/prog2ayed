package algoritmos.tpa10.gui.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/24/12
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class MariaException extends Exception {
    private static final String message = "No se puede ingresar este Alumno,\n podria ser peligroso para el programa";

    public MariaException() {
        super(message);
    }
}
