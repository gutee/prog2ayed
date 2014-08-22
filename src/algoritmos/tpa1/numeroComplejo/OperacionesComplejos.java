package algoritmos.tpa1.numeroComplejo;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 29/02/12
 * Time: 23:57
 * To change this template use File | Settings | File Templates.
 */
public class OperacionesComplejos {
    NumeroComplejo a;
    NumeroComplejo b;

    public static NumeroComplejo suma(NumeroComplejo a, NumeroComplejo b) {
        double re = a.obtenerRe() + b.obtenerRe();
        double im = a.obtenerIm() + b.obtenerIm();
        return new NumeroComplejo(re, im);
    }

    public static NumeroComplejo resta(NumeroComplejo a, NumeroComplejo b) {
        double re = a.obtenerRe() - b.obtenerRe();
        double im = a.obtenerIm() - b.obtenerIm();
        return new NumeroComplejo(re, im);
    }

    public static NumeroComplejo producto(NumeroComplejo a, NumeroComplejo b) {
        double re = a.obtenerRe() * b.obtenerRe() - a.obtenerIm() * b.obtenerIm();
        double im = a.obtenerRe() * b.obtenerIm() + a.obtenerIm() * b.obtenerRe();
        return new NumeroComplejo(re, im);
    }

    public static NumeroComplejo cociente(NumeroComplejo a, NumeroComplejo b) {
        double re, im;
        if (b.calcularModulo() == 0) {
            return null;
        } else {
            re = (a.obtenerRe() * b.obtenerRe() + a.obtenerIm() * b.obtenerIm()) / b.calcularModulo();
            im = (a.obtenerIm() * b.obtenerRe() - a.obtenerRe() * b.obtenerIm() / b.calcularModulo());
            return new NumeroComplejo(re, im);
        }
    }
}