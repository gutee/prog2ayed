package algoritmos.tpa7;

import algoritmos.estructuras.arbolBinario.ArBinBus;
import algoritmos.estructuras.lista.Lista;
import algoritmos.estructuras.lista.ListaD;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 12/04/12
 * Time: 18:47
 * To change this template use File | Settings | File Templates.
 */
public class EmpresaMain {
    public static void main(String[] args) {
        ArBinBus stock = new ArBinBus();
        Lista lista = new ListaD();
        lista.insertarD(new Lampara("66775", 25, "una", 4));
        lista.insertarD(new Lampara("76779", 15, "otra", 7));
        lista.insertarD(new Lampara("86790", 10, "mas", 10));
        int eleccion = 1;
        while (eleccion != 0) {
            System.out.println("\t\tMenu:\n");
            System.out.println("1. Agregar lámpara.");
            System.out.println("2. Eliminar lámpara.");
            System.out.println("3. Bajar stock de lámpara.");
            System.out.println("4. Modificar lámpara.");
            System.out.println("5. Imprimir lista ordenada.");
            System.out.println("6. Pasar stock de la lista al nuevo sistema.");
            System.out.println("0. Salir.");
            eleccion = new Scanner(System.in).nextInt();

            switch (eleccion) {
                case (1):
                    String codigo = "";
                    while (codigo.length() != 5) {
                        System.out.println("Ingrese el código de la lámpara (5 caracteres): ");
                        codigo = new Scanner(System.in).next();
                    }
                    if (stock.existe(new Lampara(codigo))) {
                        Lampara existente = (Lampara) stock.recuperar(new Lampara(codigo));
                        stock.eliminar(existente);
                        System.out.println("¿Cuántas de estas están ingresando? ");
                        existente.subirStock(new Scanner(System.in).nextInt());
                        try {
                            stock.insertar(existente);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Ingrese los watts: ");
                        int watts = new Scanner(System.in).nextInt();
                        System.out.println("Ingrese el tipo de lámpara: ");
                        String tipo = new Scanner(System.in).next();
                        System.out.println("Ingrese la cantidad que ingresan: ");
                        int cantidad = new Scanner(System.in).nextInt();
                        try {
                            stock.insertar(new Lampara(codigo, watts, tipo, cantidad));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case (2):
                    String codigoAEliminar = "";
                    while (codigoAEliminar.length() != 5) {
                        System.out.println("Ingrese el código de la lámpara (5 caracteres): ");
                        codigoAEliminar = new Scanner(System.in).next();
                    }
                    Lampara eliminacion = new Lampara(codigoAEliminar);
                    stock.eliminar(eliminacion);
                    break;
                case (3):
                    String codigoABajar = "";
                    while (codigoABajar.length() != 5) {
                        System.out.println("Ingrese el código de la lámpara (5 caracteres): ");
                        codigoABajar = new Scanner(System.in).next();
                    }
                    Lampara aux = (Lampara) stock.recuperar(new Lampara(codigoABajar));
                    stock.eliminar(aux);
                    System.out.println("Stock disponible: " + aux.getCantidad());
                    System.out.println("Ingrese el stock a bajar: ");
                    aux.bajarStock(new Scanner(System.in).nextInt());
                    if (aux.getCantidad() > 0) {
                        try {
                            stock.insertar(aux);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case (4):
                    String codigoAMod = "";
                    while (codigoAMod.length() != 5) {
                        System.out.println("Ingrese el código de la lámpara (5 caracteres): ");
                        codigoAMod = new Scanner(System.in).next();
                    }
                    Lampara modificacion = (Lampara) stock.recuperar(new Lampara(codigoAMod));
                    stock.eliminar(modificacion);
                    int eleccionMenu2 = 1;
                    while (eleccionMenu2 != 0) {
                        System.out.println("Ingrese el que quiere modificar y cero para salir de la modicifación: ");
                        System.out.println("1. Código.");
                        System.out.println("2. Watts");
                        System.out.println("3. Tipo");
                        System.out.println("4. Cantidad");
                        eleccionMenu2 = new Scanner(System.in).nextInt();
                        switch (eleccionMenu2) {
                            case (1):
                                System.out.println("Código actual: " + modificacion.getCodigo());
                                String codigoNuevo = "";
                                while (codigoNuevo.length() != 5) {
                                    System.out.println("Ingrese el nuevo código de la lámpara (5 caracteres): ");
                                    codigoNuevo = new Scanner(System.in).next();
                                }
                                modificacion.setCodigo(codigoNuevo);
                                break;
                            case (2):
                                System.out.println("Watts actual: " + modificacion.getWatts() + "\nIngrese el nuevo: ");
                                int wattsNuevo = new Scanner(System.in).nextInt();
                                modificacion.setWatts(wattsNuevo);
                                break;
                            case (3):
                                System.out.println("Tipo actual: " + modificacion.getTipo() + "\nIngrese el nuevo: ");
                                String tipoNuevo = new Scanner(System.in).next();
                                modificacion.setTipo(tipoNuevo);
                                break;
                            case (4):
                                System.out.println("Cantidad actual: " + modificacion.getCantidad() + "\nIngrese el nuevo: ");
                                int cantidadNuevo = new Scanner(System.in).nextInt();
                                modificacion.setCantidad(cantidadNuevo);
                                break;
                            default:
                                System.out.println("Ingrese una opción válida.");
                                break;
                        }
                    }
                    try {
                        stock.insertar(modificacion);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case (5):
                    stock.imprimirInOrden();
                    break;
                case (6):
                    try {
                        stock = pasarListaArbol(lista, stock);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case (0):
                    break;
                default:
                    System.out.println("Ingrese una opción válida.");
            }
        }
    }

    public static ArBinBus pasarListaArbol(Lista lista, ArBinBus stock) throws Exception {
        lista.irPrimero();
        for (int i = 0; i < lista.longitud(); i++) {
            stock.insertar(lista.getActual());
            lista.siguiente();
        }
        return stock;
    }
}