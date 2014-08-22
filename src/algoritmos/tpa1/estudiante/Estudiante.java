package algoritmos.tpa1.estudiante;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 29/02/12
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 */
public class Estudiante {
    private int matricula;
    private int comision;

    Estudiante(int matricula, int comision) {
        this.matricula = matricula;
        this.comision = comision;
    }

    public int obtenerMatricula() {
        return matricula;
    }

    public void modificarMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int obtenerComision() {
        return comision;
    }

    public void modificarComision(int comision) {
        this.comision = comision;
    }
}