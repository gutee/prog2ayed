package algoritmos.tpa2.analizadorLexicografico;

import algoritmos.estructuras.pila.Pila;
import algoritmos.estructuras.pila.PilaE;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 14/03/12
 * Time: 14:16
 * To change this template use File | Settings | File Templates.
 */
public class Analizador {
    Pila pila = new PilaE();

    public boolean analizadorLexicografico(String texto) {
        char corA = '[';
        char corB = ']';
        char llavA = '{';
        char llavB = '}';
        char parA = '(';
        char parB = ')';

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == corA || texto.charAt(i) == llavA || texto.charAt(i) == parA) {
                pila.apilar(texto.charAt(i));
            } else if (texto.charAt(i) == corB) {
                if (!pila.esVacio()) {
                    if ((Character) pila.verTope() == corA) {
                        pila.desapilar();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (texto.charAt(i) == llavB) {
                if (!pila.esVacio()) {
                    if ((Character) pila.verTope() == llavA) {
                        pila.desapilar();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (texto.charAt(i) == parB) {
                if (!pila.esVacio()) {
                    if ((Character) pila.verTope() == parA) {
                        pila.desapilar();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return pila.esVacio();
    }
}
