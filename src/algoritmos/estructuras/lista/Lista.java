package algoritmos.estructuras.lista;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 10/04/12
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */
public interface Lista {
    public int longitud();

    public Object getActual();

    public void insertarA(Object o);

    public void insertarD(Object o);

    public void vaciar();

    public void anterior();

    public void siguiente();

    public void irPrimero();

    public void irUltimo();

    public void eliminar();

    public boolean esVacia();
}
