package algoritmos.tpa3.banco;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 29/03/12
 * Time: 18:34
 * To change this template use File | Settings | File Templates.
 */
public class PruebaBancosMain {
    public static void main(String[] args) {
        BancoUno bancoUno = new BancoUno();
        BancoDos bancoDos = new BancoDos();
        bancoUno.calcularTodo();
        bancoDos.calcularTodo();
        System.out.println("Banco con una fila: \n");
        System.out.println("\tCajero 1: " + bancoUno.getCajeroUno().getClientesAtendidos());
        System.out.println("\tCajero 2 : " + bancoUno.getCajeroDos().getClientesAtendidos());
        System.out.println("\tCajero 3 : " + bancoUno.getCajeroTres().getClientesAtendidos());
        System.out.println("\t El tiempo del banco fue de: " + bancoUno.getTiempoBanco() + "segundos");

        System.out.println("Banco con tres filas: \n");
        System.out.println("\tCajero 1: " + bancoDos.getCajeroUno().getClientesAtendidos());
        System.out.println("\tCajero 2 : " + bancoDos.getCajeroDos().getClientesAtendidos());
        System.out.println("\tCajero 3 : " + bancoDos.getCajeroTres().getClientesAtendidos());
        System.out.println("\t El tiempo del banco fue de: " + bancoDos.getTiempoBanco() + "segundos");
    }
}