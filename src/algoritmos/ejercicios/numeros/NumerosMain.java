package algoritmos.ejercicios.numeros;

import algoritmos.estructuras.nodo.PilaD;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 27/03/12
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
public class NumerosMain {
    public static void main(String[] args) {
        System.out.println("Ingrese el primer elemento: ");
        int primerElemento = new Scanner(System.in).nextInt();
        PilaD numeros = new PilaD();
        PilaD numerosPares = new PilaD();
        PilaD numerosImpares = new PilaD();
        do {
            System.out.println("Ingrese otros números (cero para cortar el ingreso): ");
            numeros.apilar(new Scanner(System.in).nextInt());
        } while ((Integer) numeros.verTope() != 0);
        numeros.desapilar();
        while (!numeros.esVacio()) {
            if (esPar((Integer) numeros.verTope()) == 1) {
                numerosImpares.apilar(numeros.verTope());
                numeros.desapilar();
            } else if (esPar((Integer) numeros.verTope()) == 0) {
                numerosPares.apilar(numeros.verTope());
                numeros.desapilar();
            }
        }
        numeros = numerosImpares;
        numeros.apilar(primerElemento);
        while (!numerosPares.esVacio()) {
            numeros.apilar(numerosPares.verTope());
            numerosPares.desapilar();
        }
        while (!numeros.esVacio()) {
            System.out.println(numeros.verTope());
            numeros.desapilar();
        }
    }

    private static int esPar(int numero) {
        while (numero != 0 || numero != 1) {
            numero = numero / 2;
        }
        return numero;
    }
}
