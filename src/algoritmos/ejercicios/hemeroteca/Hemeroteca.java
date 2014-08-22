package algoritmos.ejercicios.hemeroteca;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin Gutierrez
 * Date: 17/04/12
 * Time: 12:20
 */
public class Hemeroteca {
    public static void main(String[] args) {
        Mostrador mostrador = new Mostrador();
        mostrador.decision(0);
        mostrador.decision(0);
        int eleccion = 1;
        while (eleccion != 2) {
            System.out.println("Menu: \n");
            System.out.println("\t1. Dar/Devolver Ejemplar.");
            System.out.println("\t2. Salir.");
            eleccion = new Scanner(System.in).nextInt();

            switch (eleccion) {
                case (1):
                    int decision = ((int) (Math.random() * 2));
                    if (mostrador.getClientesConEjemplares().esVacia()) {
                        decision = 0;
                    }
                    mostrador.decision(decision);
                    break;
                case (2):
                    mostrador.terminaElDia();
                    System.out.println("Publicaciones que no tenían ejemplares: ");
                    for (int i = 0; i < mostrador.getPublicacionesSinEjemplares().longitud(); i++) {
                        mostrador.getPublicacionesSinEjemplares().irA(i);
                        String nombre = ((Publicacion) mostrador.getPublicacionesSinEjemplares()
                                .getActual()).getNombre();
                        System.out.println(nombre);
                    }
                    for (int j = 0; j < mostrador.NUMERO_DE_PUBLICACIONES; j++) {
                        mostrador.getPublicaciones().irA(j);
                        if (((Publicacion) mostrador.getPublicaciones().getActual()).algunEjemplarRetirado()) {
                            Publicacion publicacion = (Publicacion) mostrador.getPublicaciones().getActual();
                            System.out.println("Nombre de la publicación: " + publicacion.getNombre());
                            while (publicacion.algunEjemplarRetirado()) {
                                Ejemplar ejemplar = publicacion.darEjemplar();
                                System.out.println("\tEjemplar " + ejemplar.getNumeroDeSerie() + "\t\t"
                                        + ejemplar.getTiempoUsado() + " milisegundos usados");
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Ingrese una opción válida.");
                    break;
            }

        }
    }
}
