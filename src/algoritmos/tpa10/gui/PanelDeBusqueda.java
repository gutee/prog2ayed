package algoritmos.tpa10.gui;

import algoritmos.tpa10.control.Main;
import algoritmos.tpa10.gui.exceptions.Matricula4NumbersException;
import algoritmos.tpa10.gui.exceptions.MatriculaNoExisteException;
import algoritmos.tpa10.gui.fields.CampoMatricula;
import algoritmos.tpa10.gui.popups.ErrorFrame;
import algoritmos.tpa10.model.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/19/12
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class PanelDeBusqueda extends JPanel implements ActionListener {

    private final JLabel etiquetaBuscar = new JLabel("Buscar por Matricula :");

    private CampoMatricula campoMatricula;
    private JLabel nombre, matricula, comision;
    private JButton botonDeBusqueda;
    private JPanel panelDeBusqueda,marcoPanelDeBusqueda, panelVacio;

    public static int WIDTH = 280;
    public static int HEIGHT = 200;

    Main main;

    public PanelDeBusqueda(Main main) {
        this.main = main;

        panelDeBusqueda = new JPanel(new GridLayout(6, 1));
        panelVacio = new JPanel();

        panelDeBusqueda.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        panelDeBusqueda.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        marcoPanelDeBusqueda = new JPanel(new BorderLayout(5,5));

        setPreferredSize(new Dimension(WIDTH, -1));
        setMaximumSize(new Dimension(WIDTH, -1));
        setLayout(new BorderLayout());


        nombre = new JLabel("Nombre y Apellido :");
        matricula = new JLabel("Matricula :");
        comision = new JLabel("Comision :");

        botonDeBusqueda = new JButton("Buscar",
                new ImageIcon("src\\algoritmos\\tpa10\\gui\\icons\\Search.png"));
        botonDeBusqueda.addActionListener(this);

        campoMatricula = new CampoMatricula("Matricula");
        campoMatricula.addActionListener(this);

        panelDeBusqueda.add(etiquetaBuscar);
        panelDeBusqueda.add(campoMatricula);
        panelDeBusqueda.add(nombre);
        panelDeBusqueda.add(matricula);
        panelDeBusqueda.add(comision);
        panelDeBusqueda.add(botonDeBusqueda);

        marcoPanelDeBusqueda.add(panelDeBusqueda,BorderLayout.CENTER);
        marcoPanelDeBusqueda.add(new JPanel(),BorderLayout.NORTH);
        marcoPanelDeBusqueda.add(new JPanel(),BorderLayout.EAST);
        marcoPanelDeBusqueda.add(new JPanel(),BorderLayout.WEST);
        marcoPanelDeBusqueda.add(new JPanel(),BorderLayout.SOUTH);
        marcoPanelDeBusqueda.setBorder(BorderFactory.createLineBorder(Color.gray));

        add(marcoPanelDeBusqueda, BorderLayout.NORTH);
        add(panelVacio, BorderLayout.CENTER);
    }

    public void setEnabled(boolean value) {
        campoMatricula.setEnabled(value);
        botonDeBusqueda.setEnabled(value);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Estudiante estudiante;
            estudiante = main.consultar(campoMatricula.getValue());

            if (estudiante != null) {
            nombre.setText("Nombre y Apellido : " + estudiante.getNombreApellido());
            matricula.setText("Matricula : " + estudiante.getMatricula());
            comision.setText("Comision : " + estudiante.getComision());
            campoMatricula.setText("Matricula");
            campoMatricula.transferFocus();
            updateUI();
        }
        } catch (Matricula4NumbersException e1) {
            new ErrorFrame(new JFrame(), "Error", e1.getMessage());
        } catch (MatriculaNoExisteException e1){
            new ErrorFrame(new JFrame(), "Error", e1.getMessage());
            campoMatricula.setText("");

        }


    }
}
