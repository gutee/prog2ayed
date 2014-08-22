package algoritmos.tpa4;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 15/04/12
 * Time: 20:22
 * To change this template use File | Settings | File Templates.
 */
public class MetroviasMain {
    private static final int TIEMPO_TOTAL = 57570;

    public static void main(String[] args) {
        System.out.println("Ingrese el número de ventanillas (entre 3 y 10): ");
        Metrovias metrovias = new Metrovias(new Scanner(System.in).nextInt());
        for (int i = 0; i < TIEMPO_TOTAL; i += 10) {
            for (int j = 0; j < 5; j++) {
                metrovias.agregarPasajeroAVentanilla(i);
            }
            metrovias.pasarTiempo(i);
        }
        metrovias.cierre();
        metrovias.imprimirTodo();
    }
}