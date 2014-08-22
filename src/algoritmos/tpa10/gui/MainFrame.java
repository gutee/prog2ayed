package algoritmos.tpa10.gui;

import algoritmos.tpa10.control.Main;
import algoritmos.tpa10.control.action.*;
import com.apple.eawt.Application;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 12/10/11
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainFrame {
    private JFrame mainFrame;
    private JPanel mainPanel, buttonPanel, panelDeBusqueda;
    private JButton botonDeNuevoEst, botonEliminar, botonModificar, botonArchIndice, botonImprimir, botonConsultar;
    private JMenuBar menuBar;
    private JMenuItem newProject, archivoIndice, openProject, addClass, removeClass, imprimir, consultar;
    private JMenu projectMenu, fileMenu;
    private Tabla contentPane;

    private JMenuItem modificarEstudiante;

    private Main main;

    final static Dimension INITIAL_DIMENSION = new Dimension(850, 600);
    final static Dimension MIN_DIMENSION = new Dimension(850, 600);


    public MainFrame() {
        main = new Main(this);

        /*try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        */

        buildMainFrame();
        setEnableSaveButtons(false);
        setEnableAddButtons(false);
        //mainFrame.setIconImage(new ImageIcon("src//algoritmos//tpa10//gui//icons//Database.png").getImage());
        Application.getApplication().setDockIconImage(
                new ImageIcon("src//algoritmos//tpa10//gui//icons//Database.png").getImage());
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private JFrame buildMainFrame() {
        mainFrame = new JFrame("Trabajo Práctico 10");

        mainFrame.setPreferredSize(INITIAL_DIMENSION);
        mainFrame.setMinimumSize(MIN_DIMENSION);

        LayoutManager mainFrameLayout = new SpringLayout();
        mainFrame.setLayout(mainFrameLayout);
        mainFrame.setJMenuBar(buildMenuBar());

        panelDeBusqueda = new PanelDeBusqueda(main);
        mainFrame.add(panelDeBusqueda);
        mainFrame.add(buildMainPanel());
        mainFrame.add(buildButtonPanel());

        configMainFrameLayout((SpringLayout) mainFrameLayout);

        mainFrame.pack();

        return mainFrame;
    }

    private void configMainFrameLayout(SpringLayout mainFrameLayout) {
        Container container = mainFrame.getContentPane();

        mainFrameLayout.putConstraint(SpringLayout.WEST, mainPanel,
                5,
                SpringLayout.WEST, container);

        mainFrameLayout.putConstraint(SpringLayout.NORTH, mainPanel,
                5,
                SpringLayout.SOUTH, buttonPanel);

        mainFrameLayout.putConstraint(SpringLayout.WEST, panelDeBusqueda,
                5,
                SpringLayout.EAST, mainPanel);

        mainFrameLayout.putConstraint(SpringLayout.SOUTH, mainPanel,
                -5,
                SpringLayout.SOUTH, container);

        mainFrameLayout.putConstraint(SpringLayout.NORTH, panelDeBusqueda,
                5,
                SpringLayout.SOUTH, buttonPanel);

        mainFrameLayout.putConstraint(SpringLayout.EAST, panelDeBusqueda,
                -5,
                SpringLayout.EAST, container);

        mainFrameLayout.putConstraint(SpringLayout.SOUTH, panelDeBusqueda,
                -5,
                SpringLayout.SOUTH, container);

        mainFrameLayout.putConstraint(SpringLayout.NORTH, buttonPanel,
                5,
                SpringLayout.NORTH, container);

        mainFrameLayout.putConstraint(SpringLayout.WEST, buttonPanel,
                5,
                SpringLayout.WEST, container);

        mainFrameLayout.putConstraint(SpringLayout.EAST, buttonPanel,
                -5,
                SpringLayout.EAST, container);

        mainFrameLayout.putConstraint(SpringLayout.EAST, mainPanel,
                -(PanelDeBusqueda.WIDTH) - 10,
                SpringLayout.EAST, container);

    }

    private JPanel buildMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(buildTablePanel(), BorderLayout.CENTER);

        return mainPanel;
    }

    private JPanel buildTablePanel() {
        contentPane = new Tabla();
        contentPane.setOpaque(true); //content panes must be opaque

        return contentPane;
    }

    private JPanel buildButtonPanel() {
        buttonPanel = new JPanel(new GridLayout(1, 4));

        botonDeNuevoEst = new JButton(new AccionNuevoReg(main));
        setImagePosition(botonDeNuevoEst);
        buttonPanel.add(botonDeNuevoEst);

        botonEliminar = new JButton(new AccionEliminarReg(main));
        setImagePosition(botonEliminar);
        buttonPanel.add(botonEliminar);

        botonModificar = new JButton(new AccionModificarReg(main));
        setImagePosition(botonModificar);
        buttonPanel.add(botonModificar);

        botonArchIndice = new JButton(new AccionGenerarIndice(main));
        setImagePosition(botonArchIndice);
        buttonPanel.add(botonArchIndice);

        botonConsultar = new JButton(new AccionConsultarReg(main));
        setImagePosition(botonConsultar);
        buttonPanel.add(botonConsultar);

        botonImprimir = new JButton(new AccionImprimir(main));
        setImagePosition(botonImprimir);
        buttonPanel.add(botonImprimir);


        return buttonPanel;
    }

    private void setImagePosition(JButton jButton){
        jButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        jButton.setHorizontalTextPosition(AbstractButton.CENTER);
    }

    private JMenuBar buildMenuBar() {
        menuBar = new JMenuBar();

        menuBar.add(buildFile());
        menuBar.add(buildProject());

        return menuBar;
    }

    private JMenu buildFile() {
        fileMenu = new JMenu("Archivo");

        newProject = new JMenuItem(new AccionNuevoArchivo(main));
        fileMenu.add(newProject);

        openProject = new JMenuItem(new AccionAbrirArchivo(main));
        fileMenu.add(openProject);

        fileMenu.add(new JSeparator());

        imprimir = new JMenuItem(new AccionImprimir(main));
        fileMenu.add(imprimir);

        return fileMenu;
    }

    private JMenu buildProject() {
        projectMenu = new JMenu("Herramientas");

        addClass= new JMenuItem(new AccionNuevoReg(main));
        projectMenu.add(addClass);

        removeClass = new JMenuItem(new AccionEliminarReg(main));
        projectMenu.add(removeClass);

        modificarEstudiante = new JMenuItem(new AccionModificarReg(main));
        projectMenu.add(modificarEstudiante);

        archivoIndice = new JMenuItem(new AccionGenerarIndice(main));
        projectMenu.add(archivoIndice);

        consultar = new JMenuItem(new AccionConsultarReg(main));
        projectMenu.add(consultar);

        return projectMenu;
    }

    public void setEnableSaveButtons(boolean enableSaveButtons) {
        consultar.setEnabled(enableSaveButtons);
        botonConsultar.setEnabled(enableSaveButtons);
        imprimir.setEnabled(enableSaveButtons);
        botonImprimir.setEnabled(enableSaveButtons);
        panelDeBusqueda.setEnabled(enableSaveButtons);
        botonModificar.setEnabled(enableSaveButtons);
        removeClass.setEnabled(enableSaveButtons);
        botonEliminar.setEnabled(enableSaveButtons);
        botonArchIndice.setEnabled(enableSaveButtons);
        archivoIndice.setEnabled(enableSaveButtons);
        modificarEstudiante.setEnabled(enableSaveButtons);

    }

    public void setEnableAddButtons(boolean enableAddButtons) {
        addClass.setEnabled(enableAddButtons);
        botonDeNuevoEst.setEnabled(enableAddButtons);

    }

    public void updateTabla(Object[][] data) {
        contentPane.refreshTable(data);
    }

    public Main getMain() {
        return main;
    }

    public static void main(String args[]) {
        new MainFrame();
    }


    public JTable getTable() {
        return contentPane.getJTable();
    }
}
