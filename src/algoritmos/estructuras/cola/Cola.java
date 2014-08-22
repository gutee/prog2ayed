package algoritmos.estructuras.cola;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 20/03/12
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
public interface Cola {

    public void encolar(Object o);

    public Object desencolar();

    public boolean esVacia();

    public void vaciar();
}
