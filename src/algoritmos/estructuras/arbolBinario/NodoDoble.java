package algoritmos.estructuras.arbolBinario;

import java.io.Serializable;

/**
 * User: Martin Gutierrez
 * Date: 28/03/12
 * Time: 10:50
 */
public class NodoDoble implements Serializable {
    Object dato;
    NodoDoble izq, der;

    public NodoDoble(Object dato) {
        this.dato = dato;
    }
}
