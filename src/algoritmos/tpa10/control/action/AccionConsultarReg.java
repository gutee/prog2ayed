package algoritmos.tpa10.control.action;

import algoritmos.tpa10.control.Main;
import algoritmos.tpa10.gui.popups.VentanaDeConsulta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * User: Martin Gutierrez
 * Date: 05/06/12
 * Time: 13:44
 */
public class AccionConsultarReg extends Accion {

    public AccionConsultarReg(Main main) {
        super(main);
    }

    protected void initParameters() {
        super.putValue(Action.NAME,"Consultar");
        imageIcon = new ImageIcon("src//algoritmos//tpa10//gui//icons//Search (1).png");
        Image smallIcon = imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        super.putValue(Action.SMALL_ICON, new ImageIcon(smallIcon));
        super.putValue(Action.LARGE_ICON_KEY, imageIcon);
        super.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        super.putValue(Action.SHORT_DESCRIPTION,"Buscar todos los estudiante\n con cierta condicion");

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        new VentanaDeConsulta(new JFrame(),main,"Ventana De Consulta");
    }
}
