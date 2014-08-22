package algoritmos.tpa3.palindromo;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 27/03/12
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
public class AnalizadorPalindromoMain {
    public static void main(String[] args) {
        AnalizadorPalindromo analizadorPalindromo = new AnalizadorPalindromo();
        System.out.println("Ingrese la palabra a analizar: ");
        String s = new Scanner(System.in).next();
        System.out.println(analizadorPalindromo.analizadorPalindromo(s));
    }
}
