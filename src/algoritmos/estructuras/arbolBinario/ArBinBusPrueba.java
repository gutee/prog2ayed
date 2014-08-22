package algoritmos.estructuras.arbolBinario;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 11/04/12
 * Time: 10:22
 * To change this template use File | Settings | File Templates.
 */
public class ArBinBusPrueba {
    public static void main(String[] args) {
        Aplicaciones aplicaciones = new Aplicaciones();
        try {
            ArBinBus arbol = new ArBinBus();
            arbol.insertar(5);
            arbol.insertar(6);
            arbol.insertar(7);
            arbol.insertar(4);
            arbol.insertar(3);
            arbol.insertar(1);
            arbol.insertar(2);
            arbol.imprimirInOrden();
            System.out.println(arbol.existe(2));
            System.out.println(arbol.recuperar(4));
            System.out.println(arbol.getMin());
            System.out.println(arbol.getMax());
            System.out.println(arbol.getRaiz());
            arbol.eliminar(7);
            System.out.println("");
            arbol.imprimirInOrden();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}