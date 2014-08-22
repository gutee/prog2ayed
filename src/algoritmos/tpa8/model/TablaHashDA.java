package algoritmos.tpa8.model;

import algoritmos.estructuras.lista.ListaD;

/**
 * User: Martin Gutierrez
 * Date: 06/06/12
 * Time: 12:47
 */
public class TablaHashDA {
    ListaD tablaHash[];
    int capacidad;

    TablaHashDA(int capacidad) {
        this.capacidad = capacidad;
        tablaHash = new ListaD[capacidad];
    }

    public void insertar(int clave, String palabra) {
        if (tablaHash[clave] == null) {
            tablaHash[clave] = new ListaD();
            tablaHash[clave].insertarD(palabra);
        } else {
            tablaHash[clave].insertarD(palabra);
        }
    }

    public ListaD buscarPalabras(int clave) {
        if (tablaHash[clave] != null) {
            return tablaHash[clave];
        } else {
            return null;
        }
    }
}