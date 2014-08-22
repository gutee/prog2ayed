package algoritmos.estructuras.cola;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 28/03/12
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */
public class ColaDePrioridadMain {
    public static void main(String[] args) {
        ColaDePrioridad colaDePrioridad = new ColaDePrioridad(3);
        colaDePrioridad.encolar("hola", 1);
        colaDePrioridad.encolar("chau", 3);
        colaDePrioridad.encolar("medio", 2);
        colaDePrioridad.encolar("ultimo", 3);
        System.out.println(colaDePrioridad.desencolar());
        System.out.println(colaDePrioridad.desencolar());
        System.out.println(colaDePrioridad.desencolar());
        System.out.println(colaDePrioridad.desencolar());
    }
}