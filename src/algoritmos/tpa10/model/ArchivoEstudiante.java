package algoritmos.tpa10.model;

import algoritmos.estructuras.lista.ListaD;
import algoritmos.tpa10.gui.exceptions.MatriculaNoExisteException;
import algoritmos.tpa10.gui.exceptions.MatriculaYaExisteException;
import algoritmos.tpa10.gui.exceptions.NombreNoCompletoException;
import algoritmos.tpa10.gui.exceptions.ÑException;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * User: Martin Gutierrez
 * Date: 30/05/12
 * Time: 09:35
 */
public class ArchivoEstudiante {
    private File f;
    private RandomAccessFile raf;
    private ArchivoIndiceEstudiante aie;
    private final int tamañoString = 20;
    private final int tamReg = 29;
    private int numberOfRegisters = 0;


    public ArchivoEstudiante(String nombre) throws IOException, MatriculaYaExisteException {
        f = new File(nombre);
        raf = new RandomAccessFile(f, "rw");
        aie = new ArchivoIndiceEstudiante();
        numberOfRegisters = calcNumberOfRegisters();

        generarArchivoIndice();
    }

    public void escribir(Estudiante e) throws IOException, MatriculaYaExisteException,
            NombreNoCompletoException, ÑException {
        String nombre = e.getNombreApellido();
        if (!nombre.equals("")) {
            if (!nombre.contains("ñ") && !nombre.contains("Ñ")) {
                e.fijar(tamañoString);
                aie.agregar(e.getMatricula(), raf.getFilePointer());
                raf.writeBoolean(e.isBorrado());
                raf.writeInt(e.getMatricula());
                raf.writeChar(e.getComision());
                raf.writeUTF(e.getNombreApellido());
            } else {
                throw new ÑException();
            }
        } else {
            throw new NombreNoCompletoException();
        }
    }

    public void agregar(Estudiante e) throws IOException, NombreNoCompletoException,
            MatriculaYaExisteException, ÑException {

        raf.seek(raf.length());
        escribir(e);
        numberOfRegisters++;

    }

    public Estudiante leer() throws IOException {
        return new Estudiante(raf.readBoolean(), raf.readInt(), raf.readChar(), raf.readUTF());
    }

    public int buscar(int matricula) throws IOException {
        raf.seek(0);
        while (raf.getFilePointer() < raf.length()) {
            Estudiante e = leer();
            if (!e.isBorrado()) {
                if (e.getMatricula() == matricula) {
                    raf.seek(raf.getFilePointer() - tamReg);
                    return (int) raf.getFilePointer();
                }
            }
        }
        raf.seek(0);
        return -1;
    }

    public void eliminar(int matricula) throws MatriculaNoExisteException, IOException {
        int busqueda = buscar(matricula);
        if (busqueda != -1) {
            raf.seek(busqueda);
            aie.eliminar(matricula, raf.getFilePointer());
            raf.writeBoolean(true);
            numberOfRegisters--;
        } else {
            throw new MatriculaNoExisteException();
        }
    }

    public void cerrar() throws IOException {
        raf.close();
    }

    public long cantReg() throws IOException {
        return numberOfRegisters;
    }

    public void generarArchivoIndice() throws IOException, MatriculaYaExisteException {
        raf.seek(0);
        ArchivoIndiceEstudiante temp = new ArchivoIndiceEstudiante();
        while (raf.getFilePointer() < raf.length()) {
            long posicion = raf.getFilePointer();
            Estudiante e = leer();
            if (!e.isBorrado()) {
                temp.agregar(e.getMatricula(), posicion);
            }
        }
        aie = temp;
    }

    public void guardarArchivoIndice(String nombre) {
        aie.guardarEnDisco(nombre);
    }

    public void inicio() throws IOException {
        raf.seek(0);
    }

    public String getDirection() {
        String path = f.getAbsolutePath();
        return path.substring(0, path.lastIndexOf("."));

    }

