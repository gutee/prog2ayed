package algoritmos.tpa8.gui;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/23/12
 * Time: 6:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class TextPanel extends JPanel implements CaretListener, KeyListener {
    JTextArea textArea;
    JScrollPane scrollPane;
    PopupFactory popupFactory = PopupFactory.getSharedInstance();
    Popup popup;

    JPopupMenu popupMenu = new JPopupMenu();

    MainFrame mainFrame;

    public TextPanel(MainFrame mainFrame) {
        super(new GridLayout(1, 0));
        this.mainFrame = mainFrame;

        textArea = new JTextArea(20, 20);
        textArea.addCaretListener(this);
        textArea.addKeyListener(this);

        scrollPane = new JScrollPane(textArea);

        popup = popupFactory.getPopup(textArea, new JButton(), 0, 0);

        add(scrollPane);

    }


    public void caretUpdate(CaretEvent e) {
        if (popupMenu != null) {
            popupMenu.setVisible(false);
        }

        if (textArea.getCaretPosition() >= 1) {

            int end = calcWordEnd();
            int inicio = calcWordStart();


            if (inicio <= end) {
                String palabra = textArea.getText().substring(inicio, end + 1);
                if (!mainFrame.existeLaPalabra(palabra)) {
                    mainFrame.chageList(palabra);
                    if (textArea.getCaret().getMagicCaretPosition() != null) {
                        Point point = getCaretPosition();
                        popupMenu = mainFrame.getWordsMenu();
                        popupMenu.show(textArea, (int) point.getX(), (int) point.getY());

                    }
                }
            }
        }

        textArea.requestFocusInWindow();
    }

    public Point getCaretPosition() {
        return new Point(
                (int) textArea.getCaret().getMagicCaretPosition().getX() + 7 // +
                //(int) mainFrame.getPosition().getX() + 7 +
                //scrollPane.getX()
                , (int) textArea.getCaret().getMagicCaretPosition().getY() + 16 // +
                //(int) mainFrame.getPosition().getY() + 32 +
                /*scrollPane.getY()*/);
    }

    public void replaceWord(String newWord) {
        int start = calcWordStart();
        int end = calcWordEnd();
        String newText = changeWord(textArea.getText(),
                start,
                end,
                newWord);
        textArea.setText(newText);
        textArea.setCaretPosition(start + newWord.length());
        textArea.requestFocusInWindow();
    }

    public static String changeWord(String text, int start, int end, String newWord) {
        String previusText = text.substring(0, start);

        int textLength = text.length();
        String followText = "";
        if (end + 1 < textLength) {
            followText = text.substring(end + 1, textLength);
        }
        return previusText + newWord + followText;

    }

    private int calcWordStart() {
        int caretPosition = textArea.getCaretPosition();
        int inicio = caretPosition - 1;
        char character = textArea.getText().charAt(inicio);
        while (((character >= 'a' && character <= 'z')
                || (character >= 'A' && character <= 'Z'))
                && inicio > 0) {
            inicio--;
            character = textArea.getText().charAt(inicio);
        }
        if (!((character >= 'a' && character <= 'z')
                || (character >= 'A' && character <= 'Z'))) {
            inicio++;
        }
        return inicio;
    }

    private int calcWordEnd() {
        int caretPosition = textArea.getCaretPosition();
        int end = caretPosition - 1;
        char character = textArea.getText().charAt(end);
        while (((character >= 'a' && character <= 'z')
                || (character >= 'A' && character <= 'Z'))
                && end < textArea.getText().length() - 1) {
            end++;
            character = textArea.getText().charAt(end);
        }
        if (!((character >= 'a' && character <= 'z')
                || (character >= 'A' && character <= 'Z'))) {
            end--;
        }
        return end;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }


}
