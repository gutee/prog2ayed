package algoritmos.estructuras.pila;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 06/03/12
 * Time: 18:30
 * To change this template use File | Settings | File Templates.
 */
public class InvertirPilaMain {
    public static void main(String[] args) {
        Pila pila = new PilaE();
        Pila pilaInvertida = new PilaE();
        while (!pila.esVacio()) {
            pilaInvertida.apilar(pila.verTope());
            pila.desapilar();
        }
    }
}