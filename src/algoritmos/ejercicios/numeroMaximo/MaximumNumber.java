package algoritmos.ejercicios.numeroMaximo;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 01/03/12
 * Time: 01:05
 * To change this template use File | Settings | File Templates.
 */
public class MaximumNumber {
    private aNumber a, b, c;

    public static double calculateMax(aNumber a, aNumber b, aNumber c) {
        double auxComparation = Math.max(a.getNumber(), b.getNumber());
        return Math.max(auxComparation, c.getNumber());
    }
}