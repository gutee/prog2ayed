package algoritmos.tpa5;

import algoritmos.estructuras.listaOrdenada.ListaOrd;

import java.io.Serializable;

/**
 * User: Martin Gutierrez
 * Date: 09/05/12
 * Time: 20:26
 */
public class Censo implements Serializable {
    private ListaOrd colectivos;

    Censo() {
        colectivos = new ListaOrd();
    }

    public void insertarColectivo(Colectivoo colectivo) {
        colectivos.insertar(colectivo);
    }

    public void eliminarColectivo(Colectivoo colectivo) {
        for (int i = 1; i <= colectivos.longitud(); i++) {
            if (((Colectivoo) colectivos.getObject(i)).compareTo(colectivo) == 0) {
                colectivos.irA(i);
                colectivos.eliminar();
            }
        }
    }

    public void imprimirLista() {
        for (int i = 1; i <= colectivos.longitud(); i++) {
            System.out.println("Linea: " + ((Colectivoo) colectivos.getObject(i)).getLinea());
            System.out.println("Interno: " + ((Colectivoo) colectivos.getObject(i)).getInterno());
            System.out.println("Asientos: " + ((Colectivoo) colectivos.getObject(i)).getAsientos());
            System.out.println("Discapacitados: " + ((Colectivoo) colectivos.getObject(i)).isDiscapacitados());
            System.out.println();
        }
    }

    public int cuantosDiscapacitados() {
        int cuantosDiscapacitados = 0;
        for (int i = 1; i <= colectivos.longitud(); i++) {
            if (((Colectivoo) colectivos.getObject(i)).isDiscapacitados()) {
                cuantosDiscapacitados++;
            }
        }
        return cuantosDiscapacitados;
    }

    public int cuantosConMas() {
        int cuantosConMas = 0;
        for (int i = 1; i <= colectivos.longitud(); i++) {
            if (((Colectivoo) colectivos.getObject(i)).getAsientos() > 27) {
                cuantosConMas++;
            }
        }
        return cuantosConMas;
    }
}