package prog2.swingExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 11/11/11
 * Time: 09:11
 * To change this template use File | Settings | File Templates.
 */
public class ColorChooser {
    public JPanel buildPanel() {
        final JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));   //si se accede de un inner class debe ser final
        final JPanel panel = new JPanel(new BorderLayout());
        JButton red = new JButton("Red");
        JButton green = new JButton("Green");
        JButton blue = new JButton("Blue");
        red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {       //clase anonima, uso una sola vez
                buttonPanel.setBackground(Color.RED);
                panel.setBackground(Color.RED);
            }
        });
        green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setBackground(Color.GREEN);
                panel.setBackground(Color.GREEN);
            }
        });
        blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setBackground(Color.BLUE);
                panel.setBackground(Color.BLUE);
            }
        });
        buttonPanel.add(red);
        buttonPanel.add(green);
        buttonPanel.add(blue);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(Box.createVerticalStrut(120));
        return panel;
    }

    public JFrame buildFrame() {
        JFrame frame = new JFrame("Color Chooser");
        frame.add(buildPanel());
        frame.pack();
        return frame;
    }

    public static void main(String[] args) {
        JFrame frame = new ColorChooser().buildFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
