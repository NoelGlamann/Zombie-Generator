package edu.neumont.csc150;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


/*
Functions as Generator Class
 */
public class ZedGenerator {
    private Random random = new Random();
    private ZedInterface zgi = new ZedInterface();
    private ArrayList<Zombie> horde = new ArrayList<>();

    public void run() throws IOException {
        while(true){
            zgi.displayGenerateMenu();
            int selection = zgi.getUserInputAsInt(1,4);
            switch (selection) {
                case 1 -> {
                    horde.clear();
                    generateZed(1);
                    displayHorde(horde);
                    break;
                }
                case 2 -> {
                    horde.clear();
                    int numOfZeds = random.nextInt(1, 11);
                    generateZed(numOfZeds);
                    displayHorde(horde);
                    break;
                }
                case 3 -> {
                    horde.clear();
                    generateZed(zgi.getN());
                    displayHorde(horde);
                    break;
                }
                case 4 -> {
                    return;
                }
                default -> throw new IllegalArgumentException("unknown menu item\n");
            }
        }
    }

    private void generateZed(int numOfZeds){
        for (int i = 0; i<numOfZeds; i++) {
            int zedType = random.nextInt(1, 4);
            switch (zedType) {
                case 1:
                    Zombie newWalker = new Walker();
                    horde.add(newWalker);
                    break;
                case 2:
                    Zombie newRunner = new Runner();
                    horde.add(newRunner);
                    break;
                case 3:
                    Zombie newTank = new Tank();
                    horde.add(newTank);
                    break;
                default:
                    System.out.println("invalid");
                    break;
            }
        }
    }

    private void displayHorde(ArrayList zombies){
        for (Object zombie: zombies){
            System.out.println(zombie);
        }
    }
}
