package algoritmos.estructuras.arbolBinario;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 01/04/12
 * Time: 13:20
 * To change this template use File | Settings | File Templates.
 */
public class ArBinIntMain {
    public static void main(String[] args) {
        Aplicaciones aplicaciones = new Aplicaciones();
        ArBinD arbolIzq1 = new ArBinD(1);
        ArBinD arbolDer1 = new ArBinD(3);
        ArBinD arbolIzq2 = new ArBinD(5);
        ArBinD arbolDer2 = new ArBinD(7);
        ArBinD arbolIzq3 = new ArBinD(1, arbolIzq1, arbolDer1);
        ArBinD arbolDer3 = new ArBinD(3, arbolIzq2, arbolDer2);
        ArBinD arbol = new ArBinD(5, arbolIzq3, arbolDer3);

        System.out.println("El peso del arbol es: " + aplicaciones.peso(arbol) + "\n");
        System.out.println("El número de hojas es: " + aplicaciones.cantHojas(arbol) + "\n");
        System.out.println("Ingrese el objeto a buscar: ");
        int elemento = new Scanner(System.in).nextInt();
        System.out.println("\nEl elemento aparece " + aplicaciones.elemento(arbol, elemento) + " veces\n");
        System.out.println("Ingrese el nivel a analizar: ");
        int nivel = new Scanner(System.in).nextInt();
        System.out.println("\nEl arbol tiene " + aplicaciones.elementosNivel(arbol, nivel) + " elementos en el nivel\n");
        System.out.println("La altura del arbol es: " + aplicaciones.altura(arbol) + "\n");
        System.out.println("Arbol en preorden: ");
        aplicaciones.imprimirIntPreOrden(arbol);
        System.out.println("\nArbol en inorden: ");
        aplicaciones.imprimirIntInOrden(arbol);
        System.out.println("\nArbol en postorden: ");
        aplicaciones.imprimirIntPostOrden(arbol);
        System.out.println("\nArbol por niveles: ");
        aplicaciones.imprimirIntPorNiveles(arbol);

        aplicaciones.guardarArbol(arbol, "Arbol Enteros");
        System.out.println("Arbol guardado exitosamente en disco!");
    }
}
