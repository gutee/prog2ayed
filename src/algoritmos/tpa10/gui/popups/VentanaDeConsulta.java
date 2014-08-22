package algoritmos.tpa10.gui.popups;

import algoritmos.tpa10.control.Main;
import algoritmos.tpa10.gui.exceptions.ComisionException;
import algoritmos.tpa10.gui.fields.CampoComision;

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
 * Date: 7/4/12
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class VentanaDeConsulta extends JDialog
        implements ActionListener, PropertyChangeListener {
    private JFrame mainFrame;
    private JPanel textPanel;
    private JTextField campoNombre;
    private CampoComision campoComision;
    private JLabel labelNombre, labelComision;
    private Main main;

    private String nombre;

    private String btnString1 = "Consultar";
    private String btnString2 = "Cancelar";

    private JOptionPane optionPane;

    public VentanaDeConsulta(JFrame aFrame, Main main, String nombre) {
        super(aFrame, true);
        mainFrame = aFrame;
        this.main = main;
        this.nombre = nombre;

        initMainStructure();
    }

    private void initMainStructure() {
        setTitle(nombre);

        //Create an array of the text and components to be displayed.
        String msgString1 = "Consultar por nombre, comision o ambas :";
        Object[] array = {msgString1, buildTextFieldPanel()};

        //Create an array specifying the number of dialog buttons
        //and their text.
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
                campoNombre.requestFocusInWindow();
            }
        });

        optionPane.addPropertyChangeListener(this);

        pack();
        mainFrame.setPreferredSize(new Dimension(250, 200));
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

        textPanel.setLayout(new GridLayout(2, 2));

        labelNombre = new JLabel("Nombre :", JLabel.LEFT);
        textPanel.add(labelNombre);
        campoNombre = initTextField("", 16);

        labelComision = new JLabel("Comision :", JLabel.LEFT);
        textPanel.add(labelComision);
        campoComision = new CampoComision();
        campoComision.addActionListener(this);
        textPanel.add(campoComision);

        return textPanel;
    }

    private JTextField initTextField(String mensaje, int largo) {
        JTextField jTextField = new JTextField(mensaje, largo);
        jTextField.addActionListener(this);
        textPanel.add(jTextField);

        return jTextField;
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
        if(!campoNombre.getText().replaceAll(" ","").equals("")){
            setVisible(false);
            try {
                main.consultar(campoNombre.getText(),campoComision.getChar());
            } catch (ComisionException e) {
                main.consultar(campoNombre.getText());
            }
            closeFrame();
        } else {
            try {
                main.consultar(campoComision.getChar());
                closeFrame();
            } catch (ComisionException e) {
                new ErrorFrame(new JFrame(), "Error", "Debe completar el nombre\n" +
                        "o la comision.");
                setVisible(true);
            }
        }

    }

}
