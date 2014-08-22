package algoritmos.estructuras.cola;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 20/03/12
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
public class ColaE implements Cola {
    private int frente;
    private int fondo;
    private int tamaño;
    private Object[] datos;
    private int cantidad;

    public ColaE() {
        cantidad = 0;
        frente = 0;
        fondo = 0;
        tamaño = 10;
        datos = new Object[tamaño];
    }

    public void encolar(Object o) {
        if (tamaño == cantidad) {
            tamaño = tamaño * 2;
            Object[] aux = new Object[tamaño];
            for (int i = 0; i < datos.length; i++) {
                if (frente >= (tamaño / 2)) {
                    frente = 0;
                }
                aux[i] = datos[frente++];
            }
            frente = 0;
            fondo = datos.length;
            datos = aux;
        } else if (fondo == tamaño) {
            fondo = 0;
        }
        datos[fondo] = o;
        fondo++;
        cantidad++;
    }

    public Object desencolar() {
        if (frente >= tamaño) {
            frente = 0;
        }
        cantidad--;
        return datos[frente++];
    }

    public boolean esVacia() {
        return cantidad == 0;
    }

    public void vaciar() {
        tamaño = 10;
        datos = new Object[tamaño];
        fondo = 0;
        cantidad = 0;
        frente = 0;
    }
}