    public void leerArchivoIndice(String nombre) {
        aie.leerDeDisco(nombre);
    }

    public boolean isEmpty() {
        return numberOfRegisters == 0;
    }

    public int calcNumberOfRegisters() throws IOException {
        int numberOfRegister = 0;
        int position = 0;
        raf.seek(position);
        while (raf.getFilePointer() < raf.length()) {
            if (!raf.readBoolean()) {
                numberOfRegister++;
            }
            position = position + tamReg;
            raf.seek(position);
        }
        return numberOfRegister;
    }

    public Object[][] leerTodos() throws IOException {
        String s = aie.ordenClaves();
        String clave = "";
        int j = 0;
        Object[][] estudiantes = new String[numberOfRegisters][3];
        Estudiante e;
        if (!aie.esVacio()) {
            for (int i = 0; i < s.length(); i += 4) {
                clave = s.substring(i, i + 4);
                raf.seek(buscar(Integer.parseInt(clave)));
                e = leer();
                estudiantes[j][0] = e.getNombreApellido();
                estudiantes[j][1] = Character.toString(e.getComision());
                estudiantes[j][2] = Integer.toString(e.getMatricula());
                j++;
            }
            return estudiantes;
        } else {
            return new Object[][]{};
        }

    }

    public String getFileName() {
        String name = f.getName();
        return name.substring(0, name.lastIndexOf("."));
    }

    public void sobreescribir(int matriculaVieja, Estudiante estudiante) throws NombreNoCompletoException,
            MatriculaYaExisteException, IOException, ÑException, MatriculaNoExisteException {
        int busqueda = buscar(matriculaVieja);
        eliminar(matriculaVieja);
        raf.seek(busqueda);
        escribir(estudiante);
        numberOfRegisters++;
    }

    public Object[][] buscarPorCondicion(String nombre, char character) throws IOException {
        ListaD listaD = new ListaD();
        Estudiante e;
        raf.seek(0);
        while (raf.getFilePointer() < raf.length()) {
            e = leer();
            if (!e.isBorrado()) {
                if ((e.getNombreApellido().toLowerCase()).contains(nombre.toLowerCase())
                        && (e.getComision() == character)) {
                    listaD.insertarD(e);
                }
            }
        }

        return objectsFromListaDEstudiantes(listaD);
    }

    public Object[][] buscarPorCondicion(char character) throws IOException {
        ListaD listaD = new ListaD();
        Estudiante e;
        raf.seek(0);
        while (raf.getFilePointer() < raf.length()) {
            e = leer();
            if (!e.isBorrado()) {
                if ((e.getComision() == character)) {
                    listaD.insertarD(e);
                }
            }
        }

        return objectsFromListaDEstudiantes(listaD);
    }

    public Object[][] buscarPorCondicion(String nombre) throws IOException {
        ListaD listaD = new ListaD();
        raf.seek(0);
        Estudiante e;
        while (raf.getFilePointer() < raf.length()) {
            e = leer();
            if (!e.isBorrado()) {
                if ((e.getNombreApellido().toLowerCase()).contains(nombre.toLowerCase())) {
                    listaD.insertarD(e);
                }
            }
        }
        return objectsFromListaDEstudiantes(listaD);

    }

    private Object[][] objectsFromListaDEstudiantes(ListaD listaD) {
        Estudiante e;
        Object[][] estudiantes = {};
        if (listaD.longitud() != 0) {
            estudiantes = new String[listaD.longitud()][3];
            listaD.irPrimero();
            int i = 0;
            while (listaD.getActual() != null) {
                e = (Estudiante) listaD.getActual();
                estudiantes[i][0] = e.getNombreApellido();
                estudiantes[i][1] = Character.toString(e.getComision());
                estudiantes[i][2] = Integer.toString(e.getMatricula());
                i++;
                listaD.siguiente();
            }
        }
        return estudiantes;
    }
}