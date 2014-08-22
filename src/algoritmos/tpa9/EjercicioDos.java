package algoritmos.tpa9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * User: Martin Gutierrez
 * Date: 09/05/12
 * Time: 23:21
 */
public class EjercicioDos {
    public static void main(String[] args) {
        System.out.println("Ingrese el nombre del archivo a analizar: ");
        String nombre = new Scanner(System.in).next();
        System.out.println("Ingrese el caracter a buscar: ");
        char buscar = 0;
        try {
            buscar = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("El caracter aparece " + buscadorCaracter(nombre, buscar) + " veces.");
    }

    private static int buscadorCaracter(String nombre, char buscar) {
        FileInputStream fis;
        int contador = 0;
        try {
            fis = new FileInputStream(nombre);
            int a = fis.read();
            while (a != -1) {
                if ((char) a == buscar) {
                    contador++;
                }
                a = fis.read();
            }
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return contador;
    }
}
