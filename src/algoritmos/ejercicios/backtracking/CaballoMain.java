package algoritmos.ejercicios.backtracking;

import algoritmos.estructuras.pila.PilaE;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 21/03/12
 * Time: 16:19
 * To change this template use File | Settings | File Templates.
 */
public class CaballoMain {
    public static void main(String[] args) {
        Caballo caballo = new Caballo();
        PilaE pilaSaltoUno = caballo.calcularUno();
        PilaE pilaSaltoDos = caballo.calcularSiguienteSalto(pilaSaltoUno);
        PilaE pilaSaltoTres = caballo.calcularSiguienteSalto(pilaSaltoDos);
        PilaE pilaSaltoCuatro = caballo.calcularSiguienteSalto(pilaSaltoTres);
        PilaE pilaSaltoCinco = caballo.calcularSiguienteSalto(pilaSaltoCuatro);
        System.out.println("Salto Uno:");
        System.out.println("");
        caballo.imprimirSalto(pilaSaltoUno);
        System.out.println("Salto Dos: ");
        System.out.println("");
        caballo.imprimirSalto(pilaSaltoDos);
    }
}