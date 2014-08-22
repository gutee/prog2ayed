package algoritmos.tpa10.model;

import algoritmos.estructuras.arbolBinario.ArBinBus;
import algoritmos.tpa10.gui.exceptions.MatriculaYaExisteException;

import java.io.*;

/**
 * User: Martin Gutierrez
 * Date: 30/05/12
 * Time: 09:53
 */
public class ArchivoIndiceEstudiante {
    private ArBinBus indice;

    public ArchivoIndiceEstudiante() {
        this.indice = new ArBinBus();
    }

    public void agregar(int clave, long posicion) throws MatriculaYaExisteException {
        try {
            indice.insertar(new ArchivoIndice(clave, posicion));
        } catch (Exception e) {
            throw new MatriculaYaExisteException();
        }
    }

    public void eliminar(int clave, long posicion) {
        indice.eliminar(new ArchivoIndice(clave, posicion));
    }

    public void guardarEnDisco(String nombre) {
        try {
            File file = new File(nombre + ".ser");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(indice);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void leerDeDisco(String nombre) {
        ArBinBus arbol = null;
        try {
            FileInputStream fis = new FileInputStream(nombre + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            arbol = (ArBinBus) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        indice = arbol;
    }

    public String ordenClaves() {
        return indice.inOrdenString();
    }

    public boolean esVacio() {
        return indice.esVacio();
    }
}