package algoritmos.estructuras.nodo;

import algoritmos.estructuras.pila.Pila;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 13/03/12
 * Time: 18:04
 * To change this template use File | Settings | File Templates.
 */
public class PilaD implements Pila {
    private Nodo tope;

    public PilaD() {
        tope = null;
    }

    public void apilar(Object o) {
        if (tope == null) {
            tope = new Nodo(o, null);
        } else {
            tope = new Nodo(o, tope);
        }
    }

    public void desapilar() {
        if (tope.nodo == null) {
            tope = null;
        } else {
            tope = tope.nodo;
        }
    }

    public void vaciar() {
        tope = null;
    }

    public Object verTope() {
        if (tope == null) {
            return null;
        } else {
            return tope.dato;
        }
    }

    public boolean esVacio() {
        if (tope == null) {
            return true;
        }
        return false;
    }
}
