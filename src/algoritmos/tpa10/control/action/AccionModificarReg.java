package algoritmos.tpa10.control.action;

import algoritmos.tpa10.control.Main;
import algoritmos.tpa10.gui.popups.VentanaDeBusquedaDeMatricula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * User: Martin Gutierrez
 * Date: 05/06/12
 * Time: 13:38
 */
public class AccionModificarReg extends Accion {
    public AccionModificarReg(Main main) {
        super(main);
    }

    protected void initParameters() {
        super.putValue(Action.NAME,"Modificar Estudiante");
        imageIcon = new ImageIcon("src//algoritmos//tpa10//gui//icons//edit-icon.png");
        Image smallIcon = imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        super.putValue(Action.SMALL_ICON, new ImageIcon(smallIcon));
        super.putValue(Action.LARGE_ICON_KEY, imageIcon);
        super.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        super.putValue(Action.SHORT_DESCRIPTION,"Modifica un estudiante\n a partir de la Matricula");

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        new VentanaDeBusquedaDeMatricula(new JFrame(), main, VentanaDeBusquedaDeMatricula.MODIFICACION, "Modificar estudiante", "Matricula del estudiante :");
    }
}
