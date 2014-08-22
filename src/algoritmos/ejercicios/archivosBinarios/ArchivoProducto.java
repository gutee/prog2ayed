package algoritmos.ejercicios.archivosBinarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * User: Martin Gutierrez
 * Date: 16/05/12
 * Time: 09:59
 */
public class ArchivoProducto {
    private File f;
    private RandomAccessFile raf;
    private int tamañoString = 10;
    private int tamReg = 27;

    public ArchivoProducto(String nombre) throws FileNotFoundException {
        f = new File(nombre);
        raf = new RandomAccessFile(f, "rw");
    }

    public void escribir(Producto p) throws IOException {
        p.fijar(tamañoString);
        raf.writeBoolean(p.isBorrado());
        raf.writeInt(p.getCodigo());
        raf.writeUTF(p.getDescripcion());
        raf.writeDouble(p.getPrecio());
        raf.writeBoolean(p.isHay());
        raf.writeChar(p.getTipo());
    }

    public void agregar(Producto p) throws IOException {
        raf.seek(raf.length());
        escribir(p);
    }

    public Producto leer() throws IOException {
        return new Producto(raf.readBoolean(), raf.readInt(), raf.readUTF(),
                raf.readDouble(), raf.readBoolean(), raf.readChar());
    }

    public int buscar(int codigo) throws IOException {
        raf.seek(0);
        while (raf.getFilePointer() < raf.length()) {
            Producto p = leer();
            if (!p.isBorrado()) {
                if (p.getCodigo() == codigo) {
                    raf.seek(raf.getFilePointer() - tamReg - 1);
                    return (int) raf.getFilePointer();
                }
            }
        }
        return -1;
    }

    public void eliminar(int codigo) throws IOException {
        raf.seek(buscar(codigo));
        raf.writeBoolean(true);
    }

    public void cerrar() throws IOException {
        raf.close();
    }

    public long cantReg() throws IOException {
        return raf.length() / tamReg;
    }
}