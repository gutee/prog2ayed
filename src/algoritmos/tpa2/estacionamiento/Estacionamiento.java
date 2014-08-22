package algoritmos.tpa2.estacionamiento;

import algoritmos.estructuras.nodo.PilaD;
import algoritmos.estructuras.pila.Pila;
import algoritmos.estructuras.pila.PilaE;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 13/03/12
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class Estacionamiento {
    Pila colaDeEstacionemiento;
    int recaudacion;

    public Estacionamiento() {
        colaDeEstacionemiento = new PilaE();
        recaudacion = 0;
    }

    public boolean agregarAuto(Auto auto) {
        if (contarAutos() < 50) {
            colaDeEstacionemiento.apilar(auto);
            return true;
        }
        return false;
    }

    public Auto sacarUltimoAuto() {
        Auto auto = (Auto) colaDeEstacionemiento.verTope();
        colaDeEstacionemiento.desapilar();
        recaudacion += 5;
        return auto;
    }

    public Auto sacarAutoSeleccionado(Auto auto) {
        Pila vereda = new PilaD();
        while (!colaDeEstacionemiento.esVacio()) {
            vereda.apilar(colaDeEstacionemiento.verTope());
            colaDeEstacionemiento.desapilar();
            if (((Auto) vereda.verTope()).getMatricula().equals(auto.getMatricula())) {
                vereda.desapilar();
                recaudacion += 5;
                return auto;
            }
        }
        while (!vereda.esVacio()) {
            colaDeEstacionemiento.apilar(vereda.verTope());
            vereda.desapilar();
        }
        return null;
    }

    private int contarAutos() {
        int conteo = 0;
        Pila aux = new PilaD();
        while (!colaDeEstacionemiento.esVacio()) {
            aux.apilar(colaDeEstacionemiento.verTope());
            colaDeEstacionemiento.desapilar();
            conteo++;
        }
        while (!aux.esVacio()) {
            colaDeEstacionemiento.apilar(aux.verTope());
            aux.desapilar();
        }
        return conteo;
    }

    public int getRecaudacion() {
        return recaudacion;
    }
}