package algoritmos.tpa10.control.action;

import algoritmos.tpa10.control.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * User: Martin Gutierrez
 * Date: 05/06/12
 * Time: 13:57
 */
public abstract class Accion extends AbstractAction {
    protected Main main;
    protected ImageIcon imageIcon;

    public Accion(Main main) {
        this.main = main;
        initParameters();
    }

    protected abstract void initParameters();

    public abstract void actionPerformed(ActionEvent actionEvent);
}
