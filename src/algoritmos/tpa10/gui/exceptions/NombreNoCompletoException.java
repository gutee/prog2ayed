package algoritmos.tpa10.gui.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/24/12
 * Time: 7:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class NombreNoCompletoException extends Exception{
    private static final String message = "Debe completar el nombre";

    public NombreNoCompletoException() {
        super(message);
    }
}
