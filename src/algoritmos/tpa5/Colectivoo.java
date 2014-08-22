package algoritmos.tpa5;

import java.io.Serializable;

/**
 * User: Martin Gutierrez
 * Date: 09/05/12
 * Time: 20:11
 */
public class Colectivoo implements Comparable, Serializable {
    private int linea;
    private int interno;
    private int asientos;
    boolean discapacitados;

    public Colectivoo(int linea, int interno, int asientos, boolean discapacitados) {
        this.linea = linea;
        this.interno = interno;
        this.asientos = asientos;
        this.discapacitados = discapacitados;
    }

    public int getLinea() {
        return linea;
    }

    public int getInterno() {
        return interno;
    }

    public int getAsientos() {
        return asientos;
    }

    public boolean isDiscapacitados() {
        return discapacitados;
    }

    public int compareTo(Object o) {
        if (linea != ((Colectivoo) o).getLinea()) {
            return linea - ((Colectivoo) o).getLinea();
        }
        if (interno != ((Colectivoo) o).getInterno()) {
            return interno - ((Colectivoo) o).getInterno();
        }
        return 0;
    }
}