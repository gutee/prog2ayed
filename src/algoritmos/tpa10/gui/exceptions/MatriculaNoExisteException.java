package algoritmos.tpa10.gui.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/24/12
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatriculaNoExisteException extends Exception{
    public final static String message = "No existe la matricula";

    public MatriculaNoExisteException() {
        super(message);
    }
}
