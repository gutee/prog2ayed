package algoritmos.estructuras.pila;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 06/03/12
 * Time: 18:01
 * To change this template use File | Settings | File Templates.
 */
public class SumaPilaMain {
    public static void main(String[] args) {
        Pila pila = new PilaE();
        int numero = 1;
        int suma = 0;
        while (numero != 0) {
            System.out.println("Ingrese el número a ingresar a la pila: ");
            numero = new Scanner(System.in).nextInt();
            pila.apilar(numero);
        }
        while (!pila.esVacio()) {
            pila.desapilar();
        }
        System.out.println("La suma de los enteros en la pila es: " + suma);
    }
}