package algoritmos.tpa10.gui;

import javax.swing.table.AbstractTableModel;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 6/5/12
 * Time: 10:16 PM
 * To change this template use File | Settings | File Templates.
 */
class TableModel extends AbstractTableModel {
    final static String[] COLUMN_NAMES = {"Nombre y Apellido",
            "Comision",
            "Matricula"};

    private Object[][] data;

    TableModel(Object[][] data) {
        this.data = data;
    }


    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return COLUMN_NAMES[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }


    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }


}
