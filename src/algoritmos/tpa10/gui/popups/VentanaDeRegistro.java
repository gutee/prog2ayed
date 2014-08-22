package algoritmos.tpa10.gui.popups;

import algoritmos.tpa10.control.Main;
import algoritmos.tpa10.gui.exceptions.*;
import algoritmos.tpa10.gui.fields.CampoComision;
import algoritmos.tpa10.gui.fields.CampoMatricula;
import algoritmos.tpa10.model.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * User: Martin Gutierrez
 * Date: 05/06/12
 * Time: 15:56
 */

public class VentanaDeRegistro extends JDialog
        implements ActionListener, PropertyChangeListener {
    private JFrame mainFrame;
    private JPanel textPanel;
    private JTextField campoNombre;
    private CampoComision campoComision;
    private CampoMatricula campoMatricula;
    private JLabel labelNombre, labelMatricula, labelComision;
    private Main main;

    private int tipo;
    private String nombre;

    int matriculaVieja;

    private String nombreA;
    private String matriculaA;
    private String comisionA;


    public final static int INSERCION = -1;
    public final static int MODIFICACION = -2;

    private String btnString1 = "Aceptar";
    private String btnString2 = "Cancelar";

    private JOptionPane optionPane;

    public VentanaDeRegistro(JFrame aFrame, Main main, int tipo, String nombre, Estudiante estudiante, int matriculaVieja) {
        super(aFrame, true);
        mainFrame = aFrame;
        this.matriculaVieja = matriculaVieja;
        this.main = main;
        this.tipo = tipo;
        this.nombre = nombre;

        nombreA = estudiante.getNombreApellido();
        matriculaA = String.valueOf(estudiante.getMatricula());
        comisionA = String.valueOf(estudiante.getComision());

        initMainStructure();
    }

    public VentanaDeRegistro(JFrame aFrame, Main main, int tipo, String nombre) {
        super(aFrame, true);
        mainFrame = aFrame;
        this.main = main;
        this.tipo = tipo;
        this.nombre = nombre;

        nombreA = "Nombre y Apellido";
        matriculaA = "Matricula";
        comisionA = "A";

        initMainStructure();
    }

    private void initMainStructure() {
        setTitle(nombre);

        //Create an array of the text and components to be displayed.
        String msgString1 = "Datos del Estudiante";
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

        textPanel.setLayout(new GridLayout(3, 2));

        labelNombre = new JLabel("Nombre :", JLabel.LEFT);
        textPanel.add(labelNombre);
        campoNombre = initTextField(nombreA, 16);

        labelMatricula = new JLabel("Matricula :", JLabel.LEFT);
        textPanel.add(labelMatricula);
        campoMatricula = new CampoMatricula(matriculaA);
        campoMatricula.addActionListener(this);
        campoMatricula.setColumns(16);
        textPanel.add(campoMatricula);

        labelComision = new JLabel("Comision :", JLabel.LEFT);
        textPanel.add(labelComision);
        campoComision = new CampoComision(comisionA.charAt(0));
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
        try{
        if (campoMatricula.getValue() > 999) {
                    Estudiante estudiante = new Estudiante(false, campoMatricula.getValue(), campoComision.getChar(),
                            campoNombre.getText());
                    if (tipo == INSERCION) {
                        main.agregar(estudiante);
                    } else if (tipo == MODIFICACION) {
                        main.sobrescribir(matriculaVieja, estudiante);
                    }
                    closeFrame();
                } else {
                    throw new Matricula4NumbersException();
                }
        } catch (NombreNoCompletoException e){
            new ErrorFrame(new JFrame(),"Error", e.getMessage());
        } catch (MatriculaYaExisteException e){
            new ErrorFrame(new JFrame(),"Error", e.getMessage());
        } catch (ComisionException e){
            new ErrorFrame(new JFrame(),"Error", e.getMessage());
        } catch (Matricula4NumbersException e){
            new ErrorFrame(new JFrame(),"Error", e.getMessage());
        } catch (ÑException e){
            new ErrorFrame(new JFrame(),"Error", e.getMessage());
        }
    }
}