package algoritmos.tpa10.gui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;


/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 12/9/11
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class OpenFileChooser extends JFileChooser {
    String name;

    public OpenFileChooser(String name, FileFilter fileFilter, int function) {
        super();
        this.setName(name);

        setFileSelectionMode(function);
        setFileFilter(fileFilter);
    }

}