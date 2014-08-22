package algoritmos.estructuras.nodo;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 13/03/12
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class NodeList {

    public static void main(String[] args) {
        Nodo lista;
        lista = new Nodo(24, new Nodo(25, new Nodo(26, new Nodo(27, new Nodo(28, null)))));
        Nodo muestra = lista;

        while (muestra != null) {
            System.out.println(muestra.dato);
            muestra = muestra.nodo;
        }
    }
}