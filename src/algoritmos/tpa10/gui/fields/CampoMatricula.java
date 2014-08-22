package algoritmos.tpa10.gui.fields;

import algoritmos.tpa10.gui.exceptions.Matricula4NumbersException;
import algoritmos.tpa10.gui.popups.ErrorFrame;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/20/12
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class CampoMatricula extends JTextField implements KeyListener, FocusListener {

    public CampoMatricula(String initialText) {
        super(initialText, 4);

        addKeyListener(this);
        addFocusListener(this);
    }

    public int getValue() throws Matricula4NumbersException {
        if (!isInteger(getText()) || Integer.valueOf(getText()) <= 999) {
            throw new Matricula4NumbersException();
        }
        return Integer.valueOf(getText());
    }

    public void keyTyped(KeyEvent e) {
        char caracter = e.getKeyChar();
        try {
            processCharacter(e, caracter);
        } catch (Matricula4NumbersException e1) {
            new ErrorFrame(new JFrame(),"Error",e1.getMessage());
        }
    }

    private void processCharacter(KeyEvent e, char caracter) throws Matricula4NumbersException {
        if (((int) caracter != KeyEvent.VK_BACK_SPACE)
                && ((int) caracter != KeyEvent.VK_DELETE)
                && ((int) caracter != KeyEvent.VK_ENTER)
                && ((int) caracter != KeyEvent.VK_INSERT)
                && ((int) caracter != KeyEvent.VK_TAB)) {
            if (getText().length() < 4) {
                if (caracter < '0' || caracter > '9') {
                    e.consume();
                    throw new Matricula4NumbersException();
                }
            } else {
                e.consume();
                throw new Matricula4NumbersException();
            }
        }
    }


    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void focusGained(FocusEvent e) {
        if (!isInteger(getText())) {
            setText("");
        }
    }

    private boolean isInteger(String text) {
        try {
            Integer.valueOf(text);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void focusLost(FocusEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
