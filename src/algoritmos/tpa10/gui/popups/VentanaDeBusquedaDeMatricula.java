package algoritmos.tpa10.gui.popups;

import algoritmos.tpa10.control.Main;
import algoritmos.tpa10.gui.exceptions.Matricula4NumbersException;
import algoritmos.tpa10.gui.exceptions.MatriculaNoExisteException;
import algoritmos.tpa10.gui.fields.CampoMatricula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/5/12
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class VentanaDeBusquedaDeMatricula extends JDialog
        implements ActionListener, PropertyChangeListener {
    private JFrame mainFrame;
    private JPanel textPanel;
    private CampoMatricula campoMatricula;
    private JLabel labelNombre;
    private Main main;

    private int tipo;
    private String nombre;
    private String mensaje;

    private JOptionPane optionPane;

    private static String btnString1 = "Aceptar";
    private static String btnString2 = "Cancelar";


    public final static int ELIMINACION = -1;
    public final static int MODIFICACION = -2;

    public VentanaDeBusquedaDeMatricula(JFrame jFrame, Main main, int tipo, String nombre, String mensaje) {
        super(jFrame, true);
        this.mainFrame = jFrame;
        this.main = main;
        this.tipo = tipo;
        this.nombre = nombre;
        this.mensaje = mensaje;

        initMainStructure();
    }

    private void initMainStructure() {
        setTitle(nombre);

        Object[] array = {buildTextFieldPanel()};
        Object[] options = {btnString1, btnString2};

        //Create the JOptionPane.
        optionPane = new JOptionPane(array,
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                null,
                options,
                options[0]);

        //Make this dialog display it.
        setContentPane(optionPane);

        //Handle window closing correctly.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Ensure the text field always gets the first focus.
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent ce) {
                optionPane.requestFocusInWindow();
            }
        });

        optionPane.addPropertyChangeListener(this);

        pack();
        setPreferredSize(new Dimension(250, 200));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void closeFrame() {
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }

    private JPanel buildTextFieldPanel() {
        textPanel = new JPanel();
        textPanel.setSize(100, 100);
        textPanel.setLayout(new GridLayout(2, 1));

        labelNombre = new JLabel(mensaje, JLabel.CENTER);
        campoMatricula = new CampoMatricula("Matricula");
        campoMatricula.addActionListener(this);
        textPanel.add(labelNombre);
        textPanel.add(campoMatricula);


        return textPanel;
    }


    public void actionPerformed(ActionEvent e) {
        actionToDo();
    }

    public void propertyChange(PropertyChangeEvent e) {
        String prop = e.getPropertyName();

        if (isVisible()
                && (e.getSource() == optionPane)
                && (JOptionPane.VALUE_PROPERTY.equals(prop) ||
                JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
            Object value = optionPane.getValue();

            if (value == JOptionPane.UNINITIALIZED_VALUE) {
                //ignore reset
                return;
            }

            optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);
            if (btnString1.equals(value)) {
                actionToDo();
            } else { //user closed dialog or clicked cancel
                closeFrame();
            }
        }
    }

    private void actionToDo() {
        try {
            mainFrame.setVisible(false);
            if (tipo == ELIMINACION) {
                main.eliminar(campoMatricula.getValue());
            } else if (tipo == MODIFICACION) {
                main.modificar(campoMatricula.getValue());
            }
            closeFrame();
        } catch (Matricula4NumbersException e) {
            new ErrorFrame(new JFrame(), "Error", e.getMessage());
            setVisible(true);
        } catch (MatriculaNoExisteException e) {
            new ErrorFrame(new JFrame(), "Error", e.getMessage());
            campoMatricula.setText("");
            setVisible(true);
        }
    }
}
