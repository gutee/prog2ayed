package algoritmos.ejercicios.archivosBinarios;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * User: Martin Gutierrez
 * Date: 16/05/12
 * Time: 10:09
 */
public class Inicio {

    public Inicio() {
        alta();
        listar();
        baja();
        listar();
        busqueda();
    }

    private void listar() {        //procesamiento secuencial de un archivo
        ArchivoProducto arch;
        Producto p;
        try {
            arch = new ArchivoProducto("Los Chinos");
            long cant = arch.cantReg();
            for (long i = 0; i < cant; i++) {
                p = arch.leer();
                if (!p.isBorrado()) {
                    System.out.println(p.getCodigo() + ", " + p.getDescripcion() + ", " + p.getPrecio() + ", " + p.isHay() + ", " + p.getTipo());
                }
            }
            arch.cerrar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void alta() {
        ArchivoProducto arch;
        Producto p1 = new Producto(false, 112, "Harina", 32.50, true, 'A');
        Producto p2 = new Producto(false, 380, "Sal", 22.30, false, 'C');
        try {
            arch = new ArchivoProducto("Los Chinos");
            arch.escribir(p1);
            arch.escribir(p2);
            arch.escribir(new Producto(false, 700, "Pan", 10.75, true, 'A'));
            arch.cerrar();
        } catch (FileNotFoundException ex) {
            System.out.println("El Archivo no existe");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void baja() {
        ArchivoProducto arch;
        try {
            arch = new ArchivoProducto("Los Chinos");
            arch.eliminar(380);
            arch.cerrar();
        } catch (FileNotFoundException ex) {
            System.out.println("El Archivo no existe");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void busqueda() {
        ArchivoProducto arch;
        try {
            arch = new ArchivoProducto("Los Chinos");
            int buscar = arch.buscar(600);
            Producto p;
            if (buscar != -1) {
                p = arch.leer();
                if (!p.isBorrado()) {
                    System.out.println(p.getCodigo() + ", " + p.getDescripcion() + ", " + p.getPrecio() + ", " + p.isHay() + ", " + p.getTipo());
                }
            } else {
                System.out.println("El archivo no existe");
            }
            arch.cerrar();
        } catch (FileNotFoundException ex) {
            System.out.println("El Archivo no existe");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Inicio inicio = new Inicio();
    }
}