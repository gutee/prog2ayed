package algoritmos.estructuras.arbolBinario;

import algoritmos.estructuras.cola.ColaE;

import java.io.*;

/**
 * User: Martin Gutierrez
 * Date: 21/03/12
 * Time: 13:41
 */
public class Aplicaciones {

    public int peso(ArBin a) {
        if (a.esVacio()) {
            return 0;
        } else {
            return 1 + peso(a.hijoIzq()) + peso(a.hijoDer());
        }
    }

    public int cantHojas(ArBin a) {
        if (a.esVacio()) {
            return 0;
        } else if (!a.esVacio() && a.hijoDer().esVacio() && a.hijoIzq().esVacio()) {
            return 1;
        } else {
            return cantHojas(a.hijoDer()) + cantHojas(a.hijoIzq());
        }
    }

    public int elemento(ArBin a, Object obj) {
        if (a.esVacio()) return 0;
        else if (a.getRaiz().equals(obj)) {
            return 1 + elemento(a.hijoIzq(), obj) + elemento(a.hijoDer(), obj);
        } else return elemento(a.hijoIzq(), obj) + elemento(a.hijoDer(), obj);
    }

    public int elementosNivel(ArBin a, int nivel) {
        if (a.esVacio()) return 0;
        else if (nivel == 0) return 1;
        else {
            return elementosNivel(a.hijoIzq(), nivel - 1) + elementosNivel(a.hijoDer(), nivel - 1);
        }
    }

    public int altura(ArBin a) {
        if (a.esVacio()) return -1;
        else return 1 + Math.max(altura(a.hijoIzq()), altura(a.hijoDer()));
    }

    public int sumaElementos(ArBin a) {
        if (a.esVacio()) return 0;
        else return (Integer) a.getRaiz() + sumaElementos(a.hijoIzq()) + sumaElementos(a.hijoDer());
    }

    public int multiplosTres(ArBin a) {
        if (a.esVacio()) return 0;
        else if ((Integer) (a.getRaiz()) % 3 == 0) {
            return (Integer) a.getRaiz() + multiplosTres(a.hijoIzq()) + multiplosTres(a.hijoDer());
        } else return multiplosTres(a.hijoIzq()) + multiplosTres(a.hijoDer());
    }

    public boolean iguales(ArBin arbin1, ArBin arbin2) {
        if (arbin1.getRaiz() != arbin2.getRaiz()) return false;
        else {
            return iguales(arbin1.hijoIzq(), arbin2.hijoIzq()) &&
                    iguales(arbin1.hijoDer(), arbin2.hijoDer());
        }
    }

    public boolean isomorfos(ArBin arbin1, ArBin arbin2) {
        boolean b = true;
        ColaE elementos1 = new ColaE();
        ColaE elementos2 = new ColaE();
        ColaE aux1 = crearColaDeArbol(arbin1, elementos1);
        ColaE aux2 = crearColaDeArbol(arbin2, elementos2);
        elementos1 = aux1;
        elementos2 = aux2;
        int cantElementos = altura(arbin1);
        if (cantElementos != altura(arbin2)) {
            return false;
        } else {
            for (int i = 0; i < cantElementos; i++) {
                if (elementos1.desencolar() != elementos2.desencolar()) {
                    return false;
                }
            }
        }
        return b;
    }


    public boolean semejantes(ArBin arbin1, ArBin arbin2) {
        boolean b = true;
        ColaE elementos = new ColaE();
        ColaE aux = crearColaDeArbol(arbin1, elementos);
        elementos = aux;
        int cantElementos = altura(arbin1);
        for (int i = 0; i < cantElementos; i++) {
            Object obj = elementos.desencolar();
            if (elemento(arbin2, obj) == 0) return false;
        }
        return b;
    }

    private ColaE crearColaDeArbol(ArBin a, ColaE cola) {
        if (!a.esVacio()) {
            cola.encolar(a.getRaiz());
            crearColaDeArbol(a.hijoIzq(), cola);
            crearColaDeArbol(a.hijoDer(), cola);
        }
        return cola;
    }

    public boolean completo(ArBin a) {
        if (a.esVacio()) return true;
        else if ((a.hijoIzq().esVacio() && !a.hijoDer().esVacio()) ||
                (a.hijoDer().esVacio() && !a.hijoIzq().esVacio())) {
            return false;
        } else return completo(a.hijoIzq()) && completo(a.hijoDer());
    }

    public boolean lleno(ArBin a) {
        int altura = altura(a);
        int cantElementos = 2 ^ altura;
        if (a.esVacio()) return true;
        else if (!completo(a)) return false;
        else if (completo(a) && elementosNivel(a, altura - 1) != cantElementos) return false;
        else return true;
    }

    public void imprimirIntPreOrden(ArBin a) {
        if (!a.esVacio()) {
            System.out.println((Integer) a.getRaiz());
            imprimirIntPreOrden(a.hijoIzq());
            imprimirIntPreOrden(a.hijoDer());
        }
    }

    public void imprimirIntInOrden(ArBin a) {
        if (!a.esVacio()) {
            imprimirIntInOrden(a.hijoIzq());
            System.out.println((Integer) a.getRaiz());
            imprimirIntInOrden(a.hijoDer());
        }
    }

    public void imprimirIntPostOrden(ArBin a) {
        if (!a.esVacio()) {
            imprimirIntPostOrden(a.hijoIzq());
            imprimirIntPostOrden(a.hijoDer());
            System.out.println((Integer) a.getRaiz());
        }
    }

    public void imprimirIntPorNiveles(ArBin a) {
        ColaE cola = new ColaE();
        ColaE colaAux = new ColaE();
        ArBin aux;
        if (!a.esVacio()) {
            cola.encolar(a);
            while (!cola.esVacia()) {
                aux = (ArBin) cola.desencolar();
                colaAux.encolar(aux);
                if (!aux.hijoIzq().esVacio()) {
                    cola.encolar(aux.hijoIzq());
                }
                if (!aux.hijoDer().esVacio()) {
                    cola.encolar(aux.hijoDer());
                }
            }
            while (!colaAux.esVacia()) {
                System.out.println(((ArBin) colaAux.desencolar()).getRaiz());
            }
        }
    }

    public void guardarArbol(ArBin a, String nombreArchivo) {
        try {
            File file = new File(nombreArchivo + ".ser");
            System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArBinD cargarArbol(String nombreArchivo) {
        ArBinD arbol = null;
        try {
            FileInputStream fis = new FileInputStream(nombreArchivo + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            arbol = (ArBinD) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return arbol;
    }

    public int getResultado(ArBin a) {
        if (a.esVacio()) {
            return 0;
        } else if ((a.getRaiz()).equals('+')) {
            return getResultado(a.hijoIzq()) + getResultado(a.hijoDer());
        } else if ((a.getRaiz()).equals('-')) {
            return getResultado(a.hijoIzq()) - getResultado(a.hijoDer());
        } else if ((a.getRaiz()).equals('*')) {
            return getResultado(a.hijoIzq()) * getResultado(a.hijoDer());
        } else if ((a.getRaiz()).equals('/')) {
            return getResultado(a.hijoIzq()) / getResultado(a.hijoDer());
        } else {
            return (Integer) a.getRaiz();
        }
    }
}