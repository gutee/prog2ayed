package algoritmos.estructuras.search;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 07/03/12
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
public class SearchObjectsMain {
    public static void main(String[] args) {
        SearchObjects binary = new SearchObjects();
        Comparable[] colectivos = {new Colectivo(45, 50), new Colectivo(50, 60),
                new Colectivo(60, 65), new Colectivo(79, 30), new Colectivo(89, 15)};
        System.out.println(binary.binarySearchObjects(colectivos, new Colectivo(61, 65)));
    }
}