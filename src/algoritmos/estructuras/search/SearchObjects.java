package algoritmos.estructuras.search;

import java.lang.reflect.Array;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 07/03/12
 * Time: 09:46
 * To change this template use File | Settings | File Templates.
 */
public class SearchObjects {

    public static boolean linearObjectSearch(Array[] objects, Object o) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == o) {
                return true;
            }
        }
        return false;
    }

    public boolean binarySearchObjects(Comparable<Object> objects[], Comparable o) {
        int min = 0;
        int max = ((objects.length) - 1);
        while (min < max) {
            int middle = (min + max) / 2;
            if (objects[middle].compareTo(o) == 0) {
                return true;
            } else if (objects[middle].compareTo(o) < 0) {
                max = middle - 1;
            } else if (objects[middle].compareTo(o) > 0) {
                min = middle + 1;
            }
        }
        return false;
    }
}