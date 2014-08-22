package algoritmos.tpa8.gui;

import algoritmos.tpa8.model.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/23/12
 * Time: 12:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainFrame implements /*ListSelectionListener,*/ ActionListener {
    JFrame jFrame;
    TextPanel textPanel;
    //JList list;
    //JScrollPane listScroll;
    String[] strings = {};
    Dictionary dictionary;
    //boolean modifyWord = true;
    JPopupMenu jPopupMenu;

    public MainFrame() {
        jFrame = new JFrame("Trabajo Práctico 8");

        dictionary = new Dictionary();
        dictionary.inicializar();

        initMainFrame();

        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    private JFrame initMainFrame() {
        //SpringLayout springLayout = new SpringLayout();
        jFrame.setLayout(new BorderLayout());

        textPanel = new TextPanel(this);
        jFrame.add(textPanel,BorderLayout.CENTER);
        //jFrame.add(initListScroll());


        //configMainFrameLayout(springLayout);

        return jFrame;
    }

    /*public Point getPosition(){
        return new Point(jFrame.getX(),jFrame.getY());
    }*/

    /*private void configMainFrameLayout(SpringLayout mainFrameLayout) {
        Container container = jFrame.getContentPane();

        mainFrameLayout.putConstraint(SpringLayout.WEST, textPanel,
                5,
                SpringLayout.WEST, container);

        mainFrameLayout.putConstraint(SpringLayout.NORTH, textPanel,
                5,
                SpringLayout.NORTH, container);

        mainFrameLayout.putConstraint(SpringLayout.SOUTH, textPanel,
                -5,
                SpringLayout.SOUTH, container);

        mainFrameLayout.putConstraint(SpringLayout.EAST, textPanel,
                -50,
                SpringLayout.EAST, container);

        mainFrameLayout.putConstraint(SpringLayout.EAST, textPanel,
                -5,
                SpringLayout.WEST, listScroll);

        mainFrameLayout.putConstraint(SpringLayout.NORTH, listScroll,
                5,
                SpringLayout.NORTH, container);

        mainFrameLayout.putConstraint(SpringLayout.EAST, listScroll,
                -5,
                SpringLayout.EAST, container);

        mainFrameLayout.putConstraint(SpringLayout.SOUTH, listScroll,
                -5,
                SpringLayout.SOUTH, container);

    }  */

   /* private JScrollPane initListScroll() {
        listScroll = new JScrollPane(initList());

        return listScroll;
    }

    /*private JList initList() {
        list = new JList(strings);
        list.setMaximumSize(new Dimension(40, -1));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(this);

        return list;
    }  */

    public void setWordsMenu(String[] strings){
        jPopupMenu = new JPopupMenu();
        for (String string: strings){
            JMenuItem menuItem = new JMenuItem(string);
            menuItem.addActionListener(this);
            jPopupMenu.add(menuItem);
        }
    }

    public JPopupMenu getWordsMenu(){
        return jPopupMenu;
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    public void chageList(String word) {
        if (word != null) {
            strings = dictionary.buscarPalabrasPor(word);
            if (strings != null) {
                setWordsMenu(strings);
            }
        }

    }

    boolean existeLaPalabra(String palabra){
        return dictionary.existeLaPalabra(palabra);
    }

    public void actionPerformed(ActionEvent e) {
        textPanel.replaceWord(((JMenuItem) e.getSource()).getText());
    }
}
