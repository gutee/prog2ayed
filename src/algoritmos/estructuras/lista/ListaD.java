package algoritmos.estructuras.lista;

import algoritmos.estructuras.nodo.Nodo;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 10/04/12
 * Time: 13:15
 */
public class ListaD implements Lista {
    Nodo lista;
    Nodo actual;
    int longitud;

    public ListaD() {
        lista = null;
        actual = null;
        longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public Object getActual() {
        if (actual == null) {
            return null;
        }
        return actual.dato;
    }

    public void insertarA(Object o) {
        if (lista == null) {
            lista = new Nodo(o, null);
            actual = lista;
            longitud++;
        } else {
            anterior();
            insertarD(o);
        }
    }

    public void insertarD(Object o) {
        if (lista == null) {
            lista = new Nodo(o, null);
            actual = lista;
            longitud++;
        } else {
            Nodo aux = new Nodo(o, null);
            aux.nodo = actual.nodo;
            actual.nodo = aux;
            actual = aux;
            longitud++;
        }
    }

    public void vaciar() {
        lista = null;
        actual = null;
    }

    public void anterior() {
        Nodo aux, ant;
        ant = null;
        aux = lista;
        while (aux != actual) {
            ant = aux;
            aux = aux.nodo;
        }
        if (ant != null) {
            actual = ant;
        }
    }

    public void siguiente() {
        if (lista != null) {
            actual = actual.nodo;
        } else if (actual.nodo == null) {
            actual = actual;
        }
    }

    public void irPrimero() {
        actual = lista;
    }

    public void irUltimo() {
        Nodo aux = lista;
        while (aux.nodo != null) {
            aux = aux.nodo;
        }
        actual = aux;
    }

    public void eliminar() {
        if (lista != null) {
            if (longitud == 1) {
                lista = null;
                actual = null;
            } else if (actual.nodo != null) {
                actual.dato = actual.nodo.dato;
                actual.nodo = actual.nodo.nodo;
            } else {
                anterior();
                actual.nodo = null;
            }
            longitud--;
        }
    }

    public boolean esVacia() {
        return longitud == 0;
    }

    public void irA(int pos) {
        actual = lista;
        int posActual = 1;
        while (posActual < pos) {
            posActual++;
            actual = actual.nodo;
        }
    }
}