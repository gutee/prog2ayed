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
 * User: Martin Gutierrez
 * Date: 05/06/12
 * Time: 14:17
 */
public class AccionNuevoArchivo extends Accion {

    private final OpenFileChooser fileChooser;

    private final static String NAME = "Nuevo Archivo";

    public AccionNuevoArchivo(Main main1) {
        super(main1);
        fileChooser = new OpenFileChooser(NAME, new REGExtensionFilter(), JFileChooser.OPEN_DIALOG);
    }

    protected void initParameters() {
        super.putValue(Action.NAME,"Nuevo Archivo");
        imageIcon = new ImageIcon("src//algoritmos//tpa10//gui//icons//new file.png");
        Image smallIcon = imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        super.putValue(Action.SMALL_ICON, new ImageIcon(smallIcon));
        super.putValue(Action.LARGE_ICON_KEY, imageIcon);
        super.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        super.putValue(Action.SHORT_DESCRIPTION,"Crea un nuevo archivo");

    }


    public void actionPerformed(ActionEvent e) {
        //Handle open button action.

        int returnVal = fileChooser.showDialog(new JPanel(), NAME);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println(file.getAbsolutePath());
            main.nuevoArchivo(file.getAbsolutePath());
        }


    }
}
