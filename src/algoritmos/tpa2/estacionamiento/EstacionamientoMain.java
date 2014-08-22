package algoritmos.tpa2.estacionamiento;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 14/03/12
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
public class EstacionamientoMain {
    public static void main(String[] args) {
        int ingresado = 0;
        Estacionamiento estacionamiento = new Estacionamiento();
        while (ingresado != 4) {
            System.out.println("\t Menu");
            System.out.println("1. Agregar auto");
            System.out.println("2. Sacar último auto");
            System.out.println("3. Sacar auto seleccionado");
            System.out.println("4. Salir");
            ingresado = new Scanner(System.in).nextInt();
            switch (ingresado) {
                case (1):
                    System.out.println("Ingresar matricula del auto: ");
                    estacionamiento.agregarAuto(new Auto(new Scanner(System.in).next()));
                    break;
                case (2):
                    Auto autoUltimo = estacionamiento.sacarUltimoAuto();
                    System.out.println("Matricula del auto que sale: " + autoUltimo.getMatricula());
                    break;
                case (3):
                    System.out.println("Ingresar matrícula del auto que se quiere sacar: ");
                    Auto autoSelec = new Auto(new Scanner(System.in).next());
                    estacionamiento.sacarAutoSeleccionado(autoSelec);
                    break;
                case (4):
                    System.out.println("La recaudación es de: $" + estacionamiento.getRecaudacion());
                    break;
                default:
                    System.out.println("No está en el menú.");
                    break;
            }
        }
    }
}
