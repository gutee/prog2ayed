package algoritmos.tpa10.model;

import java.io.Serializable;

/**
 * User: Martin Gutierrez
 * Date: 30/05/12
 * Time: 09:55
 */
public class ArchivoIndice implements Comparable, Serializable {
    private int clave;
    private long posicion;

    public ArchivoIndice(int clave, long posicion) {
        this.clave = clave;
        this.posicion = posicion;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public long getPosicion() {
        return posicion;
    }

    public void setPosicion(long posicion) {
        this.posicion = posicion;
    }

    public int compareTo(Object o) {
        return ((Integer) clave).compareTo(((ArchivoIndice) o).clave);
    }

    public String toString() {
        return String.valueOf(clave);
    }
}