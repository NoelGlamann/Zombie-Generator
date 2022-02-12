package edu.neumont.csc150;

public class Walker extends Zombie{

    private int baseHP;
    private int speed;

    private final int HP_MIN = 15;
    private final int HP_MAX = 30;
    private final int SPEED_MIN = 6;
    private final int SPEED_MAX = 10;

    private String attackType;
    private int damageDone;

    public Walker(){
        setArms(generateRandom(ARM_LEG_MIN, ARM_LEG_MAX));
        setLegs(generateRandom(ARM_LEG_MIN, ARM_LEG_MAX));
        setBaseHP(generateRandom(HP_MIN, HP_MAX));
        setSpeed(generateRandom(SPEED_MIN, SPEED_MAX));
        getAttackType(roll(1, 20));
        getDamage(attackType);
    }
    public Walker(int arms, int legs, int baseHP, int speed){
        setArms(arms);
        setLegs(legs);
        setBaseHP(baseHP);
        setSpeed(speed);
    }

    @Override
    public void setBaseHP(int newBaseHP) {
        if (newBaseHP<=HP_MAX && newBaseHP>=HP_MIN){
            baseHP = newBaseHP;
        } else {
            throw new IllegalArgumentException("*ERROR* BaseHP entered is not in proper range.");
        }
    }

    @Override
    public void setSpeed(int newSpeed) {
        if (newSpeed<=SPEED_MAX && newSpeed>=SPEED_MIN){
            speed = newSpeed;
        } else {
            throw new IllegalArgumentException("*ERROR* New speed entered is not in proper range.");
        }
    }

    @Override
    public String getAttackType(int rollValue) {
        if (rollValue<8){
            attackType = "missed";
        } else if (rollValue>=8 && rollValue<=19){
            attackType = "hit";
        } else if (rollValue == 20){
            attackType = "critical";
        }else{
            attackType = "invalid roll value";
        }
        return attackType;
    }

    @Override
    public void getDamage(String attackType) {
        if (attackType.equals("missed")){
            damageDone = 0;
        } else if(attackType.equals("hit")){
            damageDone =  roll(3,6);
        } else if(attackType.equals("critical")){
            damageDone = (roll(3,6)*2);
        }
    }

    @Override
    public String toString() {
        return "Walker{" +
                " arms=" + arms +
                ", legs=" + legs +
                ", baseHP=" + baseHP +
                ", speed=" + speed +
                ", attackType='" + attackType + '\'' +
                ", damageDone=" + damageDone +
                '}';
    }
}
