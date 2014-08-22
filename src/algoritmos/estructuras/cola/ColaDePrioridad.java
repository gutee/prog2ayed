package algoritmos.estructuras.cola;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 28/03/12
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
public class ColaDePrioridad {
    int cantDePrioridades;
    ColaE[] colaDePrioridad;

    public ColaDePrioridad(int cantDePrioridades) {
        this.cantDePrioridades = cantDePrioridades;
        colaDePrioridad = new ColaE[cantDePrioridades];
        for (int i = 0; i < cantDePrioridades; i++) {
            colaDePrioridad[i] = new ColaE();
        }
    }

    public void encolar(Object o, int prioridad) {
        colaDePrioridad[prioridad - 1].encolar(o);
    }

    public Object desencolar() {
        for (int i = 0; i < cantDePrioridades; i++) {
            if (!colaDePrioridad[i].esVacia()) {
                return colaDePrioridad[i].desencolar();
            }
        }
        return null;
    }

    public boolean esVacia() {
        boolean esVacia = true;
        for (int i = 0; i < cantDePrioridades; i++) {
            if (!colaDePrioridad[i].esVacia()) {
                esVacia = false;
            }
        }
        return esVacia;
    }

    public void vaciar() {
        for (int i = 0; i < cantDePrioridades; i++) {
            colaDePrioridad[i].vaciar();
        }
    }
}
