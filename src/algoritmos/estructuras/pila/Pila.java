package algoritmos.estructuras.pila;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 06/03/12
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */
public interface Pila {

    public void apilar(Object o);

    public void desapilar();

    public void vaciar();

    public Object verTope();

    public boolean esVacio();
}