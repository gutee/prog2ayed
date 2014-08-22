package algoritmos.estructuras.listaOrdenada;

import algoritmos.estructuras.search.Colectivo;
import algoritmos.parcialUno.Camion;
import algoritmos.parcialUno.Urna;

/**
 * User: Martin Gutierrez
 * Date: 09/05/12
 * Time: 18:41
 */
public class Prueba {
    public static void main(String[] args) {
        ListaOrd listaOrd = new ListaOrd();
        listaOrd.insertar(new Colectivo(67, 5));
        listaOrd.insertar(new Colectivo(57, 4));
        listaOrd.insertar(new Colectivo(35, 3));
        listaOrd.insertar(new Colectivo(57, 3));
        System.out.println("a");
        listaOrd.irPrimero();
        System.out.println(((Colectivo) listaOrd.getActual()).getInternos());
        System.out.println(((Colectivo) listaOrd.getActual()).getLinea());
        listaOrd.siguiente();
        System.out.println(((Colectivo) listaOrd.getActual()).getInternos());
        System.out.println(((Colectivo) listaOrd.getActual()).getLinea());
        listaOrd.siguiente();
        System.out.println(((Colectivo) listaOrd.getActual()).getInternos());
        System.out.println(((Colectivo) listaOrd.getActual()).getLinea());

        ListaOrd lista2 = new ListaOrd();
        lista2.insertar(5);
        lista2.insertar(6);
        lista2.insertar(4);

        lista2.irPrimero();
        System.out.println(lista2.getActual());
        lista2.siguiente();
        System.out.println(lista2.getActual());
        lista2.siguiente();
        System.out.println(lista2.getActual());

    }
}