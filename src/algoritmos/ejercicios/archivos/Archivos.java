package algoritmos.ejercicios.archivos;

import java.io.*;

/**
 * User: Martin Gutierrez
 * Date: 09/05/12
 * Time: 10:03
 */
public class Archivos {
    public void ejemplo1() {
        byte a[] = new byte[100];
        FileOutputStream fos1, fos2, fos3;
        try {
            fos1 = new FileOutputStream("MiTexto1");
            fos2 = new FileOutputStream("MiTexto2");
            fos3 = new FileOutputStream("MiTexto3");
            String str = "prueba de los archivos";
            for (int i = 0; i < str.length(); i++) {
                a[i] = (byte) str.charAt(i);
            }
            fos1.write(a);
            fos2.write(a, 4, 6);
            for (int i = 0; i < 22; i++) {
                fos3.write(a[i]);
            }
            fos1.close();
            fos2.close();
            fos3.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void ejemplo2() {
        FileInputStream fis;
        try {
            fis = new FileInputStream("MiTexto3");
            int a = fis.read();                         //lee el primer dato
            while (a != -1) {                    //mientras no sea fin de archivo
                System.out.print((char) a);         //imprime un dato
                a = fis.read();                //lee el proximo dato
            }
            System.out.println();
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void ejemplo3() {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("ArBin.java");
            br = new BufferedReader(fr);
            String s = br.readLine();               //guarda la primera linea
            while (s != null) {                      //cuando el archivo termina guarda una cadena nula
                System.out.println(s);            //imprime linea
                s = br.readLine();               //lee la proxima linea
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Archivos archivos = new Archivos();
        archivos.ejemplo1();
        archivos.ejemplo2();
        archivos.ejemplo3();
    }
}