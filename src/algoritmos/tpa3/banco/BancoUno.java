package algoritmos.tpa3.banco;

import algoritmos.estructuras.cola.ColaE;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 29/03/12
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class BancoUno {
    private Cajero cajeroUno;
    private Cajero cajeroDos;
    private Cajero cajeroTres;
    private ColaE clientes;
    private int tiempoBanco;
    private int clientesIngresados;

    BancoUno() {
        cajeroUno = new Cajero(30, 90);
        cajeroDos = new Cajero(30, 120);
        cajeroTres = new Cajero(30, 150);
        tiempoBanco = 18000;
        clientesIngresados = 0;
        clientes = new ColaE();
        for (int i = 0; i < 15; i++) {
            clientes.encolar("Cliente");
        }
    }

    public void calcularTodo() {
        for (int i = 0; i < 18000; i += 30) {
            if (i >= clientesIngresados * 90) {
                clientes.encolar("Cliente");
                clientesIngresados++;
            }
            atender();
            calcularTiempoMedio();
        }

        while (!clientes.esVacia()) {
            tiempoBanco += 30;
            atender();
            calcularTiempoMedio();
        }

    }

    private void calcularTiempoMedio() {
        cajeroUno.modificarOcupado(-30);
        cajeroDos.modificarOcupado(-30);
        cajeroTres.modificarOcupado(-30);
    }

    private void atender() {
        while (!clientes.esVacia()) {
            if (!cajeroUno.estaOcupado() && !cajeroDos.estaOcupado() && !cajeroTres.estaOcupado()) {
                int resultado = (int) (Math.random() * 3) + 1;
                switch (resultado) {
                    case (1):
                        cajeroUno.atenderCliente();
                        clientes.desencolar();
                        break;
                    case (2):
                        cajeroDos.atenderCliente();
                        clientes.desencolar();
                        break;
                    case (3):
                        cajeroTres.atenderCliente();
                        clientes.desencolar();
                        break;
                }
            } else if (!cajeroUno.estaOcupado() && !cajeroDos.estaOcupado()) {
                int resultado = (int) (Math.random() * 2) + 1;
                switch (resultado) {
                    case (1):
                        cajeroUno.atenderCliente();
                        clientes.desencolar();
                        break;
                    case (2):
                        cajeroDos.atenderCliente();
                        clientes.desencolar();
                        break;
                }
            } else if (!cajeroUno.estaOcupado() && !cajeroTres.estaOcupado()) {
                int resultado = (int) (Math.random() * 2) + 1;
                switch (resultado) {
                    case (1):
                        cajeroUno.atenderCliente();
                        clientes.desencolar();
                        break;
                    case (2):
                        cajeroTres.atenderCliente();
                        clientes.desencolar();
                        break;
                }
            } else if (!cajeroDos.estaOcupado() && !cajeroTres.estaOcupado()) {
                int resultado = (int) (Math.random() * 2) + 1;
                switch (resultado) {
                    case (1):
                        cajeroDos.atenderCliente();
                        clientes.desencolar();
                        break;
                    case (2):
                        cajeroTres.atenderCliente();
                        clientes.desencolar();
                        break;
                }
            } else if (!cajeroUno.estaOcupado()) {
                cajeroUno.atenderCliente();
                clientes.desencolar();
            } else if (!cajeroDos.estaOcupado()) {
                cajeroDos.atenderCliente();
                clientes.desencolar();
            } else if (!cajeroTres.estaOcupado()) {
                cajeroTres.atenderCliente();
                clientes.desencolar();
            }
        }
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
