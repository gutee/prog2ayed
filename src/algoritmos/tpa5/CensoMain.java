package algoritmos.tpa5;

import java.io.*;
import java.util.Scanner;

/**
 * User: Martin Gutierrez
 * Date: 09/05/12
 * Time: 20:13
 */
public class CensoMain {
    public static void main(String[] args) {
        int decision = 1;
        Censo censo = new Censo();
        while (decision != 0) {
            menu();
            decision = new Scanner(System.in).nextInt();
            switch (decision) {
                case (1):
                    System.out.println("Inserte la linea: ");
                    int linea = new Scanner(System.in).nextInt();
                    System.out.println("Inserte el interno: ");
                    int interno = new Scanner(System.in).nextInt();
                    System.out.println("Inserte la cantidad de asientos: ");
                    int asientos = new Scanner(System.in).nextInt();
                    System.out.println("Esta habilitado para discapacitados? (si/no)");
                    String disc = new Scanner(System.in).next();
                    boolean discapacitados = false;
                    if (disc.equalsIgnoreCase("si")) {
                        discapacitados = true;
                    } else if (disc.equalsIgnoreCase("no")) {
                        discapacitados = false;
                    }
                    censo.insertarColectivo(new Colectivoo(linea, interno, asientos, discapacitados));
                    break;
                case (2):
                    System.out.println("Inserte la linea a eliminar");
                    int linea2 = new Scanner(System.in).nextInt();
                    System.out.println("Inserte el interno a eliminar");
                    int interno2 = new Scanner(System.in).nextInt();
                    System.out.println("Inserte la cantidad de asientos: ");
                    int asientos2 = new Scanner(System.in).nextInt();
                    System.out.println("Esta habilitado para discapacitados? (si/no)");
                    String disc2 = new Scanner(System.in).next();
                    boolean discapacitados2 = false;
                    if (disc2.equalsIgnoreCase("si")) {
                        discapacitados2 = true;
                    } else if (disc2.equalsIgnoreCase("no")) {
                        discapacitados2 = false;
                    }
                    Colectivoo colectivoEliminar = new Colectivoo(linea2, interno2, asientos2, discapacitados2);
                    censo.eliminarColectivo(colectivoEliminar);
                    break;
                case (3):
                    censo.imprimirLista();
                    break;
                case (4):
                    System.out.println("Hay " + censo.cuantosDiscapacitados() + " colectivos para discapacitados.");
                    break;
                case (5):
                    System.out.println("Hay " + censo.cuantosConMas() + " colectivos con más de 27 asientos");
                    break;
                case (6):
                    guardarCenso(censo);
                    System.out.println("Archivo guardado!");
                    break;
                case (7):
                    censo = cargarCenso();
                    break;
                case (0):
                    break;
                default:
                    System.out.println("Ingrese una opción válida.");
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println("Menu: ");
        System.out.println("\t1. Agregar colectivos");
        System.out.println("\t2. Eliminar colectivos");
        System.out.println("\t3. Obtener un informe ordenado por número de línea y para una misma línea por número de interno.");
        System.out.println("\t4. Informar cuantos colectivos aptos para discapacitados hay por línea.");
        System.out.println("\t5. Informar cuantos colectivos con más de 27 asientos hay por línea.");
        System.out.println("\t6. Guardar la lista en un archivo.");
        System.out.println("\t7. Recuperar la lista de un archivo.");
        System.out.println("\t0. Salir.");
    }

    private static void guardarCenso(Censo a) {
        try {
            File file = new File("CensoColectivo.ser");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static Censo cargarCenso() {
        Censo censo = null;
        try {
            FileInputStream fis = new FileInputStream("CensoColectivo.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            censo = (Censo) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return censo;
    }
}