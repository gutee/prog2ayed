package algoritmos.estructuras.search;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 01/03/12
 * Time: 18:10
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearch {

    public static boolean binarySearch(int[] a, int k) {
        int min = 0;
        int max = ((a.length) - 1);
        while (min < max) {
            int middle = (min + max) / 2;
            if (a[middle] == k) {
                return true;
            } else if (a[middle] < k) {
                min = middle + 1;
            } else if (a[middle] > k) {
                max = middle - 1;
            }
        }
        return false;
    }
}