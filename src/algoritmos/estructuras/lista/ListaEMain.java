package algoritmos.estructuras.lista;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 10/04/12
 * Time: 12:36
 * To change this template use File | Settings | File Templates.
 */
public class ListaEMain {
    public static void main(String[] args) {
        ListaE lista = new ListaE();
        lista.insertarA("primero");
        lista.insertarD("segundo");
        lista.insertarA("medio");
        lista.irPrimero();
        System.out.println(lista.getActual());
        lista.siguiente();
        System.out.println(lista.getActual());
        lista.irUltimo();
        System.out.println(lista.getActual());
    }
}