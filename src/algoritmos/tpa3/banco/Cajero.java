package algoritmos.tpa3.banco;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 29/03/12
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public class Cajero {
    private int min;
    private int max;
    private int clientesAtendidos;
    private int ocupado;

    public Cajero(int min, int max) {
        ocupado = 0;
        this.min = min;
        this.max = max;
        clientesAtendidos = 0;
    }

    public void modificarOcupado(double a) {
        ocupado += a;
    }

    public void atenderCliente() {
        clientesAtendidos++;
        int b = (((int) (Math.random() * (max - min))) + min);
        modificarOcupado(b);
    }

    public boolean estaOcupado() {
        return ocupado > 0;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }
}