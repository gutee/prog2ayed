package algoritmos.estructuras.arbolBinario;

import java.io.Serializable;

/**
 * User: Martin Gutierrez
 * Date: 28/03/12
 * Time: 10:50
 */
public class ArBinD implements ArBin, Serializable {
    private NodoDoble raiz;

    public ArBinD() {
        raiz = null;
    }

    public ArBinD(Object e) {
        raiz = new NodoDoble(e);
    }

    public ArBinD(Object e, ArBinD ai, ArBinD ad) {
        raiz = new NodoDoble(e);
        raiz.izq = ai.raiz;
        raiz.der = ad.raiz;
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    public Object getRaiz() {
        return raiz.dato;
    }

    public ArBinD hijoIzq() {
        ArBinD t = new ArBinD();
        t.raiz = this.raiz.izq;
        return t;
    }

    public ArBinD hijoDer() {
        ArBinD t = new ArBinD();
        t.raiz = this.raiz.der;
        return t;
    }
}
