package algoritmos.tpa2.calculadora;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 19/03/12
 * Time: 10:48
 * To change this template use File | Settings | File Templates.
 */
public class CalculadoraMain {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        System.out.println("Ingrese la cuenta deseada: ");
        String cuenta = new Scanner(System.in).next();
        System.out.println(calculadora.resultado(cuenta));
    }
}