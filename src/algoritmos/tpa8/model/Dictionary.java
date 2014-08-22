package algoritmos.tpa8.model;

import algoritmos.estructuras.lista.ListaD;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * User: Martin Gutierrez
 * Date: 30/05/12
 * Time: 11:55
 */
public class Dictionary {
    private final String diccionario = "src/algoritmos/tpa8/model/EnglishDictionary.txt";
    private TablaHashDA palabras;
    private final int cantPalabras = 3000000;

    public Dictionary() {
        palabras = new TablaHashDA(cantPalabras);
    }

    public void inicializar() {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader(diccionario);
            br = new BufferedReader(fr);
            String s = br.readLine();
            while (s != null) {
                palabras.insertar(Soundex.soundex(s).hashCode(), s);
                s = br.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String buscarPalabrasPorString(String palabra) {
        String s = palabra + ": ";
        ListaD palabras = buscarPalabras(palabra);
        if (palabras != null) {
            palabras.irPrimero();
            s += palabras.getActual();
            for (int i = 0; i < palabras.longitud() - 1; i++) {
                palabras.siguiente();
                s += ", " + palabras.getActual();

            }
        } else {
            s += "No hay parecidos para la palabra";
        }
        return s;
    }

    public String[] buscarPalabrasPor(String palabra) {
        String[] palabras1 = null;
        ListaD palabras = buscarPalabras(palabra);
        if (palabras != null) {
            palabras1 = new String[palabras.longitud()];
            palabras.irPrimero();
            palabras1[0] = (String) (palabras.getActual());
            for (int i = 1; i < palabras.longitud() - 1; i++) {
                palabras.siguiente();
                palabras1[i] = (String) (palabras.getActual());

            }
        }
        return palabras1;
    }

    public boolean existeLaPalabra(String palabra){
        ListaD palabras = buscarPalabras(palabra);
        if (palabras != null) {
            palabras.irPrimero();
            for (int i = 1; i < palabras.longitud() - 1; i++) {
                if(((String) palabras.getActual()).equals(palabra)){
                    return true;
                }
                palabras.siguiente();

            }
        }
        return false;
    }

    private ListaD buscarPalabras(String palabra) {
        return palabras.buscarPalabras(Soundex.soundex(palabra).hashCode());
    }

}