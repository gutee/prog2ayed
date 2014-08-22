package algoritmos.ejercicios.testEstructuras;

import algoritmos.estructuras.cola.Cola;
import algoritmos.estructuras.cola.ColaD;
import algoritmos.estructuras.cola.ColaE;
import algoritmos.estructuras.lista.Lista;
import algoritmos.estructuras.lista.ListaD;
import algoritmos.estructuras.lista.ListaE;
import algoritmos.estructuras.nodo.PilaD;
import algoritmos.estructuras.pila.Pila;
import algoritmos.estructuras.pila.PilaE;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin Gutierrez
 * Date: 17/04/12
 * Time: 20:35
 */
public class TestEstructurasMain {
    public static void main(String[] args) {
        Pila miPilaE = new PilaE();
        Pila miPilaD = new PilaD();
        Cola miColaE = new ColaE();
        Cola miColaD = new ColaD();
        Lista miListaE = new ListaE();
        Lista miListaD = new ListaD();

        int entero = 1;
        while (entero != 0) {
            System.out.println("Ingrese un número, cero para cortar el ingreso: ");
            entero = new Scanner(System.in).nextInt();
            if (entero == 0) {
                break;
            }
            miPilaE.apilar(entero);
            miPilaD.apilar(entero);
            miColaE.encolar(entero);
            miColaD.encolar(entero);
            miListaE.insertarD(entero);
            miListaD.insertarD(entero);
        }

        while (entero != 4) {
            menu1();
            entero = new Scanner(System.in).nextInt();
            int dentroDelMenu = 6;
            switch (entero) {
                case (1):
                    while (dentroDelMenu != 0) {
                        menuPila();
                        dentroDelMenu = new Scanner(System.in).nextInt();
                        switch (dentroDelMenu) {
                            case (1):
                                System.out.println("\nPilaE tope: " + miPilaE.verTope());
                                System.out.println("\nPilaD tope: " + miPilaD.verTope());
                                break;
                            case (2):
                                miPilaE.desapilar();
                                miPilaD.desapilar();
                                System.out.println("\nPilaE tope: " + miPilaE.verTope());
                                System.out.println("PilaD tope: " + miPilaD.verTope());
                                break;
                            case (3):
                                if (!miPilaE.esVacio()) {
                                    do {
                                        miPilaE.desapilar();
                                        System.out.println("\nPilaE tope: " + miPilaE.verTope());
                                    } while (!miPilaE.esVacio());
                                }
                                if (!miPilaD.esVacio()) {
                                    do {
                                        miPilaD.desapilar();
                                        System.out.println("\nPilaD tope: " + miPilaD.verTope());
                                    } while (!miPilaD.esVacio());
                                }
                                break;
                            case (4):
                                miPilaE.apilar(12);
                                miPilaD.apilar(12);
                                break;
                            case (5):
                                miColaE.encolar(miPilaE.verTope());
                                miColaD.encolar(miPilaD.verTope());
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case (2):
                    while (dentroDelMenu != 0) {
                        menuCola();
                        dentroDelMenu = new Scanner(System.in).nextInt();
                        switch (dentroDelMenu) {
                            case (1):
                                System.out.println("\nCabecera ColaE: " + miColaE.desencolar());
                                System.out.println("Cabecera ColaD: " + miColaD.desencolar());
                                break;
                            case (2):
                                miColaE.encolar(12);
                                miColaD.encolar(12);
                                break;
                            case (3):
                                System.out.println();
                                while (!miColaE.esVacia()) {
                                    System.out.println("Cabecera ColaE: " + miColaE.desencolar());
                                }
                                while (!miColaD.esVacia()) {
                                    System.out.println("Cabecera ColaD: " + miColaD.desencolar());
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case (3):
                    while (dentroDelMenu != 0) {
                        menuLista();
                        dentroDelMenu = new Scanner(System.in).nextInt();
                        switch (dentroDelMenu) {
                            case (1):
                                System.out.println("\nActual ListaE: " + miListaE.getActual());
                                System.out.println("Actual ListaD: " + miListaD.getActual());
                                break;
                            case (2):
                                miListaE.anterior();
                                System.out.println("\nActual ListaE: " + miListaE.getActual());
                                miListaD.anterior();
                                System.out.println("Actual ListaD: " + miListaD.getActual());
                                break;
                            case (3):
                                miListaE.eliminar();
                                System.out.println("\nActual ListaE: " + miListaE.getActual());
                                miListaD.eliminar();
                                System.out.println("Actual ListaD: " + miListaD.getActual());
                                break;
                            case (4):
                                miListaE.irPrimero();
                                miListaE.eliminar();
                                System.out.println("\nActual ListaE: " + miListaE.getActual());
                                miListaD.irPrimero();
                                miListaD.eliminar();
                                System.out.println("Actual ListaD: " + miListaD.getActual());
                            default:
                                break;
                        }
                    }
            }
        }
    }

    private static void menu1() {
        System.out.println("Menu: ");
        System.out.println("\t1. Testear las pilas.");
        System.out.println("\t2. Testear las colas.");
        System.out.println("\t3. Testear las listas.");
        System.out.println("\t4. Salir.");
    }

    private static void menuPila() {
        System.out.println("\nTestear las pilas (cero para salir): ");
        System.out.println("\t1. Ver el actual en la PilaD y en la PilaE.");
        System.out.println("\t2. Desapilar en la PilaD y en la PilaE.");
        System.out.println("\t3. Ver el actual y desapilar hasta vaciar ambas pilas.");
        System.out.println("\t4. Apilar el numero 12 en cada pila.");
        System.out.println("\t5. Ver el tope e cualquier pila y encolarlo en las colas.");
    }

    private static void menuCola() {
        System.out.println("\nTestear las colas (cero para salir): ");
        System.out.println("\t1. Ver la cabecera de cada cola y desencolarla.");
        System.out.println("\t2. Encolar el numero 12 en cada cola.");
        System.out.println("\t3. Desencolar las colas y mostrar cada elemento hasta vaciar las colas.");
    }

    private static void menuLista() {
        System.out.println("\nTestear las pilas (cero para salir): ");
        System.out.println("\t1. Ver el actual en cada lista.");
        System.out.println("\t2. Ir atras una posicion en cada lista y mostrar el actual.");
        System.out.println("\t3. Eliminar el actual y mostrar el actual en cada lista.");
        System.out.println("\t4. Ir al primer elemento de la lista, eliminarlo y mostrar el actual.");
    }
}
