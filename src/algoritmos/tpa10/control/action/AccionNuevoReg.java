package algoritmos.tpa10.control.action;

import algoritmos.tpa10.control.Main;
import algoritmos.tpa10.gui.popups.VentanaDeRegistro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * User: Martin Gutierrez
 * Date: 05/06/12
 * Time: 13:36
 */
public class AccionNuevoReg extends Accion {

    public AccionNuevoReg(Main main1) {
        super(main1);

    }

    protected void initParameters() {
        super.putValue(Action.NAME,"Nuevo Estudiante");
        imageIcon = new ImageIcon("src//algoritmos//tpa10//gui//icons//contact-new.png");
        Image smallIcon = imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        super.putValue(Action.SMALL_ICON, new ImageIcon(smallIcon));
        super.putValue(Action.LARGE_ICON_KEY, imageIcon);
        super.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        super.putValue(Action.SHORT_DESCRIPTION,"Crea un nuevo Estudiante");

    }


    public void actionPerformed(ActionEvent e) {
        new VentanaDeRegistro(new JFrame(), main, VentanaDeRegistro.INSERCION, "Nuevo Estudiante");

    }

}
