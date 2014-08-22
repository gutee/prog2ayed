package algoritmos.tpa10.control.action;

import algoritmos.tpa10.control.ImpresorDeTablas;
import algoritmos.tpa10.control.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 7/4/12
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccionImprimir extends Accion{
    JTable table;
    String fileName;

    public AccionImprimir(Main main) {
        super(main);

    }

    protected void initParameters() {
        super.putValue(Action.NAME,"Imprimir");
        imageIcon = new ImageIcon("src//algoritmos//tpa10//gui//icons//impresora.png");
        Image smallIcon = imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        super.putValue(Action.SMALL_ICON, new ImageIcon(smallIcon));
        super.putValue(Action.LARGE_ICON_KEY, imageIcon);
        super.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        super.putValue(Action.SHORT_DESCRIPTION,"Imprime la tabla");

    }

    public void actionPerformed(ActionEvent e) {
        table = main.getTable();
        fileName = main.getFileName();
        ImpresorDeTablas.imprimirTabla(table,"Tabla De Alumnos (" + fileName  +" )");
        }
}
