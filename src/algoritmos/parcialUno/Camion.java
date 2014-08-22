package algoritmos.parcialUno;

import algoritmos.estructuras.cola.ColaE;

/**
 * User: martingutierrez
 * Date: 08/05/12
 * Time: 11:17
 */

public class Camion implements Comparable {
    private ColaE urnas;
    private int numeroDeUrnas;
    private int colegio;
    private int mesa;
    private int tiempoDeAtencion;

    public Camion() {
        numeroDeUrnas = (int) (Math.random() * 500);
        urnas = new ColaE();
        colegio = ((int) (Math.random() * 9000)) + 1000;
        mesa = (int) (Math.random() * 100);
        for (int i = 0; i < numeroDeUrnas; i++) {
            urnas.encolar(new Urna(colegio, mesa));
        }
        tiempoDeAtencion = 0;
    }

    public void vaciarCamion() {
        urnas.vaciar();
    }

    public void setTiempoDeAtencion(int tiempoDeAtencion) {
        this.tiempoDeAtencion = tiempoDeAtencion;
    }

    public int getTiempoDeAtencion() {
        return tiempoDeAtencion;
    }

    public int compareTo(Object o) {
        if (colegio != ((Camion) o).getColegio()) {
            return colegio - ((Camion) o).getColegio();
        }
        return 0;
    }

    public int getColegio() {
        return colegio;
    }

    public int getNumeroDeUrnas() {
        return numeroDeUrnas;
    }
}