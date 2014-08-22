package algoritmos.estructuras.search;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 01/03/12
 * Time: 18:11
 * To change this template use File | Settings | File Templates.
 */
public class LinearSearch {

    public static boolean searchDisorderedNumber(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) {
                return true;
            }
        }
        return false;
    }

    public static boolean searchOrderedNumber(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) {
                return true;
            } else if (a[i] > k) {
                break;
            }
        }
        return false;
    }
}