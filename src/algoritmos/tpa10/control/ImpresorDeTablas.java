package algoritmos.tpa10.control;

import algoritmos.tpa10.gui.popups.ErrorFrame;

import javax.swing.*;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 7/4/12
 * Time: 11:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImpresorDeTablas {

    public static void imprimirTabla(JTable jTable, String titulo){
        try {
              MessageFormat headerFormat = new MessageFormat(titulo);
              MessageFormat footerFormat = new MessageFormat("- {0} -");
              jTable.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
            } catch (PrinterException pe) {
              new ErrorFrame(new JFrame(),"Error","Error printing: " + pe.getMessage());
            }

    }
}
