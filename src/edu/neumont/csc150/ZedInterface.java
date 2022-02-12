package edu.neumont.csc150;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZedInterface {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void displayGenerateMenu(){
        System.out.println("\n\nWhat would you like to do?\r\n" +
                "\t1 - Generate 1 Zed\r\n" +
                "\t2 - Generate some Zeds\r\n" +
                "\t3 - Generate n Zeds\r\n" +
                "\t4 - Exit\r\n");
    }

    public int getN() throws IOException {
        System.out.println("How many zeds would you like us to produce?");
        int n = getUserInputAsInt(1, Integer.MAX_VALUE);
        return n;
    }

    public int getUserInputAsInt(int min, int max) throws IOException {
        float value = getUserInputAsFloat(min, max);

        return (int) value;
    }
    public float getUserInputAsFloat(float min, float max) throws IOException {
        float input = 0;
        do {
            String line = in.readLine();
            try {
                input = Float.parseFloat(line);
                if (input < min || input > max) {
                    throw new NumberFormatException("out of range");
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Input invalid. " +
                        "You must enter a number between " + min + " and " + max);
            }
        } while (true);
        return input;
    }
}
