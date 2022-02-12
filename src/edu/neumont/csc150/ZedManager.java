package edu.neumont.csc150;

import java.io.IOException;

public class ZedManager {
    public static void main(String[] args) throws IOException {
        ZedGenerator zgc = new ZedGenerator();
        zgc.run();
        System.out.println("Program Ended Successfully");
    }
}
