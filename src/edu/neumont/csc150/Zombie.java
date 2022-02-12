package edu.neumont.csc150;

import java.util.Random;

public abstract class Zombie {
    Random random = new Random();

    protected int arms;
    protected int legs;
    protected int baseHP;
    protected int speed;
    protected final int ARM_LEG_MIN = 0;
    protected final int ARM_LEG_MAX = 2;


    public int getArms() {
        return arms;
    }
    public void setArms(int newArms) {
        if (newArms>=ARM_LEG_MIN && newArms<=ARM_LEG_MAX){
            arms = newArms;
        } else {
            throw new IllegalArgumentException("*ERROR* Arm number entered is not in proper range.");
        }
    }
    public int getLegs() {
        return legs;
    }
    public void setLegs(int newLegs) {
        if (newLegs>=ARM_LEG_MIN && newLegs<=ARM_LEG_MAX){
            legs = newLegs;
        } else {
            throw new IllegalArgumentException("*ERROR* Leg number entered is not in proper range.");
        }
    }
    public int getBaseHP() {
        return baseHP;
    }
    public abstract void setBaseHP(int baseHP);

    public int getSpeed() {
        return speed;
    }
    public abstract void setSpeed(int speed);

    public int generateRandom(int min, int max){
        return  random.nextInt(min, max+1);
    }

    public int roll(int numberOfDice, int numberOfSides){
        int minPossible = numberOfDice;
        int maxPossible = numberOfDice * numberOfSides;
        return generateRandom(minPossible, maxPossible);
    }

    public abstract String getAttackType(int rollValue);
    public abstract void getDamage(String attackType);

    @Override
    public String toString() {
        return "Zombie{" +
                "arms=" + arms +
                ", legs=" + legs +
                ", baseHP=" + baseHP +
                ", speed=" + speed +
                '}';
    }
}
