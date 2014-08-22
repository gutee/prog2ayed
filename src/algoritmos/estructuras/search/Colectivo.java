package algoritmos.estructuras.search;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 07/03/12
 * Time: 10:17
 * To change this template use File | Settings | File Templates.
 */
public class Colectivo implements Comparable {
    private int linea;
    private int internos;

    public Colectivo(int linea, int internos) {
        this.linea = linea;
        this.internos = internos;
    }

    public int getLinea() {
        return linea;
    }

    public int getInternos() {
        return internos;
    }

    public int compareTo(Object o) {
        if (linea != ((Colectivo) o).getLinea()) {
            return linea - ((Colectivo) o).getLinea();
        }
        if (internos != ((Colectivo) o).getInternos()) {
            return internos - ((Colectivo) o).getInternos();
        }
        return 0;
    }
}