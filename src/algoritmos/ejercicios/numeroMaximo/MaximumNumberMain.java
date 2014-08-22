package algoritmos.ejercicios.numeroMaximo;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 01/03/12
 * Time: 01:11
 * To change this template use File | Settings | File Templates.
 */
public class MaximumNumberMain {
    public static void main(String[] args) {
        System.out.println("Write the first number: ");
        aNumber a = new aNumber((new Scanner(System.in)).nextInt());
        System.out.println("Write the second number: ");
        aNumber b = new aNumber((new Scanner(System.in)).nextInt());
        System.out.println("Write the third number: ");
        aNumber c = new aNumber((new Scanner(System.in)).nextInt());
        System.out.println("The largest number is: " + MaximumNumber.calculateMax(a, b, c));
    }
}