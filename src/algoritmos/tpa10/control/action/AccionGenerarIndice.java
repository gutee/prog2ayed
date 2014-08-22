package algoritmos.tpa10.control.action;

import algoritmos.tpa10.control.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * User: Martin Gutierrez
 * Date: 05/06/12
 * Time: 13:45
 */
public class AccionGenerarIndice extends Accion {
    public AccionGenerarIndice(Main main) {
        super(main);
    }

    protected void initParameters() {
        super.putValue(Action.NAME,"Generar Archivo Indice");
        imageIcon = new ImageIcon("src//algoritmos//tpa10//gui//icons//type-list.png");
        Image smallIcon = imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        super.putValue(Action.SMALL_ICON, new ImageIcon(smallIcon));
        super.putValue(Action.LARGE_ICON_KEY, imageIcon);
        super.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        super.putValue(Action.SHORT_DESCRIPTION,"Genera un archivo indice\n del Archivo");

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        main.generarIndice();
    }
}
