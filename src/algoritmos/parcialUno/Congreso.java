package algoritmos.parcialUno;

import algoritmos.estructuras.cola.ColaD;
import algoritmos.estructuras.listaOrdenada.ListaOrd;

/**
 * User: martingutierrez
 * Date: 08/05/12
 * Time: 11:17
 */
public class Congreso {
    private ListaOrd camionesAtendidos;
    private ColaD filaDeCamiones;
    private int tiempoDeEspera;
    private Camion camionAtendido;
    private int camionesIngresados;

    public Congreso() {
        camionesAtendidos = new ListaOrd();
        filaDeCamiones = new ColaD();
        tiempoDeEspera = 0;
        camionAtendido = null;
        camionesIngresados = 0;
    }

    public void atender(int horaDeIngreso) {
        if (horaDeIngreso == 0) {
            camionAtendido = new Camion();
            camionesIngresados++;
        } else {
            int camionNuevo = (int) (Math.random() * 100);
            if (camionNuevo < 60) {
                filaDeCamiones.encolar(new Camion());
                camionesIngresados++;
            }
        }
        if (!filaDeCamiones.esVacia()) {
            for (int i = 0; i < camionesIngresados; i++) {
                tiempoDeEspera += 20;
            }
        }
        if (camionAtendido != null && horaDeIngreso != 0) {
            camionAtendido.setTiempoDeAtencion(camionAtendido.getTiempoDeAtencion() + 20);
        }
        if (camionAtendido != null && camionAtendido.getTiempoDeAtencion() == 60 && !filaDeCamiones.esVacia()) {
            camionAtendido.vaciarCamion();
            camionesAtendidos.insertar(camionAtendido);
            camionAtendido = (Camion) filaDeCamiones.desencolar();
            camionesIngresados--;
        } else if (camionAtendido != null && camionAtendido.getTiempoDeAtencion() == 60 && filaDeCamiones.esVacia()) {
            camionAtendido.vaciarCamion();
            camionesAtendidos.insertar(camionAtendido);
            camionAtendido = null;
        } else if (camionAtendido == null && !filaDeCamiones.esVacia()) {
            camionAtendido = (Camion) filaDeCamiones.desencolar();
            camionesIngresados--;
        }
    }

    public int cantidadDeCamiones() {
        return camionesAtendidos.longitud();
    }

    public int tiempoMedioDeEspera() {
        if (camionesIngresados == 0) {
            return 0;
        }
        return tiempoDeEspera / camionesIngresados;
    }

    public ListaOrd getCamionesAtendidos() {
        return camionesAtendidos;
    }
}