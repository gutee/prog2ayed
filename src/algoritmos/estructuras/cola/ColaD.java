package algoritmos.estructuras.cola;

import algoritmos.estructuras.nodo.Nodo;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 27/03/12
 * Time: 12:19
 * To change this template use File | Settings | File Templates.
 */
public class ColaD implements Cola {
    Nodo frente;
    Nodo fondo;

    public ColaD() {
        frente = null;
        fondo = null;
    }

    public void encolar(Object o) {
        if (frente == null) {
            frente = new Nodo(o, null);
            fondo = frente;
        } else {
            fondo.nodo = new Nodo(o, null);
            fondo = fondo.nodo;
        }
    }

    public Object desencolar() {
        Object o = null;
        try {
            if (frente.dato != null) {
                o = frente.dato;
            }
            if (frente.nodo == null) {
                frente = null;
                return o;
            } else {
                frente = frente.nodo;
                return o;
            }
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public boolean esVacia() {
        return frente == null;
    }

    public void vaciar() {
        frente = null;
        fondo = null;
    }
}
