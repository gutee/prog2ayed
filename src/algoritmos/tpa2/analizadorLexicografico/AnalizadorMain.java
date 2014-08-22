package algoritmos.tpa2.analizadorLexicografico;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 14/03/12
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public class AnalizadorMain {
    public static void main(String[] args) {
        String texto = "[{(holaaaaaaa)}]";
        Analizador analizador = new Analizador();
        System.out.println(analizador.analizadorLexicografico(texto));
    }
}