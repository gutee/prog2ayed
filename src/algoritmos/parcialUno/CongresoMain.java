package algoritmos.parcialUno;

import java.util.Scanner;

import algoritmos.estructuras.listaOrdenada.ListaOrd;

/**
 * User: martingutierrez
 * Date: 08/05/12
 * Time: 11:36
 */
public class CongresoMain {

    public static void main(String[] args) {
        int tiempoPasado = 0;
        int decision = 1;
        Congreso congreso = new Congreso();
        congreso.atender(tiempoPasado);
        tiempoPasado = 20;
        while (decision != 2) {
            System.out.println("Menu:");
            System.out.println("\t1. Avanzar 20 minutos.");
            System.out.println("\t2. Finalizar programa.");
            decision = new Scanner(System.in).nextInt();

            switch (decision) {
                case (1):
                    congreso.atender(tiempoPasado);
                    break;
                case (2):
                    System.out.println("Cantidad de camiones recibidos: " + congreso.cantidadDeCamiones());
                    System.out.println("Tiempo medio de espera por camión: " + congreso.tiempoMedioDeEspera());
                    ListaOrd camionesAtendidos = congreso.getCamionesAtendidos();
                    System.out.println("Informe de camiones: ");
                    for (int i = 1; i <= camionesAtendidos.longitud(); i++) {
                        System.out.println("\tCódigo de colegio: " + ((Camion) camionesAtendidos.getObject(i)).getColegio()
                                + "\tCant de urnas: " + ((Camion) camionesAtendidos.getObject(i)).getNumeroDeUrnas());
                    }
                    break;
                default:
                    System.out.println("Ingrese una opción válida.");
                    break;
            }
            tiempoPasado += 20;
        }
    }
}