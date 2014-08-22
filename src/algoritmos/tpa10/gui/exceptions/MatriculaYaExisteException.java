package algoritmos.tpa10.gui.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/24/12
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatriculaYaExisteException extends Exception{
    private static final String message = "La Matricula Ya Existe";

    public MatriculaYaExisteException() {
        super(message);
    }
}
