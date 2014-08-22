package algoritmos.ejercicios.backtracking;

import algoritmos.estructuras.pila.PilaE;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 20/03/12
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */
public class Caballo {
    private int[] posicion = new int[2];

    Caballo() {
        posicion[0] = 0;
        posicion[1] = 0;
    }

    public void setPosicion(int[] x) {
        posicion[0] = x[0];
        posicion[1] = x[1];
    }

    private int[] moverCaballo(int movimiento) {
        switch (movimiento) {
            case (1):
                posicion[0] += 1;
                posicion[1] += 2;
                break;
            case (2):
                posicion[0] -= 1;
                posicion[1] += 2;
                break;
            case (3):
                posicion[0] += 2;
                posicion[1] += 1;
                break;
            case (4):
                posicion[0] -= 2;
                posicion[1] += 1;
                break;
            case (5):
                posicion[0] += 1;
                posicion[1] -= 2;
                break;
            case (6):
                posicion[0] -= 1;
                posicion[1] -= 2;
                break;
            case (7):
                posicion[0] += 2;
                posicion[1] -= 1;
                break;
            case (8):
                posicion[0] -= 2;
                posicion[1] -= 1;
                break;
            default:
                break;
        }
        if (posicion[0] < 0 || posicion[0] > 7 || posicion[1] < 0 || posicion[1] > 7) {
            return null;
        } else
            return posicion;
    }

    public PilaE calcularUno() {
        PilaE pilaSaltoUno = new PilaE();
        PilaE pilaAux = new PilaE();
        for (int i = 1; i <= 8; i++) {
            Caballo caballo = new Caballo();
            pilaSaltoUno.apilar(caballo.moverCaballo(i));
        }
        while (!pilaSaltoUno.esVacio()) {
            if (pilaSaltoUno.verTope() == null) {
                pilaSaltoUno.desapilar();
            } else {
                pilaAux.apilar(pilaSaltoUno.verTope());
                pilaSaltoUno.desapilar();
            }
        }
        return pilaAux;
    }

    public PilaE calcularSiguienteSalto(PilaE pilaSaltoAnterior) {
        PilaE pilaSaltoSiguiente = new PilaE();
        PilaE pilaAux = new PilaE();
        while (!pilaSaltoAnterior.esVacio()) {
            for (int i = 1; i <= 8; i++) {
                Caballo caballo = new Caballo();
                caballo.setPosicion((int[]) pilaSaltoAnterior.verTope());
                pilaSaltoSiguiente.apilar(caballo.moverCaballo(i));
            }
            pilaSaltoAnterior.desapilar();
        }
        while (!pilaSaltoSiguiente.esVacio()) {
            if (pilaSaltoSiguiente.verTope() == null) {
                pilaSaltoSiguiente.desapilar();
            } else {
                pilaAux.apilar(pilaSaltoSiguiente.verTope());
                pilaSaltoSiguiente.desapilar();
            }
        }
        return pilaAux;
    }

    public void imprimirSalto(PilaE pilaSalto) {
        while (!pilaSalto.esVacio()) {
            int[] a = (int[]) pilaSalto.verTope();
            System.out.println(a[0] + " , " + a[1]);
            pilaSalto.desapilar();

        }
    }
}