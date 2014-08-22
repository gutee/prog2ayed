package algoritmos.ejercicios.hemeroteca;

import algoritmos.estructuras.pila.PilaE;

/**
 * Created by IntelliJ IDEA.
 * User: Martin Gutierrez
 * Date: 17/04/12
 * Time: 12:01
 */
public class Publicacion {
    private PilaE ejemplares;
    private String nombre;

    Publicacion() {
        ejemplares = new PilaE();
        nombre = nuevoNombre();
        for (int i = 0; i < ((int) (Math.random() * 15)) + 1; i++) {
            ejemplares.apilar(new Ejemplar(nombre));
        }
    }

    public static String nuevoNombre() {
        char[] elementos = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'};
        char[] conjunto = new char[4];
        String pass;
        for (int i = 0; i < 4; i++) {
            int el = (int) (Math.random() * 27);
            conjunto[i] = elementos[el];
        }
        pass = new String(conjunto);
        return pass;
    }

    public Ejemplar darEjemplar() {
        Ejemplar ejemplar = (Ejemplar) ejemplares.verTope();
        ejemplares.desapilar();
        return ejemplar;
    }

    public String getNombre() {
        return nombre;
    }

    public PilaE getEjemplares() {
        return ejemplares;
    }

    public boolean algunEjemplarRetirado() {
        return ((Ejemplar) ejemplares.verTope()).getTiempoUsado() != 0;
    }
}