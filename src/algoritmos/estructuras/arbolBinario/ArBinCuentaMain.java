package algoritmos.estructuras.arbolBinario;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 04/04/12
 * Time: 18:16
 * To change this template use File | Settings | File Templates.
 */
public class ArBinCuentaMain {
    public static void main(String[] args) {
        Aplicaciones aplicaciones = new Aplicaciones();
        ArBinD arbolIzq1 = new ArBinD(3);
        ArBinD arbolDer1 = new ArBinD(2);
        ArBinD arbolIzq2 = new ArBinD(4);
        ArBinD arbolDer2 = new ArBinD(3);
        ArBinD arbolIzq3 = new ArBinD('*', arbolIzq1, arbolDer1);
        ArBinD arbolDer3 = new ArBinD('*', arbolIzq2, arbolDer2);
        ArBinD arbolDer4 = new ArBinD(5);
        ArBinD arbolIzq4 = new ArBinD(6);
        ArBinD arbolIzq5 = new ArBinD('+', arbolIzq3, arbolDer4);
        ArBinD arbolDer5 = new ArBinD('*', arbolIzq4, arbolDer3);
        ArBinD arbol = new ArBinD('-', arbolIzq5, arbolDer5);

        System.out.println(aplicaciones.getResultado(arbol));
    }
}