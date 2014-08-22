package algoritmos.tpa1.numeroComplejo;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 29/02/12
 * Time: 22:36
 * To change this template use File | Settings | File Templates.
 */
public class NumeroComplejo {
    private double re;
    private double im;

    NumeroComplejo(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double calcularModulo() {
        return Math.sqrt((Math.pow(re, 2)) + (Math.pow(im, 2)));
    }

    public double obtenerRe() {
        return re;
    }

    public void modificarRe(int re) {
        this.re = re;
    }

    public double obtenerIm() {
        return im;
    }

    public void modificarIm(int im) {
        this.im = im;
    }

    public String toString() {
        return obtenerRe() + " + " + obtenerIm() + " i";
    }
}