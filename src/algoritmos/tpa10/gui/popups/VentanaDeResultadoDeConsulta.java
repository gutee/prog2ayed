package algoritmos.tpa10.gui.popups;

import algoritmos.tpa10.control.ImpresorDeTablas;
import algoritmos.tpa10.gui.Tabla;
import algoritmos.tpa10.gui.exceptions.NoResultadoException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 7/4/12
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class VentanaDeResultadoDeConsulta extends JDialog
        implements ActionListener, PropertyChangeListener {
    private JFrame mainFrame;
    private Tabla tabla;

    private static String nombre = "Resultados";
    private String mensaje = "Los resultados a su consulta son:" ;

    private JOptionPane optionPane;

    private static String btnString2 = "Imprimir";
    private static String btnString1 = "Aceptar";


    public VentanaDeResultadoDeConsulta(JFrame jFrame, Tabla tabla) throws NoResultadoException {
        super(jFrame, true);
        this.mainFrame = jFrame;
        if (tabla != null){
            this.tabla = tabla;
        }else {
            throw new NoResultadoException();
        }

        initMainStructure();
    }

    private void initMainStructure() {
        setTitle(nombre);

        Object[] array = {mensaje,tabla};
        Object[] options = {btnString1, btnString2};

        //Create the JOptionPane.
        optionPane = new JOptionPane(array,
                JOptionPane.DEFAULT_OPTION,
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
            if (btnString2.equals(value)) {
                actionToDo();
            } else { //user closed dialog or clicked cancel
                closeFrame();
            }
        }
    }

    private void actionToDo() {
        ImpresorDeTablas.imprimirTabla(tabla.getJTable(), "Resultado de la Busqueda :");
        closeFrame();
    }
}
