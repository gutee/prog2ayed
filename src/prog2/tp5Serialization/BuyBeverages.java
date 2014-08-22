package prog2.tp5Serialization;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 04/11/11
 * Time: 11:39
 * To change this template use File | Settings | File Templates.
 */
public class BuyBeverages {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.createInventory();
        vendingMachine.start();
        guardar(vendingMachine);

    }

    private static VendingMachine leer() {
        VendingMachine vendingMachine = null;
        try {
            FileInputStream fis = new FileInputStream("VendingMachine.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            vendingMachine = (VendingMachine) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return vendingMachine;
    }

    private static void guardar(VendingMachine vendingMachine) {
        try {
            File file = new File("VendingMachine.ser");
            System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(file);       //pone nombre al archivo (S)
            ObjectOutputStream oos = new ObjectOutputStream(fos);    //lo pone en un objeto
            oos.writeObject(vendingMachine);                                  //escribe en el disco con el nombre s
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}