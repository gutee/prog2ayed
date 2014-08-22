package algoritmos.estructuras.arbolBinario;

import java.io.Serializable;

/**
 * User: Martin
 * Date: 04/04/12
 * Time: 10:19
 */
public class ArBinBus implements Serializable {
    private NodoDoble raiz;

    public ArBinBus() {
        raiz = null;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public Object getRaiz() {
        return raiz.dato;
    }

    public ArBinBus hijoIzq() {
        ArBinBus t = new ArBinBus();
        t.raiz = this.raiz.izq;
        return t;
    }

    public ArBinBus hijoDer() {
        ArBinBus t = new ArBinBus();
        t.raiz = this.raiz.der;
        return t;
    }

    public Object getMax() {
        if (esVacio()) {
            return null;
        } else if (!hijoDer().esVacio()) {
            return hijoDer().getMax();
        } else if (hijoDer().esVacio()) {
            return getRaiz();
        }
        return null;
    }

    public Object getMin() {
        if (esVacio()) {
            return null;
        } else if (!hijoIzq().esVacio()) {
            return hijoIzq().getMin();
        } else if (hijoIzq().esVacio()) {
            return getRaiz();
        }
        return null;
    }

    public boolean existe(Object o) {
        if (esVacio()) {
            return false;
        } else if (((Comparable) raiz.dato).compareTo(o) == 0) {
            return true;
        } else if (((Comparable) raiz.dato).compareTo(o) > 0) {
            return hijoIzq().existe(o);
        } else if (((Comparable) raiz.dato).compareTo(o) < 0) {
            return hijoDer().existe(o);
        }
        return false;
    }

    public Object recuperar(Object o) {
        if (esVacio()) {
            return null;
        } else if (((Comparable) raiz.dato).compareTo(o) == 0) {
            return raiz.dato;
        } else if (((Comparable) raiz.dato).compareTo(o) > 0) {
            return hijoIzq().recuperar(o);
        } else if (((Comparable) raiz.dato).compareTo(o) < 0) {
            return hijoDer().recuperar(o);
        }
        return null;
    }

    public void insertar(Object o) throws Exception {
        raiz = insertar(raiz, o);
    }

    private NodoDoble insertar(NodoDoble a, Object o) throws Exception {
        if (a == null) {
            a = new NodoDoble(o);
        } else if (((Comparable) a.dato).compareTo(o) > 0) {
            a.izq = insertar(a.izq, o);
        } else if (((Comparable) a.dato).compareTo(o) < 0) {
            a.der = insertar(a.der, o);
        } else if (((Comparable) a.dato).compareTo(o) == 0) {
            throw new Exception("El dato ya existe");
        }
        return a;
    }

    public void eliminar(Object o) {
        raiz = eliminar(raiz, o);
    }

    private NodoDoble eliminar(NodoDoble a, Object o) {
        if (((Comparable) a.dato).compareTo(o) > 0) {
            a.izq = eliminar(a.izq, o);
        } else if (((Comparable) a.dato).compareTo(o) < 0) {
            a.der = eliminar(a.der, o);
        } else if (a.izq != null && a.der != null) {
            a.dato = hijoDer().getMin();
            a.der = eliminarMin(a.der);
        } else if (a.izq != null)
            a = a.izq;
        else
            a = a.der;
        return a;
    }

    private NodoDoble eliminarMin(NodoDoble a) {
        if (a.izq != null)
            a.izq = eliminarMin(a.izq);
        else
            a = a.der;
        return a;
    }

    public void imprimirInOrden() {
        if (!esVacio()) {
            hijoIzq().imprimirInOrden();
            System.out.println(getRaiz());
            hijoDer().imprimirInOrden();
        }
    }

    public String inOrdenString() {
        String s = "";
        if (!esVacio()) {
            s += hijoIzq().inOrdenString();
            s += getRaiz().toString();
            s += hijoDer().inOrdenString();
        }
        return s;
    }
}