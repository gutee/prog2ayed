package algoritmos.ejercicios.archivosBinarios;

/**
 * User: Martin Gutierrez
 * Date: 16/05/12
 * Time: 09:50
 */
public class Producto {
    boolean borrado;
    private int codigo;
    private String descripcion;
    private double precio;
    private boolean hay;
    private char tipo;

    public Producto(boolean borrado, int codigo, String descripcion, double precio, boolean hay, char tipo) {
        this.borrado = borrado;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.hay = hay;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isHay() {
        return hay;
    }

    public void setHay(boolean hay) {
        this.hay = hay;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public void fijar(int cant) {
        if (descripcion.length() > cant) {
            descripcion = descripcion.substring(0, cant);
        } else {
            for (int i = descripcion.length(); i < cant; i++) {
                descripcion += " ";
            }
        }
    }
}
