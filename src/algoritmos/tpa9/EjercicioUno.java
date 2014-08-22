package algoritmos.tpa9;

import java.io.*;
import java.util.Scanner;

/**
 * User: Martin Gutierrez
 * Date: 09/05/12
 * Time: 22:56
 */
public class EjercicioUno {
    public static void main(String[] args) {
        System.out.println("Ingrese el nombre del archivo a analizar: ");
        String nombre = new Scanner(System.in).next();
        System.out.println("Ingrese c para contar caracteres o | para contar lineas");
        char decision = 0;
        try {
            decision = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (decision) {
            case ('c'):
                System.out.println("El archivo tiene " + contarCaracteres(nombre) + " caracteres.");
                break;
            case ('|'):
                System.out.println("El archivo tiene " + contarLineas(nombre) + " lineas.");
                break;
            default:
                System.out.println("Ingrese una opción válida.");
        }

    }

    private static int contarCaracteres(String nombre) {
        FileInputStream fis;
        int contador = 0;
        try {
            fis = new FileInputStream(nombre);
            int a = fis.read();
            while (a != -1) {
                contador++;
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

    private static int contarLineas(String nombre) {
        FileReader fr;
        BufferedReader br;
        int contador = 0;
        try {
            fr = new FileReader(nombre);
            br = new BufferedReader(fr);
            String s = br.readLine();
            while (s != null) {
                contador++;
                s = br.readLine();
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return contador;
    }
}
