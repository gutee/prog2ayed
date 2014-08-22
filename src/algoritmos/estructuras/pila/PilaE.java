package algoritmos.estructuras.pila;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 13/03/12
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */
public class PilaE implements Pila {
    private Object[] datos;
    private int tope;
    private int max = 10;

    public PilaE() {
        datos = new Object[max];
        tope = -1;
    }

    public void apilar(Object o) {
        tope++;
        if (tope > max - 1) {
            max = max * 2;
            Object[] aux = new Object[max];
            for (int i = 0; i < datos.length; i++) {
                datos[i] = aux[i];
            }
            datos = aux;
        }
        datos[tope] = o;
    }

    public void desapilar() {
        if (tope > -1) {
            tope--;
        }
    }

    public void vaciar() {
        tope = -1;
    }

    public Object verTope() {
        if (esVacio()) {
            return null;
        } else {
            return datos[tope];
        }
    }

    public boolean esVacio() {
        return tope == -1;
    }
}