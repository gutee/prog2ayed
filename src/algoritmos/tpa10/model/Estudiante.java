package algoritmos.tpa10.model;

/**
 * User: Martin Gutierrez
 * Date: 30/05/12
 * Time: 09:30
 */
public class Estudiante {
    private boolean borrado;
    private int matricula;
    private char comision;
    private String nombreApellido;

    public Estudiante(boolean borrado, int matricula, char comision, String nombreApellido) {
        this.borrado = borrado;
        this.matricula = matricula;
        this.comision = comision;
        this.nombreApellido = nombreApellido;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public char getComision() {
        return comision;
    }

    public void setComision(char comision) {
        this.comision = comision;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public void fijar(int cant) {
        if (nombreApellido.length() > cant) {
            nombreApellido = nombreApellido.substring(0, cant);
        } else {
            for (int i = nombreApellido.length(); i < cant; i++) {
                nombreApellido += " ";
            }
        }
    }
}