package algoritmos.estructuras.nodo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 13/03/12
 * Time: 13:00
 * To change this template use File | Settings | File Templates.
 */
public class Nodo implements Serializable {
    public Nodo nodo;
    public Object dato;

    public Nodo(Object dato, Nodo nodo) {
        this.nodo = nodo;
        this.dato = dato;
    }
}