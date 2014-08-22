package algoritmos.tpa10.gui.fields;

import algoritmos.tpa10.gui.exceptions.ComisionException;
import algoritmos.tpa10.gui.popups.ErrorFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/21/12
 * Time: 12:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class CampoComision extends JPanel implements KeyListener {
    private JTextField textField;

    public CampoComision(){
        textField = new JTextField("", 1);
        initField();
    }

    public CampoComision(char character) {
        super(new BorderLayout());

        textField = new JTextField(String.valueOf(character), 1);
        initField();

    }

    private  void initField(){
        textField.addKeyListener(this);

        JPanel jPanel = new JPanel();

        add(textField, BorderLayout.WEST);
        add(jPanel, BorderLayout.CENTER);
    }

    public char getChar()throws ComisionException {
        try {
            return textField.getText().charAt(0);
        } catch (StringIndexOutOfBoundsException e) {
            throw new ComisionException();
        }

    }

    public void addActionListener(ActionListener actionListener) {
        textField.addActionListener(actionListener);
    }

    public void keyTyped(KeyEvent e) {
        if (textField.getText().length() < 1) {
            char character = e.getKeyChar();
            try {
                processCharacter(e, character);
            } catch (ComisionException e1) {
                new ErrorFrame(new JFrame(),"Error",e1.getMessage());
            }
        } else {
            e.consume();
        }
    }

    private void processCharacter(KeyEvent e, char character) throws ComisionException {
        if (((character >= 'A' && character <= 'Z')
                || ((int) character == KeyEvent.VK_DELETE)
                || ((int) character == KeyEvent.VK_BACK_SPACE)
                || ((int) character == KeyEvent.VK_ENTER)
                || ((int) character == KeyEvent.VK_TAB))) {

        } else if ((character >= 'a' && character <= 'z')) {
            e.consume();
            textField.setText(String.valueOf(Character.valueOf((char) (character - 32))));
        } else {
            e.consume();
            throw new ComisionException();
        }
    }

    public void keyPressed(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void keyReleased(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
