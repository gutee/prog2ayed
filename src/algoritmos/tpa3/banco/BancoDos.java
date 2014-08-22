package algoritmos.tpa3.banco;

import algoritmos.estructuras.cola.ColaE;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 29/03/12
 * Time: 19:21
 * To change this template use File | Settings | File Templates.
 */
public class BancoDos {
    private int clientesUno;
    private int clientesDos;
    private int clientesTres;
    private ColaE colaUno;
    private ColaE colaDos;
    private ColaE colaTres;
    private Cajero cajeroUno;
    private Cajero cajeroDos;
    private Cajero cajeroTres;
    private int tiempoBanco;
    private int clientesIngresados;

    BancoDos() {
        cajeroUno = new Cajero(30, 90);
        cajeroDos = new Cajero(30, 120);
        cajeroTres = new Cajero(30, 150);
        colaUno = new ColaE();
        colaDos = new ColaE();
        colaTres = new ColaE();
        clientesIngresados = 0;
        tiempoBanco = 18000;
        clientesUno = 5;
        clientesDos = 5;
        clientesTres = 5;
        for (int i = 0; i < 5; i++) {
            colaUno.encolar("Cliente");
            colaDos.encolar("Cliente");
            colaTres.encolar("Cliente");
        }
    }

    public void calcularTodo() {
        for (int i = 0; i < 18000; i += 30) {
            if (i >= clientesIngresados * 90) {
                colaMasCorta().encolar("Cliente");
                clientesIngresados++;
            }
            atender();
            calcularTiempoMedio();
        }
        while (!colaUno.esVacia() && !colaDos.esVacia() && !colaTres.esVacia()) {
            tiempoBanco += 30;
            atender();
            calcularTiempoMedio();
        }
    }

    private void atender() {
        if (!colaUno.esVacia() && !cajeroUno.estaOcupado()) {
            cajeroUno.atenderCliente();
            colaUno.desencolar();
        }
        if (!colaDos.esVacia() && !cajeroDos.estaOcupado()) {
            cajeroDos.atenderCliente();
            colaDos.desencolar();
        }
        if (!colaTres.esVacia() && !cajeroTres.estaOcupado()) {
            cajeroTres.atenderCliente();
            colaTres.desencolar();
        }
    }

    private void calcularTiempoMedio() {
        cajeroUno.modificarOcupado(-30);
        cajeroDos.modificarOcupado(-30);
        cajeroTres.modificarOcupado(-30);
    }

    private ColaE colaMasCorta() {
        if ((clientesUno < clientesDos) && (clientesUno < clientesTres)) {
            return colaUno;
        } else if ((clientesDos < clientesUno) && (clientesDos < clientesTres)) {
            return colaDos;
        } else if ((clientesTres < clientesUno) && (clientesTres < clientesDos)) {
            return colaTres;
        } else if ((clientesUno == clientesDos) && (clientesUno == clientesTres)) {
            int eleccion = (int) (Math.random() * 3) + 1;
            switch (eleccion) {
                case (1):
                    return colaUno;
                case (2):
                    return colaDos;
                case (3):
                    return colaTres;
            }
        } else if (clientesUno == clientesDos) {
            int eleccion = (int) (Math.random() * 2) + 1;
            switch (eleccion) {
                case (1):
                    return colaUno;
                case (2):
                    return colaDos;
            }
        }
        if (clientesDos == clientesTres) {
            int eleccion = (int) (Math.random() * 2) + 1;
            switch (eleccion) {
                case (1):
                    return colaDos;
                case (2):
                    return colaTres;
            }
        } else if (clientesUno == clientesTres) {
            int eleccion = (int) (Math.random() * 2) + 1;
            switch (eleccion) {
                case (1):
                    return colaUno;
                case (2):
                    return colaTres;
            }
        }
        return colaUno;
    }

    public Cajero getCajeroUno() {
        return cajeroUno;
    }

    public Cajero getCajeroDos() {
        return cajeroDos;
    }

    public Cajero getCajeroTres() {
        return cajeroTres;
    }

    public int getTiempoBanco() {
        return tiempoBanco;
    }
}