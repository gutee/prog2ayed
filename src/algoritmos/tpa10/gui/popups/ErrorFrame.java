package algoritmos.tpa10.gui.popups;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/5/12
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class ErrorFrame extends JDialog {

    public ErrorFrame(Frame aFrame, String name, String message) {
        super(aFrame, true);

        JOptionPane.showMessageDialog(aFrame, message, name, JOptionPane.ERROR_MESSAGE);

    }
}


