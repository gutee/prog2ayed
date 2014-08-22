package algoritmos.tpa1.estudiante;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 03/03/12
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class EstudianteMain {
    public static void main(String[] args) {
        System.out.println("Ingrese la matrícula del estudiante: ");
        int matricula = (new Scanner(System.in)).nextInt();
        System.out.println("Ingrese el número de comisión: ");
        int comision = (new Scanner(System.in).nextInt());
        Estudiante estudiante = new Estudiante(matricula, comision);
        System.out.println("Ingrese el cambio de matrícula: ");
        estudiante.modificarMatricula(new Scanner(System.in).nextInt());
        System.out.println("Ingrese el cambio de comision: ");
        estudiante.modificarComision(new Scanner(System.in).nextInt());
        System.out.println("La matrícula es: " + estudiante.obtenerMatricula());
        System.out.println("El número de comisión es: " + estudiante.obtenerComision());
    }
}
