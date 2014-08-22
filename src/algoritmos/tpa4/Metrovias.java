package algoritmos.tpa4;

import algoritmos.estructuras.lista.ListaD;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 15/04/12
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class Metrovias {
    ListaD ventanillas;
    int numeroDeVentanillas;

    Metrovias(int numeroDeVentanillas) {
        ventanillas = new ListaD();
        this.numeroDeVentanillas = numeroDeVentanillas;
        for (int i = 0; i < numeroDeVentanillas; i++) {
            ventanillas.insertarD(new Ventanilla());
        }
    }

    public void agregarPasajeroAVentanilla(int hora) {
        int eleccion = (int) (Math.random() * (numeroDeVentanillas));
        ventanillas.irA(eleccion);
        ((Ventanilla) ventanillas.getActual()).pasajeros.encolar(new Pasajero(hora));
    }

    public void pasarTiempo(int hora) {
        for (int i = 0; i < numeroDeVentanillas; i++) {
            ventanillas.irA(i);
            ((Ventanilla) ventanillas.getActual()).atender(hora);
        }
    }

    public void cierre() {
        for (int i = 0; i < numeroDeVentanillas; i++) {
            ventanillas.irA(i);
            ((Ventanilla) ventanillas.getActual()).atenderTodos();
        }
    }

    public void imprimirTodo() {
        for (int i = 0; i < numeroDeVentanillas; i++) {
            ventanillas.irA(i);
            ((Ventanilla) ventanillas.getActual()).imprimirVentanilla(i + 1);
        }
    }
}