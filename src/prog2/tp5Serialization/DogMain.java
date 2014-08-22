package prog2.tp5Serialization;

import java.io.*;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 09/11/11
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */
public class DogMain {
    public static void main(String[] args) {
        System.out.println("Nombre?");
        Scanner scanner = new Scanner(System.in);
        Dog dog = new Dog(scanner.next());
        System.out.println("El nombre del perro es " + dog.getName());
        guardar(dog);
        dog.setName("Roberto");
        System.out.println("El nombre del perro es " + dog.getName());
        dog = leer(dog);
        System.out.println("El nombre del perro es " + dog.getName());
    }

    private static Dog leer(Dog dog) {
        try {
            FileInputStream fis = new FileInputStream("Dog.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dog = (Dog) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return dog;
    }

    private static void guardar(Dog dog) {
        try {
            File file = new File("Dog.ser");
            System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(file);       //pone nombre al archivo (S)
            ObjectOutputStream oos = new ObjectOutputStream(fos);    //lo pone en un objeto
            oos.writeObject(dog);                                  //escribe en el disco con el nombre s
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}