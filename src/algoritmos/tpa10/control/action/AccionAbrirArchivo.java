package algoritmos.tpa10.control.action;

import algoritmos.tpa10.control.Main;
import algoritmos.tpa10.gui.OpenFileChooser;
import algoritmos.tpa10.gui.extension.REGExtensionFilter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/19/12
 * Time: 1:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class AccionAbrirArchivo extends Accion {

    private final OpenFileChooser fileChooser;

    private final static String NAME = "Abrir Archivo";

    public AccionAbrirArchivo(Main main1) {
        super(main1);
        fileChooser = new OpenFileChooser(NAME, new REGExtensionFilter(), JFileChooser.OPEN_DIALOG);

    }

    @Override
    protected void initParameters() {
        super.putValue(Action.NAME,"Abrir Archivo");
        imageIcon = new ImageIcon("src//algoritmos//tpa10//gui//icons//open.png");
        Image smallIcon = imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        super.putValue(Action.SMALL_ICON, new ImageIcon(smallIcon));
        super.putValue(Action.LARGE_ICON_KEY, imageIcon);
        super.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        super.putValue(Action.SHORT_DESCRIPTION,"Abre un archivo existente");

    }

    public void actionPerformed(ActionEvent e) {
        //Handle open button action.

        int returnVal = fileChooser.showDialog(new JPanel(), NAME);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println(file.getAbsolutePath());
            main.abrirArchivo(file.getAbsolutePath());
        }


    }
}
