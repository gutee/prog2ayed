package algoritmos.ejercicios.hemeroteca;

/**
 * Created by IntelliJ IDEA.
 * User: Martin Gutierrez
 * Date: 17/04/12
 * Time: 11:46
 */
public class Ejemplar {
    private int numeroDeSerie;
    private long tiempoUsado;
    private long horaEntrante;
    private String nombrePublicacion;

    Ejemplar(String nombrePublicacion) {
        numeroDeSerie = ((int) (Math.random() * 900)) + 100;
        tiempoUsado = 0;
        horaEntrante = 0;
        this.nombrePublicacion = nombrePublicacion;
    }

    public int getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public long getTiempoUsado() {
        return tiempoUsado;
    }

    public long getHoraEntrante() {
        return horaEntrante;
    }

    public void setHoraEntrante(long horaEntrante) {
        this.horaEntrante = horaEntrante;
    }

    public String getNombrePublicacion() {
        return nombrePublicacion;
    }

    public void agregarTiempoUsado(long tiempo) {
        tiempoUsado += tiempo;
    }
}