package prog2.tp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Martin Gutierrez.
 * User: Martin
 * Date: 05/09/11
 * Time: 08:07
 * To change this template use File | Settings | File Templates.
 */
public class CharInverter implements CharSequence {
    private String word;
    private String invertedWord;

    CharInverter(String word) {
        this.word = word;
    }

    public int length() {
        return word.length();
    }

    public char charAt(int index) {
        return charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return word.subSequence(start, end);
    }

    public String toString() {
        return "Original: " + word + "\nInverted: " + invertedWord;
    }

    public String invert() {
        if (invertedWord == null) {
            invertedWord = "";
            for (int i = length() - 1; i >= 0; i--) {
                invertedWord += word.charAt(i);
                //System.out.println("invertedWord = " + invertedWord);
            }
        }
        return invertedWord;
    }

    public static void main(String[] args) throws IOException {
        String word = readInputFromKeyboard();
        CharInverter inverter = new CharInverter(word);
        inverter.invert();
        System.out.println(inverter);
    }

    private static String readInputFromKeyboard() throws IOException {
        System.out.println("Ingresa la palabra a invertir: \n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}