package prog2.tp5Serialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 04/11/11
 * Time: 10:29
 * To change this template use File | Settings | File Templates.
 */
public class VendingMachine implements Serializable {
    ArrayList<Beverages> inventoryList;

    VendingMachine() {
        inventoryList = new ArrayList<Beverages>();
    }

    public ArrayList createInventory() {
        for (int i = 0; i < 10; i++) {
            inventoryList.add(new Coke());
        }
        for (int i = 0; i < 10; i++) {
            inventoryList.add(new Sprite());
        }
        for (int i = 0; i < 10; i++) {
            inventoryList.add(new Fanta());
        }
        return inventoryList;
    }

    public void giveCoke() {
        inventoryList.remove(inventoryList.indexOf(new Coke()) + 1);
    }

    public void giveSprite() {
        inventoryList.remove(inventoryList.indexOf(new Sprite()) + 1);
    }

    public void giveFanta() {
        inventoryList.remove(inventoryList.indexOf(new Fanta()) + 1);
    }

    public void showInventory() {
        for (int i = 1; i <= inventoryList.size(); i++) {
            System.out.println(i + "\t" + ((Beverages) inventoryList.get(i - 1)).getName());
        }
    }

    public void start() {
        for (int i = 0; i < inventoryList.size(); i++) {
            System.out.println("\t What do you wanna do? \n\n1. \t Coke \n2. \t Sprite \n3. \t Fanta");
            System.out.println("4. \t Show Inventory");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case (1):
                    giveCoke();
                    System.out.println("There's your Coke");
                    break;
                case (2):
                    giveSprite();
                    System.out.println("There's your Sprite");
                    break;
                case (3):
                    giveFanta();
                    System.out.println("There's your Fanta");
                    break;
                case (4):
                    showInventory();
                    break;
            }
        }
    }
}
