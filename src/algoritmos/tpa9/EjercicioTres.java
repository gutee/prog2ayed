package algoritmos.tpa9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * User: Martin Gutierrez
 * Date: 09/05/12
 * Time: 23:28
 */
public class EjercicioTres {
    public static void main(String[] args) {
        System.out.println("Ingrese el nombre del archivo a transformar: ");
        String nombre = new Scanner(System.in).next();
        System.out.println("Ingrese nuevo nombre del archivo: ");
        String nuevoNombre = new Scanner(System.in).next();
        String texto = levantarArchivo(nombre);
        System.out.println("Ingrese 1 para pasar todo a mayus y 2 para pasar todo a minus: ");
        int decision = new Scanner(System.in).nextInt();
        switch (decision) {
            case (1):
                texto = texto.toUpperCase();
                grabarConNuevoNombre(nuevoNombre, texto);
                break;
            case (2):
                texto = texto.toLowerCase();
                grabarConNuevoNombre(nuevoNombre, texto);
                break;
            default:
                System.out.println("La opción no es válida.");
                break;
        }

    }

    private static String levantarArchivo(String nombre) {
        FileInputStream fis;
        String texto = "";
        try {
            fis = new FileInputStream(nombre);
            int a = fis.read();
            while (a != -1) {
                texto += (char) a;
                a = fis.read();
            }
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return texto;
    }

    private static void grabarConNuevoNombre(String nuevoNombre, String texto) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(nuevoNombre);
            byte a[] = new byte[texto.length()];
            for (int i = 0; i < texto.length(); i++) {
                a[i] = (byte) (texto.charAt(i));
            }
            fos.write(a);
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
