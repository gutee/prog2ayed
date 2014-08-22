package algoritmos.tpa9;

import sun.security.util.BigInt;

import java.io.*;
import java.util.Scanner;

/**
 * User: Martin Gutierrez
 * Date: 10/05/12
 * Time: 00:02
 */
public class EjercicioCuatro {

    public static void main(String[] args) {
        System.out.println("Ingrese el nombre del archivo a dividir: ");
        String nombre = new Scanner(System.in).next();
        division(nombre);
    }

    private static void division(String nombre) {
        FileReader fr;
        BufferedReader br;
        FileWriter fw1, fw2;
        BufferedWriter bw1, bw2;
        try {
            fr = new FileReader(nombre);
            br = new BufferedReader(fr);
            fw1 = new FileWriter("PoblacionMenor");
            fw2 = new FileWriter("PoblacionMayor");
            bw1 = new BufferedWriter(fw1);
            bw2 = new BufferedWriter(fw2);
            String s = br.readLine();
            while (s != null) {
                String poblacion = "";
                int i = 0;
                while (s.charAt(i) != ';') {
                    i++;
                }
                i++;
                while (s.charAt(i) != ';') {
                    poblacion += s.charAt(i);
                    i++;
                }
                long pob = Long.parseLong(poblacion);
                if (pob < 30000000) {
                    bw1.write(s);
                } else {
                    bw2.write(s);
                }
                s = br.readLine();
            }
            bw1.flush();
            bw2.flush();
            fw1.close();
            fw2.close();
            fr.close();
            bw1.close();
            bw2.close();
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
