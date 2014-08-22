package algoritmos.estructuras.listaOrdenada;

import algoritmos.estructuras.arbolBinario.NodoDoble;
import algoritmos.estructuras.nodo.Nodo;

import java.io.Serializable;

/**
 * User: Martin Gutierrez
 * Date: 09/05/12
 * Time: 18:25
 */
public class ListaOrd implements Serializable {
    Nodo lista;
    Nodo actual;
    int longitud;

    public ListaOrd() {
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

    public void insertar(Object x) {
        Nodo nuevo = new Nodo(x, null);
        if (lista == null) {
            lista = nuevo;
        } else {
            if (((Comparable) lista.dato).compareTo(x) > 0) {
                nuevo.nodo = lista;
                lista = nuevo;
            } else {
                Nodo reco = lista;
                Nodo atras = lista;
                while ((((Comparable) reco.dato).compareTo(x) < 0 || ((Comparable) reco.dato).compareTo(x) == 0) && reco.nodo != null) {
                    atras = reco;
                    reco = reco.nodo;
                }
                if (((Comparable) reco.dato).compareTo(x) < 0 || ((Comparable) reco.dato).compareTo(x) == 0) {
                    reco.nodo = nuevo;
                } else {
                    nuevo.nodo = reco;
                    atras.nodo = nuevo;
                }
            }
        }
        actual = nuevo;
        longitud++;
    }

    public void vaciar() {
        lista = null;
        actual = null;
        longitud = 0;
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

    public Object getObject(int i) {
        irA(i);
        return getActual();
    }
}
