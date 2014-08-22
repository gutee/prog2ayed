package algoritmos.tpa9;

import java.io.*;
import java.util.Scanner;

/**
 * User: Martin Gutierrez
 * Date: 11/05/12
 * Time: 11:29
 */
public class EjercicioCinco {
    public static void main(String[] args) {
        System.out.println("Ingrese el nombre del archivo a dividir: ");
        String nombre = new Scanner(System.in).next();
        System.out.println("Ingrese el número de la población a dividir: ");
        long habitantes = new Scanner(System.in).nextLong();
        System.out.println("Ingrese PBI para grabar solo el pais y el PBI, " +
                "POB para grabar pais y población, y cualquier otra cosa para grabar todo");
        String decision = new Scanner(System.in).next();
        division(nombre, habitantes, decision);
    }

    private static void division(String nombre, long habitantes, String decision) {
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
                int r = i;
                if (pob < habitantes) {
                    divisionDecision(decision, bw1, s, r);
                } else {
                    divisionDecision(decision, bw2, s, r);
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

    private static void divisionDecision(String decision, BufferedWriter bw, String s, int i) throws IOException {
        if (decision.equalsIgnoreCase("PBI")) {
            i++;
            String pbi = "";
            for (int j = i; j < s.length(); j++) {
                pbi += s.charAt(i);
                i++;
            }
            i = 0;
            String pais = "";
            while (s.charAt(i) != ';') {
                pais += s.charAt(i);
                i++;
            }
            bw.write(pais + ";" + pbi + "\n");
        } else if (decision.equalsIgnoreCase("POB")) {
            String cortada = s.substring(0, i);
            bw.write(cortada + "\n");
        } else {
            bw.write(s + "\n");
        }
    }
}
