package algoritmos.tpa1.numeroComplejo;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 03/03/12
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
public class NumeroComplejoMain {
    public static void main(String[] args) {
        System.out.println("Write the real part of the first complex: ");
        double re1 = (new Scanner(System.in)).nextDouble();
        System.out.println("Write the imaginary part of the first complex: ");
        double im1 = (new Scanner(System.in)).nextDouble();
        System.out.println("Write the real part of the second complex: ");
        double re2 = (new Scanner(System.in)).nextDouble();
        System.out.println("Write the imaginary part of the second complex: ");
        double im2 = (new Scanner(System.in)).nextDouble();
        NumeroComplejo c1 = new NumeroComplejo(re1, im1);
        NumeroComplejo c2 = new NumeroComplejo(re2, im2);
        System.out.println("La suma de los complejos es: " + OperacionesComplejos.suma(c1, c2));
        System.out.println("La resta de los complejo es: " + OperacionesComplejos.resta(c1, c2));
        System.out.println("El producto de los complejos es: " + OperacionesComplejos.producto(c1, c2));
        System.out.println("El cociente de los complejos es: " + OperacionesComplejos.cociente(c1, c2));
        System.out.println("El modulo del primer complejo es: " + c1.calcularModulo());
        System.out.println("El modulo del segundo complejo es: " + c2.calcularModulo());
    }
}