package algoritmos.estructuras.lista;

import java.lang.reflect.Array;

/**
 * User: Martin
 * Date: 10/04/12
 * Time: 11:45
 * To change this template use File | Settings | File Templates.
 */
public class ListaE implements Lista {
    Object[] lista;
    public int actual;
    int tamaño;
    int longitud;

    public ListaE() {
        tamaño = 10;
        lista = new Object[tamaño];
        actual = -1;
        longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public Object getActual() {
        return lista[actual];
    }

    public void insertarA(Object o) {
        if (actual == -1 && lista[0] == null) {
            lista[++actual] = o;
            longitud++;
        } else if (actual != -1 && lista[actual - 1] != null) {
            for (int i = longitud; i >= actual; i--) {
                lista[i + 1] = lista[i];
            }
            lista[actual] = o;
            longitud++;
        } else if (longitud + 1 == tamaño) {
            tamaño += tamaño;
            lista = new Object[tamaño];
            insertarA(o);
        }
    }

    public void insertarD(Object o) {
        if (actual == -1 && lista[0] == null) {
            lista[++actual] = o;
            longitud++;
        } else if (lista[actual + 1] == null && lista[actual] != null) {
            lista[++actual] = o;
            longitud++;
        } else if (lista[actual + 1] != null) {
            for (int i = longitud; i > actual; i--) {
                lista[i + 1] = lista[i];
            }
            lista[++actual] = o;
            longitud++;
        } else if (longitud + 1 == tamaño) {
            tamaño += tamaño;
            lista = new Object[tamaño];
            insertarD(o);
        }
    }

    public void vaciar() {
        tamaño = 10;
        lista = new Array[tamaño];
    }

    public void anterior() {
        if (actual > 0) {
            actual--;
        }
    }

    public void siguiente() {
        if (actual < longitud) {
            actual++;
        }
    }

    public void irPrimero() {
        actual = 0;
    }

    public void irUltimo() {
        actual = longitud - 1;
    }

    public void eliminar() {
        for (int i = actual; i < longitud; i++) {
            lista[i] = lista[i + 1];
        }
        longitud--;
    }

    public boolean esVacia() {
        return longitud == 0;
    }

    public void irA(int pos) {
        actual = pos;
    }
}
