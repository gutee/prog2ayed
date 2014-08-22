package algoritmos.tpa7;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 12/04/12
 * Time: 18:28
 * To change this template use File | Settings | File Templates.
 */
public class Lampara implements Comparable {
    private String codigo;
    private int watts;
    private String tipo;
    private int cantidad;

    public Lampara(String codigo, int watts, String tipo, int cantidad) {
        this.codigo = codigo;
        this.watts = watts;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public Lampara(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getWatts() {
        return watts;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int compareTo(Object o) {
        return codigo.compareToIgnoreCase(((Lampara) o).codigo);
    }

    public String toString() {
        return "Código: " + codigo + "\nWatts: " + watts + "\nTipo: " + tipo + "\nCantidad: " + cantidad;
    }

    public void subirStock(int cuantos) {
        cantidad += cuantos;
    }

    public void bajarStock(int cuantos) {
        cantidad -= cuantos;
    }
}