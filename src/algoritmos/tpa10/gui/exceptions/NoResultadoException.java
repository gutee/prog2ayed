package algoritmos.tpa10.gui.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 7/4/12
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class NoResultadoException extends Exception{
    private static final String message = "No se encontro ningun resultado";

    public NoResultadoException() {
        super(message);
    }
}
