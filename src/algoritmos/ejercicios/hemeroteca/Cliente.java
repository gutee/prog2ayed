package algoritmos.ejercicios.hemeroteca;

import algoritmos.estructuras.lista.ListaD;

/**
 * Created by IntelliJ IDEA.
 * User: Martin Gutierrez
 * Date: 17/04/12
 * Time: 12:10
 */
public class Cliente {
    private long dni;
    private Ejemplar ejemplar;
    private ListaD tiempoEjemplares;

    Cliente(long dni) {
        this.dni = dni;
        ejemplar = null;
        tiempoEjemplares = new ListaD();
    }

    public long getDni() {
        return dni;
    }

    public Ejemplar sacarEjemplar() {
        Ejemplar ejemplarAux = ejemplar;
        ejemplar = null;
        ejemplarAux.agregarTiempoUsado(System.currentTimeMillis() - ejemplarAux.getHoraEntrante());
        tiempoEjemplares.insertarD(ejemplarAux);
        ejemplarAux.setHoraEntrante(0);
        return ejemplarAux;
    }

    public void agregarEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
        ejemplar.setHoraEntrante(System.currentTimeMillis());
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }
}
