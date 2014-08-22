package algoritmos.tpa4;

import algoritmos.estructuras.cola.ColaE;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 15/04/12
 * Time: 19:17
 * To change this template use File | Settings | File Templates.
 */
public class Ventanilla {
    ColaE pasajeros;
    double recaudacion;
    int tiempoOcioso;
    int pasajerosAtendidos;
    int tiempoDeEsperaPasajeros;

    public Ventanilla() {
        pasajeros = new ColaE();
        recaudacion = 0;
        tiempoOcioso = 0;
        pasajerosAtendidos = 0;
        tiempoDeEsperaPasajeros = 0;
    }

    public void atender(int hora) {
        if (pasajeros.esVacia()) {
            tiempoOcioso += 10;
        } else {
            int probabilidad = (int) (Math.random() * 101);
            if (probabilidad >= 30) {
                tiempoOcioso += 10;
            } else if (probabilidad < 30) {
                Pasajero pasajero = (Pasajero) pasajeros.desencolar();
                recaudacion += 0.7;
                pasajerosAtendidos++;
                tiempoDeEsperaPasajeros += hora - pasajero.getHoraDeIngreso();
            }
        }
    }

    public void atenderTodos() {
        int ultimosTreinta = 57600;
        while (!pasajeros.esVacia()) {
            Pasajero pasajero = (Pasajero) pasajeros.desencolar();
            recaudacion += 0.70;
            pasajerosAtendidos++;
            tiempoDeEsperaPasajeros += ultimosTreinta - pasajero.getHoraDeIngreso();
        }
    }

    public void imprimirVentanilla(int numeroDeVentanilla) {
        System.out.println("\nVentanilla n°" + numeroDeVentanilla);
        System.out.println("\nTiempo de espera: " + tiempoDeEsperaPasajeros);
        System.out.println("Pasajeros atendidos: " + pasajerosAtendidos);
        System.out.println("Tiempo de espera por pasajero: " + (tiempoDeEsperaPasajeros / pasajerosAtendidos));
        System.out.println("Recaudación: " + recaudacion);
        System.out.println("Tiempo ocioso de la ventanilla: " + tiempoOcioso);
    }
}