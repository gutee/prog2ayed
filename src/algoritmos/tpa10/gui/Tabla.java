package algoritmos.tpa10.gui;

import javax.swing.*;
import java.awt.*;

public class Tabla extends JPanel {
    private JTable jTable;


    public Tabla() {
        super(new GridLayout(1, 0));

        Object[][] data = {};

        jTable = new JTable(new TableModel(data));
        /*jTable.setPreferredScrollableViewportSize(new Dimension(500, 70));  */

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(jTable);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }



    public void refreshTable(Object[][] data) {

        TableModel tableModel = new TableModel(data);
        jTable.setModel(tableModel);


        //JTable.setFillsViewportHeight(true);
    }


    public JTable getJTable() {
        return jTable;
    }
}
