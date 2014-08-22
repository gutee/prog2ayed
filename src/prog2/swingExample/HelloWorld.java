package prog2.swingExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 04/11/11
 * Time: 09:30
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld implements ActionListener {

    public JPanel buildPanel() {
        JPanel panel = new JPanel(new BorderLayout());   // o panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Hello World");
        panel.add(label);
        JButton ok = new JButton("Ok");
        ok.setActionCommand("Ok");
        ok.addActionListener(this);
        panel.add(ok, BorderLayout.SOUTH);
        return panel;
    }

    public JFrame buildFrame() {
        JFrame frame = new JFrame("Hello World Application");
        frame.add(buildPanel());
        frame.pack();
        return frame;
    }

    public static void main(String[] args) {
        JFrame frame = new HelloWorld().buildFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Ok")) {
            System.exit(0);
        }
    }
}
