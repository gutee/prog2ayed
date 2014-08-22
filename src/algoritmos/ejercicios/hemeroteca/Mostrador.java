package algoritmos.ejercicios.hemeroteca;

import algoritmos.estructuras.lista.ListaD;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin Gutierrez
 * Date: 17/04/12
 * Time: 12:08
 */
public class Mostrador {
    private ListaD publicaciones;
    private ListaD clientesConEjemplares;
    private ListaD clientesSinEjemplares;
    private ListaD publicacionesSinEjemplares;
    public long NUMERO_DE_PUBLICACIONES;

    Mostrador() {
        publicaciones = new ListaD();
        clientesConEjemplares = new ListaD();
        clientesSinEjemplares = new ListaD();
        publicacionesSinEjemplares = new ListaD();
        NUMERO_DE_PUBLICACIONES = ((long) Math.random() * 4980) + 20;
        for (int i = 0; i < NUMERO_DE_PUBLICACIONES; i++) {
            publicaciones.insertarD(new Publicacion());
        }
    }

    public void decision(int decision) {
        switch (decision) {
            case (0):        //retira ejemplar
                System.out.println("Número de dni: ");
                long dni;
                dni = new Scanner(System.in).nextLong();
                if (existeCliente(dni)) {
                    Cliente cliente = recuperaClientePorDni(dni);
                    publicaciones.irA((int) (Math.random() * NUMERO_DE_PUBLICACIONES));
                    if (((Publicacion) publicaciones.getActual()).getEjemplares().esVacio()) {
                        publicacionesSinEjemplares.insertarD(publicaciones.getActual());
                        System.out.println("No hay mas ejemplares de la publicación");
                    } else {
                        cliente.agregarEjemplar((Ejemplar) publicaciones.getActual());
                        clientesConEjemplares.insertarD(cliente);
                    }
                } else {
                    if (existeConEjemplar(dni)) {
                        System.out.println("El cliente ya tiene un ejemplar");
                    } else {
                        Cliente cliente = new Cliente(dni);
                        publicaciones.irA((int) (Math.random() * NUMERO_DE_PUBLICACIONES));
                        if (((Publicacion) publicaciones.getActual()).getEjemplares().esVacio()) {
                            publicacionesSinEjemplares.insertarD(publicaciones.getActual());
                            System.out.println("No hay mas ejemplares de la publicación");
                        } else {
                            cliente.agregarEjemplar(((Publicacion) publicaciones.getActual()).darEjemplar());
                            clientesConEjemplares.insertarD(cliente);
                        }
                    }
                }
                break;
            case (1):
                int cualquierCliente = (int) (Math.random() * clientesConEjemplares.longitud());
                clientesConEjemplares.irA(cualquierCliente);
                Cliente cliente = (Cliente) clientesConEjemplares.getActual();
                clientesConEjemplares.eliminar();
                Ejemplar ejemplarExtraido = cliente.sacarEjemplar();
                clientesSinEjemplares.insertarD(cliente);
                insertarEjemplar(ejemplarExtraido);
        }
    }

    private boolean existeConEjemplar(long dni) {
        for (int i = 0; i < clientesConEjemplares.longitud(); i++) {
            clientesConEjemplares.irA(i);
            if (((Cliente) clientesConEjemplares.getActual()).getDni() == dni) {
                return true;
            }
        }
        return false;
    }

    private boolean existeCliente(long dni) {
        for (int i = 0; i < clientesSinEjemplares.longitud(); i++) {
            clientesSinEjemplares.irA(i);
            if (((Cliente) clientesSinEjemplares.getActual()).getDni() == dni) {
                return true;
            }
        }
        return false;
    }

    private Cliente recuperaClientePorDni(long dni) {
        for (int i = 0; i < clientesSinEjemplares.longitud(); i++) {
            clientesSinEjemplares.irA(i);
            if (((Cliente) clientesSinEjemplares.getActual()).getDni() == dni) {
                Cliente cliente = (Cliente) clientesSinEjemplares.getActual();
                clientesSinEjemplares.eliminar();
                return cliente;
            }
        }
        return null;
    }

    public void insertarEjemplar(Ejemplar ejemplar) {
        for (int i = 0; i < NUMERO_DE_PUBLICACIONES; i++) {
            publicaciones.irA(i);
            if (ejemplar.getNombrePublicacion().equals(((Publicacion) publicaciones.getActual()).getNombre())) {
                ((Publicacion) publicaciones.getActual()).getEjemplares().apilar(ejemplar);
            }
        }
    }

    public void terminaElDia() {
        for (int i = 0; i < clientesConEjemplares.longitud(); i++) {
            clientesConEjemplares.irA(i);
            Cliente cliente = (Cliente) clientesConEjemplares.getActual();
            if (cliente.getEjemplar() != null) {
                Ejemplar ejemplarExtraid = cliente.sacarEjemplar();
                clientesSinEjemplares.insertarD(cliente);
                insertarEjemplar(ejemplarExtraid);
            }
        }
        clientesConEjemplares.vaciar();
    }

    public ListaD getPublicacionesSinEjemplares() {
        return publicacionesSinEjemplares;
    }

    public ListaD getPublicaciones() {
        return publicaciones;
    }

    public ListaD getClientesConEjemplares() {
        return clientesConEjemplares;
    }
}