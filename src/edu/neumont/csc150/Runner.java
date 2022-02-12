package edu.neumont.csc150;

public class Runner extends Zombie{

    private int baseHP;
    private int speed;

    private final int HP_MIN = 10;
    private final int HP_MAX = 22;
    private final int SPEED_MIN = 15;
    private final int SPEED_MAX = 25;

    private String attackType;
    private int damageDone;

    public Runner(){
        setArms(generateRandom(ARM_LEG_MIN, ARM_LEG_MAX));
        setLegs(generateRandom(ARM_LEG_MIN, ARM_LEG_MAX));
        setBaseHP(generateRandom(HP_MIN, HP_MAX));
        setSpeed(generateRandom(SPEED_MIN, SPEED_MAX));
        getAttackType(roll(1, 20));
        getDamage(attackType);
    }
    public Runner(int arms, int legs, int baseHP, int speed){
        setArms(arms);
        setLegs(legs);
        setBaseHP(baseHP);
        setSpeed(speed);
    }

    public int returnClimbSpeed(){
        return speed*(1/3);
    }

    @Override
    public void setBaseHP(int newBaseHP) {
        if (newBaseHP<=HP_MAX && newBaseHP>=HP_MIN){
            baseHP = newBaseHP;
        } else {
            throw new IllegalArgumentException("BaseHP entered is not in proper range. A random one will be generated.");
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
        if (rollValue<5){
            attackType = "missed";
        } else if (rollValue>=5 && rollValue<=18){
            attackType = "hit";
        } else if (rollValue>=19 && rollValue<=20){
            attackType = "critical";
        }
        return attackType;
    }

    @Override
    public void getDamage(String attackType) {
        if (attackType.equals("missed")){
            damageDone = 0;
        } else if(attackType.equals("hit")){
            damageDone = roll(2,8);
        } else if(attackType.equals("critical")){
            damageDone = (roll(2,8)*2);
        }
    }

    @Override
    public String toString() {
        return "Runner{" +
                " arms=" + arms +
                ", legs=" + legs +
                ", baseHP=" + baseHP +
                ", speed=" + speed +
                ", attackType='" + attackType + '\'' +
                ", damageDone=" + damageDone +
                '}';
    }
}
