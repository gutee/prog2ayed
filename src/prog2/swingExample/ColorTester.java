package prog2.swingExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 11/11/11
 * Time: 09:52
 * To change this template use File | Settings | File Templates.
 */
public class ColorTester {
    public JPanel buildPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 30, 30));
        panel.add(buildTextFieldPanel());
        panel.add(buildRadioButtonPanel());
        panel.add(buildButtonPanel());
        return panel;
    }

    public JPanel buildButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 15, 15));
        JButton accept = new JButton("Accept");
        JButton cancel = new JButton("Cancel");
        buttonPanel.add(accept);
        buttonPanel.add(cancel);
        accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeColor();
            }
        });
        return buttonPanel;
    }

    private void changeColor() {

    }

    public JPanel buildRadioButtonPanel() {
        JPanel radioButtonPanel = new JPanel(new GridLayout(1, 3, 10, 10)); //1 fila, 2 columnas, 15 pixels por 15 pixels de espacio
        JRadioButton rgb = new JRadioButton("RGB");
        JRadioButton rgb2 = new JRadioButton("R,G,B");
        JRadioButton text = new JRadioButton("Text");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rgb);
        buttonGroup.add(rgb2);
        buttonGroup.add(text);
        radioButtonPanel.add(rgb);
        radioButtonPanel.add(rgb2);
        radioButtonPanel.add(text);
        return radioButtonPanel;
    }

    public JPanel buildTextFieldPanel() {
        JPanel textPanel = new JPanel();
        JTextField textField = new JTextField("type rgb value here");
        textPanel.add(textField, BorderLayout.SOUTH);
        return textPanel;
    }

    public JFrame buildFrame() {
        JFrame frame = new JFrame("SuperColorTester");
        frame.add(buildPanel());
        frame.pack();
        return frame;
    }

    public static void main(String[] args) {
        JFrame frame = new ColorTester().buildFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}