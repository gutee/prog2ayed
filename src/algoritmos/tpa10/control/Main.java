package algoritmos.tpa10.control;

import algoritmos.tpa10.gui.Tabla;
import algoritmos.tpa10.gui.exceptions.*;
import algoritmos.tpa10.gui.popups.ErrorFrame;
import algoritmos.tpa10.gui.MainFrame;
import algoritmos.tpa10.gui.popups.VentanaDeRegistro;
import algoritmos.tpa10.gui.popups.VentanaDeResultadoDeConsulta;
import algoritmos.tpa10.model.ArchivoEstudiante;
import algoritmos.tpa10.model.Estudiante;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * User: Martin Gutierrez
 * Date: 05/06/12
 * Time: 13:48
 */
public class Main {

    private ArchivoEstudiante archivoEstudiante;
    private MainFrame mainFrame;


    public Main(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void nuevoArchivo(String direccion) {
        try {
            File file = new File(direccion + ".reg");
            if (file.exists()) {
                new ErrorFrame(new JFrame(), "Error", "El Archivo ya existe");
            } else {
                archivoEstudiante = new ArchivoEstudiante(direccion + ".reg");
                mainFrame.setEnableAddButtons(true);
                mainFrame.setEnableSaveButtons(false);
                mainFrame.updateTabla(archivoEstudiante.leerTodos());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MatriculaYaExisteException e) {
            e.printStackTrace();
        }

    }

    public void abrirArchivo(String absolutePath) {
        try {
            File file = new File(absolutePath);
            if (!file.exists()) {
                new ErrorFrame(new JFrame(), "Error", "El Archivo no existe");
            } else {
                archivoEstudiante = new ArchivoEstudiante(absolutePath);
                mainFrame.setEnableAddButtons(true);
                mainFrame.setEnableSaveButtons(false);
                mainFrame.updateTabla(archivoEstudiante.leerTodos());
                if (archivoEstudiante.cantReg() != 0) {
                    mainFrame.setEnableSaveButtons(true);
                } else {
                    mainFrame.setEnableSaveButtons(false);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MatriculaYaExisteException e) {
            e.printStackTrace();
        }
    }

    public void agregar(Estudiante estudiante) throws NombreNoCompletoException, MatriculaYaExisteException, ÑException {
        try {
            archivoEstudiante.agregar(estudiante);
            mainFrame.updateTabla(archivoEstudiante.leerTodos());
            mainFrame.setEnableSaveButtons(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int matricula) throws MatriculaNoExisteException {
        try {

            archivoEstudiante.eliminar(matricula);
            if (archivoEstudiante.isEmpty()) {
                mainFrame.setEnableSaveButtons(false);
            }
            mainFrame.updateTabla(archivoEstudiante.leerTodos());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modificar(int matricula) throws MatriculaNoExisteException {
        try {
            if (archivoEstudiante.buscar(matricula) > -1) {
                Estudiante estudiante = archivoEstudiante.leer();
                new VentanaDeRegistro(new JFrame(), this, VentanaDeRegistro.MODIFICACION,
                        "Modificar Estudiante", estudiante, matricula);
            } else {
                throw new MatriculaNoExisteException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sobrescribir(int matricula, Estudiante estudiante) throws NombreNoCompletoException,
            MatriculaYaExisteException, ÑException {
        try {
            archivoEstudiante.sobreescribir(matricula, estudiante);
            mainFrame.updateTabla(archivoEstudiante.leerTodos());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MatriculaNoExisteException e){
            e.printStackTrace();
        }
    }

    public void consultar(String nombre) {
        try {
            Object[][] objects = archivoEstudiante.buscarPorCondicion(nombre);
            Tabla tabla = null;
            if(objects.length != 0){
            tabla = new Tabla();
            tabla.refreshTable(objects);
            }
            new VentanaDeResultadoDeConsulta(new JFrame(), tabla);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoResultadoException e) {
            new ErrorFrame(new JFrame(),"Error", e.getMessage());
        }

    }

    public void consultar(char character) {
        try {
            Object[][] objects = archivoEstudiante.buscarPorCondicion(character);
            Tabla tabla = null;
            if(objects.length != 0){
            tabla = new Tabla();
            tabla.refreshTable(objects);
            }
            new VentanaDeResultadoDeConsulta(new JFrame(), tabla);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoResultadoException e) {
            new ErrorFrame(new JFrame(),"Error", e.getMessage());
        }

    }

    public void consultar(String nombre, char character) {
        try {
            Object[][] objects = archivoEstudiante.buscarPorCondicion(nombre,character);
            Tabla tabla = null;
            if(objects.length != 0){
            tabla = new Tabla();
            tabla.refreshTable(objects);
            }
            new VentanaDeResultadoDeConsulta(new JFrame(), tabla);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoResultadoException e) {
            new ErrorFrame(new JFrame(),"Error", e.getMessage());
        }

    }

    public Estudiante consultar(int matricula) throws MatriculaNoExisteException {
        Estudiante estudiante = null;
        try {
            if (archivoEstudiante.buscar(matricula) != -1) {
                archivoEstudiante.buscar(matricula);
                estudiante = archivoEstudiante.leer();
            } else {
                throw new MatriculaNoExisteException();
            }
        } catch (IOException e) {
            throw new MatriculaNoExisteException();
        }
        return estudiante;
    }

    public void generarIndice() {
        try {
            archivoEstudiante.generarArchivoIndice();
            archivoEstudiante.guardarArchivoIndice(archivoEstudiante.getDirection());
        } catch (MatriculaYaExisteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public JTable getTable() {
       return mainFrame.getTable();
    }

    public String getFileName(){
        return archivoEstudiante.getFileName();
    }
}
